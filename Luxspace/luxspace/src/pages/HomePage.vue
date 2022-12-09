<template>
  <div>
    <Navbar></Navbar>
    <Footer></Footer>
  </div>
</template>

<script>
import Navbar from "../components/Navbar.vue";
import Footer from "../components/Footer.vue";

export default {
  name: "NavbarComp",
  components: {
    Navbar,
    Footer,
  },
  created() {
    if (!this.$session.exists()) {
        this.$router.push('/')
    }
  },
};
</script>

<style scoped>
</style>
