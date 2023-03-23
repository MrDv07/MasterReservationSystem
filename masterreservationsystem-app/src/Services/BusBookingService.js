import axios from "axios"

const BusBooking_Api_Base_Url = "http://localhost:9095/api/v1/booking/BusTicket"
const BusBooking_Api_Base_Url_1 = "http://localhost:9094/api/v1/bus/findbusbystations"


class BusBookingService{

    savedBooking(booking){
        return axios.post(BusBooking_Api_Base_Url, booking)
    }

    getBus(source , destination , config){
        return axios.get(BusBooking_Api_Base_Url_1 + "/" + source + "/" + destination , config)
    }
}

export default new BusBookingService()