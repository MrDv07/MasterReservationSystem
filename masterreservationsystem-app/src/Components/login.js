const Login = () =>{
    return (
            <div className="flex max-w-2xl mx-auto shadow border-b">
                <div className="px-8 py-8">
                    <div className="text-2xl">
                        <h1 className="font-serif">Login</h1>
                    </div>
                    <div className='items-center justify-center h-14 w-full my-4 '>
                        <label className='block text-gray-600 text-sm font-normal' >Username</label>
                        <input type="text" 
                        name='username' 
                        // value={user.username}
                        // onChange={(e)=> handleChange(e)} 
                        className='h-10 w-96 border mt-2 px-2 py-2'></input>
                    </div>
                    <div className='items-center justify-center h-14 w-full my-4 '>
                        <label className='block text-gray-600 text-sm font-normal' >Password</label>
                        <input type="password" 
                        name='password' 
                        // value={user.password}
                        // onChange={(e)=> handleChange(e)} 
                        className='h-10 w-96 border mt-2 px-2 py-2'></input>
                    </div>
                    <div className='items-center justify-center h-14 w-21 my-6 '>
                        <div className='flex items-center justify-center h-14 w-full my-4 space-x-4'>
                            <button className='rounded text-white font-semibold bg-green-600 hover:bg-green-900 '>
                                Submit
                            </button>
                            {/* <button className='rounded text-white font-semibold bg-red-500 hover:bg-red-900 '>
                                Clear
                            </button> */}
                        </div>
                    </div>
                </div>
            </div>
          )
 }
    


export default Login