import React, { useState } from 'react'
import FlightBookingService from '../Services/FlightBookingService';


export const FlightBooking = () => {

    const [booking, setbooking ] = useState({
        username:"",
        numberOfMode:"",
        reservationClass:"",
        travelDate:"",
        numberOfPassengers:"",
      })


      const handleChange = (e) =>{
        const value = e.target.value;
        setbooking({...booking ,[e.target.name]: value})
      }


      const saveBooking = (e) => {
        e.preventDefault();
        FlightBookingService.savedBooking(booking)
         .then((response)=>{
            console.log(response)
            alert("Successfully Booked..!!")
        }).catch((err) => {
            console.log(err)
            alert(err)
        })
    }



  return (
    <div className="flex max-w-2xl mx-auto shadow border-b">
        <div className="px-8 py-8">
            <div className="text-2xl">
                <h1 className="font-serif">Flight Booking</h1>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Username</label>
                <input type="text" 
                name='username' 
                value={booking.username}
                onChange={(e)=> handleChange(e)} 
                className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal'>Number Of Flight</label>
                <input type="number" 
                name='numberOfMode' 
                value={booking.numberOfMode} 
                onChange={(e)=> handleChange(e)}
                className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Reservation class</label>
                <select 
                name='reservationClass' 
                value={booking.reservationClass}
                onChange={(e)=> handleChange(e)} 
                className='h-10 w-96 border mt-2 px-2 py-2' >
                    <option value=''>Select Class</option>
                    <option value='EconomyClass'>EconomyClass</option>
                    <option value='BusinessClass'>BusinessClass</option>

                </select>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Travel Date</label>
                <input type="date" 
                name='travelDate' 
                value={booking.travelDate} 
                onChange={(e)=> handleChange(e)}
                className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Number Of Passengers</label>
                <input type="number" 
                name='numberOfPassengers' 
                value={booking.numberOfPassengers} 
                onChange={(e)=> handleChange(e)}
                className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            
            <div className='items-center justify-center h-14 w-21 my-6 '>
                <div className='flex items-center justify-center h-14 w-full my-4 space-x-4'>
                    <button onClick={saveBooking} className='rounded text-white font-semibold bg-green-600 hover:bg-green-900 '>
                        Submit
                    </button>
                    <button className='rounded text-white font-semibold bg-red-500 hover:bg-red-900 '>
                        Clear
                    </button>
                </div>
            </div>
        </div>
    </div>
  )
}
