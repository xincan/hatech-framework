
<!--

  系统主页信息

-->
<template>
  <div id="Dashboard">
    系统主页
    <router-view />

  </div>
</template>

<script>
  export default {
    name: "Dashboard"
    ,data(){
      return {

      }
    }

    ,mounted() {
        let a = this.$route;
        console.log(a)
    }
  }
</script>

<style scoped lang="scss">

</style>
