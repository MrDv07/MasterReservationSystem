import React from 'react'
import { Link } from 'react-router-dom';

const Navbar = () => {


  return (
    <div className="bg-gray-900 will-change-scroll">
      <div className="h-16 flex items-center px-5">
        <Link to="/">
          <h1 className="font-serif text-white text-2xl ">Master Reservation System</h1>
        </Link>
        <div className='ml-auto flex px-2'>
          <Link to="/register" className='text-white text-lg mx-3 hover:text-gray-500'>
            Register
          </Link>
          <Link to="/login" className="text-white text-lg mx-3 hover:text-gray-500">
            Login
          </Link>
          <Link to="/transactionhistory" className="text-white text-lg mx-3 hover:text-gray-500">
            Transaction History
          </Link>
        </div>
      </div>
    </div>
  )
}

export default Navbar;