import axios from "axios"

const BusBooking_Api_Base_Url = "http://localhost:9095/api/v1/booking/BusTicket"


class BusBookingService{

    savedBooking(booking){
        return axios.post(BusBooking_Api_Base_Url, booking)
    }
}

export default new BusBookingService()