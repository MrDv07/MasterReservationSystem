import axios from "axios";

const FlightBooking_Api_Base_Url = "http://localhost:9095/api/v1/booking/FlightTicket"

class FlightBookingService{

    savedBooking(booking){
        return axios.post(FlightBooking_Api_Base_Url , booking)
    }
}


export default new FlightBookingService()