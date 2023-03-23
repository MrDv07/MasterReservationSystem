import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import { Bus } from './Components/Bus';
import BusBooking from './Components/BusBooking';
import { Flight } from './Components/Flight';
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
            <Route path="/flight" element={<Flight/>}/>
            <Route path="/bus" element={<Bus/>}/>
            <Route path="/trainbooking" element={<TrainBooking/>}/>
            <Route path="/flightbooking" element={<FlightBooking/>}/>
            <Route path="/busbooking" element={<BusBooking/>}/>
            <Route path="/transactionhistory" element={<TransactionHistory/>}/>
          </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
