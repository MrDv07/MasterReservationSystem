import React, { useState } from 'react'
import UserService from '../Services/UserService';

const SignUp = () => {

  const [user, setUser ] = useState({
    name:"",
    age:"",
    gender:"",
    emailId:"",
    phoneNumber:"",
    username:"",
    password:""
  })

  const handleChange = (e) =>{
    const value = e.target.value;
    setUser({...user ,[e.target.name]: value})
  }

  const saveUser = (e) => {
    e.preventDefault();
    UserService.saveUser(user)
     .then((response)=>{
        console.log(response)
        alert("Successfully Resgistered..!!")
    }).catch((err) => {
        console.log(err)
        alert(err)
    })
    
  }


  return (
    <div className="flex max-w-2xl mx-auto shadow border-b">
        <div className="px-8 py-8">
            <div className="text-2xl">
                <h1 className="font-serif">Register</h1>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Full Name</label>
                <input type="text" 
                name='name' 
                value={user.name} 
                onChange={(e)=> handleChange(e)}
                className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Age</label>
                <input type="number" 
                name='age' 
                value={user.age} 
                onChange={(e)=> handleChange(e)}
                className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Gender</label>
                <select 
                name='gender' 
                value={user.gender} 
                className='h-10 w-96 border mt-2 px-2 py-2' onChange={(e)=> handleChange(e)}>
                    <option value=''>Select Gender</option>
                    <option value='male'>Male</option>
                    <option value='female'>Female</option>
                </select>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Phone Number</label>
                <input type="number" 
                name='phoneNumber' 
                value={user.phoneNumber} 
                onChange={(e)=> handleChange(e)}
                className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Email</label>
                <input type="email" 
                name='emailId' 
                value={user.emailId}
                onChange={(e)=> handleChange(e)} 
                className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Username</label>
                <input type="text" 
                name='username' 
                value={user.username}
                onChange={(e)=> handleChange(e)} 
                className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 '>
                <label className='block text-gray-600 text-sm font-normal' >Password</label>
                <input type="password" 
                name='password' 
                value={user.password}
                onChange={(e)=> handleChange(e)} 
                className='h-10 w-96 border mt-2 px-2 py-2'></input>
            </div>
            <div className='items-center justify-center h-14 w-21 my-6 '>
                <div className='flex items-center justify-center h-14 w-full my-4 space-x-4'>
                    <button onClick={saveUser} className='rounded text-white font-semibold bg-green-600 hover:bg-green-900 '>
                        Save
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

export default SignUp