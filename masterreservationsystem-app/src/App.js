import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import BusBooking from './Components/BusBooking';
import FlightBooking from './Components/FlightBooking';
import { HomePage } from './Components/HomePage';
import Login from './Components/login';
import Navbar from './Components/Navbar';
import SignUp from './Components/SignUp';
import { Train } from './Components/Train';
import TrainBooking from './Components/TrainBooking';
import TransactionHistory from './Components/TransactionHistory';

function App() {
  return (
    <>
    <BrowserRouter>
          <Navbar/>
          <Routes>
            <Route path="/" element={<HomePage/>}/>
            <Route path="/register" element={<SignUp/>} />
            <Route path="/login" element={<Login/>}/>
            <Route path="/train" element={<Train/>}/>
            <Route path="/trainbooking" element={<TrainBooking/>}/>
            <Route path="/flight" element={<FlightBooking/>}/>
            <Route path="/bus" element={<BusBooking/>}/>
            <Route path="/transactionhistory" element={<TransactionHistory/>}/>
          </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
