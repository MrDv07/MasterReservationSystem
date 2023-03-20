import axios from "axios";

const TRAINBOOKING_API_BASE_URL = "http://localhost:9095/api/v1/booking/TrainTicket"
const TRAINBOOKING_API_BASE_URL_1 = "http://localhost:9092/api/v1/train/findtrainbystation"


class TrainBookingService{

    saveBooking(booking){
        return axios.post(TRAINBOOKING_API_BASE_URL, booking)
    }

    getTrain(source , destination , config){
        return axios.get(TRAINBOOKING_API_BASE_URL_1 + "/" + source + "/" + destination , config )
    }

}


export default new TrainBookingService();