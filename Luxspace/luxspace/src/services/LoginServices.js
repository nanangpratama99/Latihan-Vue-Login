import http from '../http-common';

class LoginServices {
    // Create Data
    login(data) {
        return http.post("/students/login", data);
    }

    register(data){
        return http.post("/students/register", data)
    }

}

export default new LoginServices();