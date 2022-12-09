<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary text-white">
      <a class="navbar-brand" href="#">JUNNED</a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" href="#"
              >Home <span class="sr-only">(current)</span></a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
        </ul>
      </div>
      <router-link to="/">
        <button @click="HapusSesi" class="btn btn-warning text-white " type="submit">
          Log Out
        </button>
      </router-link>
    </nav>
  </div>
</template>

<script>
export default {
  name: "NavbarComp",
  methods : {
    HapusSesi(){
      this.$session.destroy();
    }
  },

  created() {
    console.log(this.$session.get("jwt").id);
  },
};
</script>

<style>
</style>