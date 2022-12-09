import Login from "./pages/LoginPage.vue"
import Home from "./pages/HomePage.vue"
import Register from "./pages/RegisterPage.vue"

export default [
    {
        path: '/',
        component: Login
    },
    {
        path: '/home',
        component: Home
    },
    {
        path: '/register',
        component: Register
    }

]