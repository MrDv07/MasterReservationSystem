import { faPlaneDeparture } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React from 'react'
import { Link } from 'react-router-dom'
import classes from './HomePage.module.css'
import {faTrain} from '@fortawesome/free-solid-svg-icons'
import {faBus} from '@fortawesome/free-solid-svg-icons'

export const HomePage = () => {
  return (
      <div className={classes.homepage}>
          <h1 className="max-w-full mx-auto shadow-slate-900 bg-clip-text font-extrabold text-transparent text-7xl bg-gradient-to-r from-slate-900 to-gray-600  py-14 px-72 text-center font-serif">
    
              Welcome To Master Reservation System
            
          </h1>
          <div className="flex justify-center mt-10">
            <div className="flex justify-around w-full">
              <Link to="/train">
                <div className="bg-gray-800 hover:bg-green-400 text-white font-serif py-20 px-40 rounded bg-opacity-70">
                <FontAwesomeIcon icon={faTrain} className="px-1" />
                  Train
                </div>
              </Link>
              <Link to="/flight">
                <div className="bg-gray-800 hover:bg-green-400 text-white font-serif py-20 px-40 rounded bg-opacity-70">
                <FontAwesomeIcon icon={faPlaneDeparture} className="px-1" />
                  Flight
                </div>
              </Link>
              <Link to="/bus">
                <div className="bg-gray-800 hover:bg-green-400 text-white font-serif py-20 px-40 rounded bg-opacity-70">
                <FontAwesomeIcon icon={faBus} className="px-1" />
                  Bus
                </div>
              </Link>
            </div>
          </div>
      </div>
  )
}
