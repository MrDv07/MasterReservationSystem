
import React, { useEffect, useState } from 'react';
import BookingHistory from '../Services/BookingHistory';


export const TransactionHistory = () => {

  const [loading, setLoading] = useState(true)
  const [booking , setBooking] = useState([])
  const [username, setUsername] = useState('');


  
  useEffect(()=>{

    const fetchBookings= async ()=>{
      setLoading(true);
      try {
        const config = {
          maxRedirects: 0,
          validateStatus: function (status) {
            return status >= 200 && status < 303;
          },
        };   
        const response = await BookingHistory.getBookingByUsername(username , config);
        setBooking(response.data)
        console.log(response.data)
      } catch (error) {
        console.log(error)
        alert(error)
      }
      setLoading(false)
    }
    if(username !== ""){
      fetchBookings()
    }
  }, [username])

  const deleteBooking = (e , id) => {
    e.preventDefault()
    BookingHistory.deleteBooking(id).then((res) => {
      setBooking((prevElement) => {
        return prevElement.filter((booking)=> booking.id !== id)
      } )
    })
  }


  return (
    <>
    <div className="flex max-w-2xl mx-left shadow border-b h-80">
    <div className="px-8 py-8">
        <div className="text-2xl">
            <h1 className="font-serif">Enter your username</h1>
        </div>
        <div className='items-center justify-center h-14 w-full my-4 '>
            <label className='block text-gray-600 text-sm font-normal' >Username</label>
            <input required type="text" 
            name='username' 
            value={username} 
            onChange={(e)=> setUsername(e.target.value)}
            className='h-10 w-96 border mt-2 px-2 py-2'></input>
        </div>
        {/* <div className='items-center justify-center h-14 w-21 my-6 '>
            <div className='flex items-center justify-center h-14 w-full my-4 space-x-4'>
                <button 
                onClick={() => setUsername('')} 
                className='rounded text-white font-semibold bg-green-600 hover:bg-green-900 '>
                    Search
                </button>
            </div>
        </div> */}
    </div>
  </div>

    <div className='mx-auto flex shadow border-b py-5'>
        <table className='min-w-full'>
          <thead className='bg-blue-500'>
            <tr>
              <th className='text-xs font-thin uppercase py-6'>Username</th>
              <th className='text-xs font-thin uppercase py-6'>Travel Type</th>
              <th className='text-xs font-thin uppercase py-6'>Number Of Mode</th>
              <th className='text-xs font-thin uppercase py-6'>Name Of Mode</th>
              <th className='text-xs font-thin uppercase py-6'>Booking Date</th>
              <th className='text-xs font-thin uppercase py-6'>Date of Travel</th>
              <th className='text-xs font-thin uppercase py-6'>Reservation Class</th>
              <th className='text-xs font-thin uppercase py-6'>Source</th>
              <th className='text-xs font-thin uppercase py-6'>Destination</th>
              <th className='text-xs font-thin uppercase py-6'>Number Of Passengers</th>
              <th className='text-xs font-thin uppercase py-6'>Hours of Journey</th>
              <th className='text-xs font-thin uppercase py-6'>Total Fare</th>
              <th className='text-xs font-thin uppercase py-6'>Action</th>
            </tr>
          </thead>

          <tbody>
          {loading ? (
            <tr>
              <td>Loading...</td>
            </tr>
          ) : (
            booking.map((booking) => (
            <tr key={booking.Id}>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.username}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.serviceType}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.numberOfMode}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.nameOfMode}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.bookingDate}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.travelDate}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.reservationClass}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.source}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.destination}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.numberOfPassengers}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.hoursOfJourney}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>{booking.fare}</td>
              <td className='text-left px-6 py-2 whitespace-nowrap text-xs text-gray-600'>
                <button onClick={(e , id) => deleteBooking(e , booking.Id)} className='rounded text-white font-semibold bg-red-600 hover:bg-red-900 '>
                  Cancel
                </button>
              </td>
            </tr>
             )))}
          </tbody>
        </table>
      </div>
    </>
  )
}


export default TransactionHistory;