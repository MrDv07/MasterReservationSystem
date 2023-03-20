import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import TrainBookingService from '../Services/TrainBookingService';

export const Train = () => {

  const [loading , setLoading] = useState(false);
  const [train , setTrain] = useState([]);
  const [source, setSource] = useState('')
  const [destination , setdestination] = useState('')
  const navigate = useNavigate

  const onClickHandler = ()=>{
    navigate("/register")
  }


  useEffect(()=>{
    const fetchTrain = async () =>{
      setLoading(true);
      try {
        const config = {
          maxRedirects: 0,
          validateStatus: function (status) {
            return status >= 200 && status < 303;
          },
        };  
        const response = await TrainBookingService.getTrain(source , destination, config)
        setTrain(response.data)
        console.log(response.data) 
      } catch (error) {
        console.error(error)
        alert(error)
        setLoading([])
      }
      setLoading(false)
    }

    if(source && destination){
      fetchTrain()
    }
  }, [source , destination]);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (source && destination) {
      useEffect.fetchTrain();
    }
  };

  

  return (
    <>
    <div className="flex max-w-2xl mx-left shadow border-b h-80">
    <div className="px-8 py-8">
        <div className="text-2xl">
            <h1 className="font-serif">Train Search</h1>
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
            <div className='items-center justify-center h-14 w-21 my-6 '>
                <div className='flex items-center justify-center h-14 w-full my-4 space-x-4'>
                    <button 
                    onClick={() => useEffect.fetchTrain()} 
                    className='rounded text-white font-semibold bg-green-600 hover:bg-green-900 '>
                        Search
                    </button>
                </div>
            </div>
        </form>
    </div>
  </div>

  <div className='flex shadow border-b max-w-full mx-auto'>
        <table className='min-w-full my-32'>
          <thead className='bg-blue-500 py-56'>
            <tr>
              <th className='text-xs font-thin uppercase py-6'>Train Number</th>
              <th className='text-xs font-thin uppercase py-6'>Name Of Train</th>
              <th className='text-xs font-thin uppercase py-6'>Source</th>
              <th className='text-xs font-thin uppercase py-6'>Destination</th>
              <th className='text-xs font-thin uppercase py-6'>Hours of Journey</th>
              <th className='text-xs font-thin uppercase py-6'>Number Of Stops</th>
              <th className='text-xs font-thin uppercase py-6'>Sleeper Fare</th>
              <th className='text-xs font-thin uppercase py-6'>1 AC Fare</th>
              <th className='text-xs font-thin uppercase py-6'>2 AC Fare</th>
              <th className='text-xs font-thin uppercase py-6'>3 AC Fare</th>
              <th className='text-xs font-thin uppercase py-6'>Action</th>
            </tr>
          </thead>

          <tbody>
          {loading ? (
            <tr>
              <td>Loading...</td>
            </tr>
          ) : (
            train.map((train) => (
            <tr key={train.id}>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{train.id}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{train.trainName}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{train.source}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{train.destination}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{train.hoursOfJourney}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{train.numbeerOfStops}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{train.fareOfSleeperClass}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{train.fareOf1Ac}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{train.fareOf2Ac}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{train.fareOf3Ac}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>
                <Link to="/trainbooking">
                    <button 
                    onClick={onClickHandler}
                    className='rounded text-white font-semibold bg-red-600 hover:bg-red-900 '>
                      Book
                    </button>
                </Link>
              </td>
            </tr>
             )))}
          </tbody>
        </table>
      </div>
    </>
  )
}


export default Train
