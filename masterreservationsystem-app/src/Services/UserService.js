import axios from "axios";

const User_API_BASE_URL = "http://localhost:9091/api/v1/user"


class UserService{

    saveUser(user){
        return axios.post(User_API_BASE_URL, user)
    }

}

export default new UserService();