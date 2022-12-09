<template>
  <div>
    <div class="ilustrasi m-5">
      <img src="../assets/ilustrasi.svg" alt="" />
    </div>
    <hr />
    <p>Ketuk Perangkat untuk menghapusnya</p>
    <div class="perangkat-tertaut d-flex flex-column">
      <div>
        <img class="mr-2" src="../assets/phone.svg" alt="" />
        <span>Google Chrome</span>
        <button class="btn btn-warning ml-3 text-white">Logout</button>
    </div>
    <div>
        <img class="mr-2" src="../assets/phone.svg" alt="" />
        <span>Microsoft Edge</span>
        <button class="btn btn-warning ml-3  text-white">Logout</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MainComp",
  
};
</script>

<style scoped>
.ilustrasi img {
  width: 500px;
  height: auto;
}

img {
  width: 70px;
  margin-top: 10px;
}
</style>