<template>
  <div>
    <Navbar></Navbar>
    <Main></Main>
    <Footer></Footer>
  </div>
</template>

<script>
import Navbar from "../components/Navbar.vue";
import Footer from "../components/Footer.vue";
import Main from "../components/MainComp.vue";

export default {
  name: "NavbarComp",
  components: {
    Navbar,
    Main,
    Footer,
  },
  created() {
    if (!this.$session.exists()) {
      this.$router.push("/");
    }
  },
};
</script>

<style scoped>
</style>
