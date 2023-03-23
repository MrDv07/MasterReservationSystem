import axios from "axios";

const FlightBooking_Api_Base_Url = "http://localhost:9095/api/v1/booking/FlightTicket"

const FlightBooking_Api_Base_Url_1 = "http://localhost:9093/api/v1/flight/findflightbyairports"

class FlightBookingService{

    savedBooking(booking){
        return axios.post(FlightBooking_Api_Base_Url , booking)
    }

    getFlight(source , destination ,config ){
        return axios.get(FlightBooking_Api_Base_Url_1 + "/" + source + "/" + destination , config)
    }
}


export default new FlightBookingService()