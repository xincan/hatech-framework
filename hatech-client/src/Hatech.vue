
<!--
    系统跟组件
    :menus="menus"        将当前父组件menus变量传入Navigation子组件，使之子组件能够获取父组件menus数据
    :controller="this"    将当前父组件this对象传入Navigation子组件，使之子组件能够调用父组件所有变量、方法、函数
-->

<template>

  <div id="hatech">

    <!--
        引入头部Header组件
        :app="this"        将当前父组件menus变量传入Header子组件，使之子组件能够获取父组件所有数据、函数、对象等
    -->
    <Header />

    <div class="content">

      <div class="content-left">
        <Navigation />
      </div>

      <div class="content-right">
        <router-view />
      </div>

    </div>

  </div>

</template>

<script>
    // 引入头部插件
    import Header from "@/components/main/Header";
    import Navigation from "@/components/main/Navigation";

    export default {
        name: 'Hatech'
        , components: {Header, Navigation}   // 头部插件注册
        , data() {
            return {}
        }
        ,created() {
        }
        , watch: {
        }
        , methods: {

        }
    }
</script>

<style scoped lang="scss">
  @import "/assets/css/controller";
</style>
