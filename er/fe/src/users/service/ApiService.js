import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/users"

class ApiService {

   

    showAllUser(){
        return axios.get(USER_API_BASE_URL + '/list');
    }
    addUser(ID){
        return axios.post(USER_API_BASE_URL + '/join' + ID);
    }
    editUser(no){
        return axios.put(USER_API_BASE_URL + '/' + no);
    }
    updateUser(user, no){
        return axios.get(USER_API_BASE_URL + '/' + no, user);
    }
    deleteUser(no){
        return axios.delete(USER_API_BASE_URL + '/' + no);
    }

}
export default new ApiService;