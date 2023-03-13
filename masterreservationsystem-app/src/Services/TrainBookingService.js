import axios from "axios";

const TRAINBOOKING_API_BASE_URL = "http://localhost:9095/api/v1/booking/TrainTicket"


class TrainBookingService{

    saveBooking(booking){
        return axios.post(TRAINBOOKING_API_BASE_URL, booking)
    }

}

// eslint-disable-next-line import/no-anonymous-default-export
export default new TrainBookingService();