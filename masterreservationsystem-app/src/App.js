import './App.css';
import { TrainBooking } from './Components/TrainBooking';
import Login from './Components/login';
import Navbar from './Components/Navbar';
import SignUp from './Components/SignUp';
import { FlightBooking } from './Components/FlightBooking';

function App() {
  return (
    <>
      <Navbar/>
      <SignUp/>
      <Login/>
      <TrainBooking/>
      <FlightBooking/>
    </>
  
  );
}

export default App;
