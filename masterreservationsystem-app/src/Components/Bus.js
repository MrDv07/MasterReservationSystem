import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import BusBookingService from '../Services/BusBookingService';
import classes from './HomePage.module.css'

export const Bus = () => {
    const [loading , setLoading] = useState(false);
    const [bus , setBus] = useState([]);
    const [source, setSource] = useState('')
    const [destination , setdestination] = useState('')
    const navigate = useNavigate()
  
    const onClickHandler = ()=>{
      navigate("/busbooking")()
    }
  
    useEffect(()=>{
      const fetchBus = async () =>{
        setLoading(true);
        try {
          const config = {
            maxRedirects: 0,
            validateStatus: function (status) {
              return status >= 200 && status < 303;
            },
          };  
          const response = await BusBookingService.getBus(source , destination , config)
          setBus(response.data)
          console.log(response.data) 
        } catch (error) {
          console.error(error)
          alert(error)
          setLoading([])
        }
        setLoading(false)
      }
  
      if(source && destination){
        fetchBus()
      }
    }, [source , destination]);
  
    const handleSubmit = (e) => {
      e.preventDefault();
      if (source && destination) {
        useEffect.fetchBus();
      }
    };
  
    
  
    return (
      <>
      <div className={classes.bus}>
        <div className="flex max-w-2xl mx-left shadow border-b h-80">
        <div className="px-8 py-8">
            <div className="text-2xl">
                <h1 className="font-serif">Bus Search</h1>
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
                  <th className='text-xs font-thin uppercase py-6'>Bus Number</th>
                  <th className='text-xs font-thin uppercase py-6'>Name Of Bus</th>
                  <th className='text-xs font-thin uppercase py-6'>Source</th>
                  <th className='text-xs font-thin uppercase py-6'>Destination</th>
                  <th className='text-xs font-thin uppercase py-6'>Hours of Journey</th>
                  <th className='text-xs font-thin uppercase py-6'>Number Of Stops</th>
                  <th className='text-xs font-thin uppercase py-6'>Sitter </th>
                  <th className='text-xs font-thin uppercase py-6'>Sleeper</th>
                  <th className='text-xs font-thin uppercase py-6'>Action</th>
                </tr>
              </thead>
  
              <tbody>
              {loading ? (
                <tr>
                  <td>Loading...</td>
                </tr>
              ) : (
                bus.map((bus) => (
                <tr key={bus.id}>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{bus.id}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{bus.busName}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{bus.source}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{bus.destination}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{bus.hoursOfJourney}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{bus.numberOfStops}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{bus.fareOfSitter}</td>
                  <td className='text-left px-10 py-2 whitespace-nowrap text-xs text-white'>{bus.fareOfSleeper}</td> 
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
