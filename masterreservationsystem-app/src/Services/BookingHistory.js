import axios from "axios";

const BookingHistory_Api_Base_Url = "http://localhost:9095/api/v1/booking/findallbyusername"
const BookingHistory_Api_Base_Url_2 = "http://localhost:9095/api/v1/booking/findbyusername"
const BookingHistory_Api_Base_Url_1 = "http://localhost:9095/api/v1/booking/deletebooking"


class BookingHistory{

    getBooking(){
        return axios.get(BookingHistory_Api_Base_Url)
    }

    deleteBooking(id){
        return axios.delete(BookingHistory_Api_Base_Url_1 + "/" + id )
    }

    getBookingByUsername(username , config){
        return axios.get(BookingHistory_Api_Base_Url_2 + "/" + username , config )
    }
}


export default new BookingHistory();