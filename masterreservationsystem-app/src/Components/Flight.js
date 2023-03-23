import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import FlightBookingService from '../Services/FlightBookingService';
import classes from './HomePage.module.css'

export const Flight = () => {
    const [loading , setLoading] = useState(false);
    const [flight , setFlight] = useState([]);
    const [source, setSource] = useState('')
    const [destination , setdestination] = useState('')
    const navigate = useNavigate()
  
    const onClickHandler = ()=>{
      navigate("/flightbooking")()
    }
  
    useEffect(()=>{
      const fetchFlight = async () =>{
        setLoading(true);
        try {
          const config = {
            maxRedirects: 0,
            validateStatus: function (status) {
              return status >= 200 && status < 303;
            },
          };  
          const response = await FlightBookingService.getFlight(source , destination , config)
          setFlight(response.data)
          console.log(response.data) 
        } catch (error) {
          console.error(error)
          alert(error)
          setLoading([])
        }
        setLoading(false)
      }
  
      if(source && destination){
        fetchFlight()
      }
    }, [source , destination]);
  
    const handleSubmit = (e) => {
      e.preventDefault();
      if (source && destination) {
        useEffect.fetchFlight();
      }
    };
  
    
  
    return (
      <>
      <div className={classes.flight}>
        <div className="flex max-w-2xl mx-left shadow border-b h-80">
        <div className="px-8 py-8">
            <div className="text-2xl">
                <h1 className="font-serif">Flight Search</h1>
            </div>
            <form onSubmit={handleSubmit}>
                <div className='items-center justify-center h-14 w-full my-4 '>
                    <label className='block text-gray-600 text-sm font-normal' >Source</label>
                    <input required type="text" 
                    name='source' 
                    value={source} 
                    onChange={(e)=> setSource(e.target.value)}
                    className='h-10 w-96 border mt-2 px-2 py-2'></input>
                </div>
                <div className='items-center justify-center h-14 w-full '>
                    <label className='block text-gray-600 text-sm font-normal' >Destination</label>
                    <input required type="text" 
                    name='destination' 
                    value={destination} 
                    onChange={(e)=> setdestination(e.target.value)}
                    className='h-10 w-96 border mt-2 px-2 py-2'></input>
                </div>
            </form>
        </div>
      </div>
  
      <div className='flex shadow border-b max-w-full mx-auto'>
            <table className='min-w-full my-32'>
              <thead className='bg-blue-500 py-56'>
                <tr>
                  <th className='text-xs font-thin uppercase py-6'>Flight Number</th>
                  <th className='text-xs font-thin uppercase py-6'>Name Of flight</th>
                  <th className='text-xs font-thin uppercase py-6'>Source</th>
                  <th className='text-xs font-thin uppercase py-6'>Destination</th>
                  <th className='text-xs font-thin uppercase py-6'>Hours of Journey</th>
                  <th className='text-xs font-thin uppercase py-6'>Number Of Stops</th>
                  <th className='text-xs font-thin uppercase py-6'>Business Class</th>
                  <th className='text-xs font-thin uppercase py-6'>Economy Class</th>
                  <th className='text-xs font-thin uppercase py-6'>Action</th>
                </tr>
              </thead>
  
              <tbody>
              {loading ? (
                <tr>
                  <td>Loading...</td>
                </tr>
              ) : (
                flight.map((flight) => (
                <tr key={flight.id}>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{flight.id}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{flight.flightName}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{flight.source}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{flight.destination}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{flight.hoursOfJourney}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{flight.numberOfStops}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{flight.fareOfBusinessClass}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{flight.fareOfEconomyClass}</td> 
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-gray-600'>
                        <button 
                        onClick={onClickHandler}
                        className='rounded text-white font-semibold bg-red-600 hover:bg-red-900 '>
                          Book
                        </button>
                  </td>
                </tr>
                )))}
              </tbody>
            </table>
          </div>
      </div>
      </>
    )
  }
