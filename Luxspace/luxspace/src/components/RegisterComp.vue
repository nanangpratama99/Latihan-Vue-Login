<template>
  <div class="container">
    <div class="title">Registration</div>
    <form action="#" @submit.prevent="RegistFunc">
      <div class="user-details">
        <div class="input-box">
          <span class="span-details">Full Name</span>
          <input
            v-model="infoRegist.nama"
            type="text"
            name="name"
            id="fullname"
            placeholder="Full Name"
            required
          />
        </div>
        <div class="input-box">
          <div class="span-details">Username</div>
          <input
            v-model="infoRegist.username"
            type="text"
            name="username"
            id="username"
            placeholder="Input Username"
            required
          />
        </div>
        <div class="input-box">
          <div class="span-details">Email</div>
          <input
            v-model="infoRegist.email"
            type="text"
            name="email"
            id="email"
            placeholder="Input Email"
            required
          />
        </div>
        <div class="input-box">
          <div class="span-details">Phone Number</div>
          <input
            v-model="infoRegist.phone_number"
            type="text"
            name="phone_number"
            id="phone_number"
            placeholder="Input Phone Number"
            required
          />
        </div>
        <div class="input-box-password">
          <div class="sub-input-box">
            <div class="span-details">Password</div>
            <input
              v-model="infoRegist.password"
              type="password"
              name=""
              id="pass1"
              placeholder="Input Pasword"
              required
            />
          </div>
          <div class="sub-input-box">
            <div class="span-details">Confirm Password</div>
            <input
              v-model="verifpass"
              type="password"
              name=""
              id="pass2"
              placeholder="Repeat Pasword"
              required
            />
          </div>
        </div>
        <p class="text-danger" v-show="success">Maaf! Password Salah</p>
      </div>

      <div class="gender-details">
        <input v-model="infoRegist.gender" type="radio" value="Male" name="gender" id="dot-1" />
        <input v-model="infoRegist.gender" type="radio" value="Female" name="gender" id="dot-2" />
        <input v-model="infoRegist.gender" type="radio" value="Netral" name="gender" id="dot-3" />
        <span class="gender-title">Gender</span>
        <div class="category">
          <label for="dot-1">
            <span class="dot one"></span>
            <span class="gender">Male</span>
          </label>
          <label for="dot-2">
            <span class="dot two"></span>
            <span class="gender">Female</span>
          </label>
          <label for="dot-3">
            <span class="dot three"></span>
            <span class="gender">Prefer not to Say</span>
          </label>
        </div>
      </div>

      <div class="button">
        <input type="submit" value="Register" />
      </div>

      <div>
        <p>Already Have an account</p>
        <router-link to="/">
          <a href="">Please Login</a>
        </router-link>
      </div>
    </form>
  </div>
</template>

<script>
import LoginServices from "@/services/LoginServices";

export default {
  name: "RegisterS",
  data() {
    return {
      infoRegist: {
        email: null,
        gender: null,
        nama: null,
        password: null,
        phone_number: null,
        username: null,
      },
      verifpass: null,
      success: false,
    };
  },
  methods: {
    RegistFunc() {
      // this.infoRegist.password = this.
      // console.log(
      //   this.$CryptoJS.AES.encrypt(this.verifpass).toString()
      // );
      // console.log(typeof(this.infoRegist.password))
      let data = this.infoRegist;
      if (data.password === this.verifpass) {
        LoginServices.register(data)
          .then((response) => {
            console.log(response.data);
            this.$router.push("/");
          })

          .catch((e) => {
            console.log(e);
          });
      } else {
        this.success = true;
      }
    },
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: sans-serif;
}

body {
  padding: 10px;
  display: flex;
  height: 100vh;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

/* =========================== Registration =========================== */
.container {
  max-width: 500px;
  width: 100%;
  background: #fff;
  padding: 30px 40px;
  border-radius: 30px;
  border: 2px solid purple;
}

.container .title {
  font-size: 25px;
  font-weight: 500;
  position: relative;
  text-align: center;
  padding-top: 30px;
  padding-bottom: 30px;
}

.container .title:before {
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  height: 4px;
  width: 100%;
  background: #9b59b6;
  border-radius: 5px;
}

.container form .user-details {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  margin: 10px 0 12px 0;
}

form .user-details .input-box {
  margin-bottom: 15px;
  width: 100%;
}

.user-details .input-box input {
  height: 50px;
  width: 100%;
  outline: none;
  border-radius: 30px;
  border: 1px solid #ccc;
  padding-left: 20px;
  font-size: 16px;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
  margin-top: 5px;
}

.user-details .input-box .details {
  font-weight: 500;
  margin-bottom: 5px;
  display: block;
}

.user-details .input-box input:focus,
.user-details .input-box input:valid {
  border-color: #9b59b6;
}

.input-box-password {
  display: flex;
  justify-content: space-around;
  width: 100%;
}

.sub-input-box input {
  width: 100px;
  height: 45px;
  border-radius: 30px;
}

.user-details .input-box-password input:focus,
.user-details .input-box-password input:valid {
  border-color: #9b59b6;
}

.user-details .input-box-password .details {
  font-weight: 500;
  margin-bottom: 5px;
  display: block;
}

.user-details .input-box-password input {
  height: 50px;
  width: 100%;
  outline: none;
  border-radius: 30px;
  border: 1px solid #ccc;
  padding-left: 10px;
  font-size: 16px;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
  margin-top: 5px;
  margin-bottom: 10px;
}

form .gender-details .gender-title {
  font-size: 20px;
  font-weight: 500;
}

form .gender-details .category {
  width: 805;
  margin: 14px 0;
  display: flex;
  justify-content: space-between;
}

.gender-details .category label {
  display: flex;
  align-items: center;
}

.gender-details .category .dot {
  height: 18px;
  width: 18px;
  background: #d9d9d9;
  border-radius: 50%;
  margin-right: 15px;
  border: 5px solid transparent;
  transition: all 0.3s ease;
  margin-top: 10px;
}

#dot-1:checked ~ .category label .one,
#dot-2:checked ~ .category label .two,
#dot-3:checked ~ .category label .three {
  border-color: #d9d9d9;
  background: #9b59b6;
}

form input[type="radio"] {
  display: none;
}

form .button {
  height: 50px;
  margin: 45px 0;
  align-items: center;
}

form .button input {
  height: 100%;
  width: 80%;
  outline: none;
  color: #fff;
  background: linear-gradient(135deg, #71b7e6, #9b59b6);
  border: none;
  font-size: 18px;
  font-weight: 500;
  letter-spacing: 1px;
  border-radius: 30px;
}

.button {
  display: flex;
  justify-content: center;
}

form .button input:hover {
  background: linear-gradient(-135deg, #71b7e6, #9b59b6);
  cursor: pointer;
}
</style>