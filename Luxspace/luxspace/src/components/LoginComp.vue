<template>
  <div class="container-login">
    <div class="title">Login</div>
    <form action="#" @submit.prevent="LoginFunc">
      <div class="user-details">
        <div class="input-login">
          <div class="span-details">Email</div>
          <input
            v-model="LoginInfo.email"
            type="text"
            name=""
            id=""
            placeholder="Input Email"
            required
          />
        </div>
        <div class="input-login">
          <div class="span-details">Password</div>
          <input
            v-model="LoginInfo.password"
            type="password"
            name="password"
            id="password"
            placeholder="Input Pasword"
            required
          />
        </div>
      </div>
      <div class="button-login">
        <input type="submit" value="Login" />
      </div>
      <div>
        <p>Don't have an account</p>
        <router-link to="/register">
          <p>Register Now</p>
        </router-link>
      </div>
    </form>
  </div>
</template>

<script>
import LoginServices from "@/services/LoginServices";
// import Vue from 'vue'

export default {
  name: "LoginComp",
  data() {
    return {
      LoginInfo: {
        email: null,
        password: null,
      },
    };
  },
  methods: {
    LoginFunc() {
      let data = this.LoginInfo;
      console.log(data.email + data.password);
      // localStorage.set
      LoginServices.login(data)
        .then((response) => {
          console.log(response.data);
          this.$session.start();
          this.$session.flash.set("jwt", response.data);
          // Vue.http.headers.common['Authorization'] = 'Bearer ' + response.data
          this.$router.push("/home");
          let test = this.$session.getAll();
          console.log(test);
        })
        .catch((e) => {
          console.log(e);
          alert("Login Gagal");
        });
    },
    // TestVmodel(){
    //   let data = this.LoginInfo;
    //   console.log(data)
    // }
  },
  created() {
    console.log(this.$session.getAll());
  },
  // mounted(){
  //   this.TestVmodel(this.LoginInfo);
  // }
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

.container {
  max-width: 500px;
  width: 100%;
  background: #fff;
  padding: 30px 40px;
  border-radius: 30px;
}

/* ======================= login ============================ */
.container-login {
  max-width: 400px;
  width: 100%;
  background: #fff;
  padding: 30px 40px;
  border-radius: 30px;
  height: 90%;
  border: 2px solid rgba(128, 0, 128, 0.667);
}

.container-login .title {
  font-size: 25px;
  font-weight: 500;
  position: relative;
  text-align: center;
  padding-top: 30px;
  padding-bottom: 30px;
}

.container-login .title:before {
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  height: 4px;
  width: 100%;
  background: #9b59b6;
  border-radius: 5px;
}

.container-login form .user-details {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 30px 0px 15px 0;
}

form .user-details .input-login {
  margin-bottom: 15px;
  width: 100%;
}

form .user-details .input-login {
  margin-bottom: 25px;
  width: 100%;
}

.user-details .input-login input {
  height: 50px;
  width: 100%;
  outline: none;
  border-radius: 25px;
  border: 1px solid #ccc;
  padding-left: 10px;
  font-size: 16px;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
  margin-top: 15px;
}

.user-details .input-login .details {
  font-weight: 500;
  margin-bottom: 10px;
  display: block;
}

.user-details .input-login input:focus,
.user-details .input-login input:valid {
  border-color: #9b59b6;
}

/* button login */
form .button-login {
  height: 50px;
  margin: 45px 0;
  align-items: center;
}

form .button-login input {
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

.button-login {
  display: flex;
  justify-content: center;
}

form .button-login input:hover {
  background: linear-gradient(-135deg, #71b7e6, #9b59b6);
  cursor: pointer;
}

@media (max-width: 584px) {
  .container {
    max-width: 100%;
  }

  form .user-details .input-box {
    margin-bottom: 15px;
    width: 100%;
  }

  form .user-details .input-login {
    margin-bottom: 15px;
    width: 100%;
  }

  form .gender-details .category {
    width: 100%;
  }

  .container form .user-details {
    max-width: 300px;
    overflow-y: scroll;
  }

  .user-details::-webkit-scrillbar {
    width: 0;
  }
}
</style>>

