
<!--
  头部导航栏
-->

<template>
  <div id="header">
    <div class="header-left"><span>{{title}}</span></div>
    <div class="header-center">
      <ul>
        <!--遍历选择后系统的一级菜单-->
<!--        <li v-for="(menu, key) in menus" :class="active === key ? 'active' : ''" @click="haderMenuClick(key, menu)" v-text="menu.name" ></li>-->
      </ul>
    </div>
    <div class="header-right">
      <ul>
        <li>
          <!--遍历系统-->
<!--          <el-select v-model="defaultSelectSystem" placeholder="请选择" @change="controllChange">-->
<!--            <el-option v-for="option in controll" :key="option.id" :label="option.label" :value="option.id" ></el-option>-->
<!--          </el-select>-->
        </li>
        <li>{{loginUser}}</li>
        <li v-on:click="logout">退出</li>
      </ul>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: "Header"
    ,data() {
      return {
        title: "IStorM DRaaS",
        loginUser: this.$route.query.loginUser
      }
    }
    ,mounted(){
    }
    ,methods: {
      logout() {
        const token = JSON.parse(localStorage.token);
        let _this=this, tokenHeader = "Bearer " + token.access_token;
        const options = {
            method: 'POST',
            headers: {
                'Authorization': tokenHeader,
            },
            url: '/api/xincan-transaction-system/user/logout',
        };
        axios(
            options
        ).then(function(response) {
            _this.$message({message: "退出登录" ,center: true ,type: 'success'});
            // 清空localstorage中的token
            localStorage.removeItem("token");
            // 页面跳转到登录页
            _this.$router.push({ path: '/login' })
        }).catch(function(error) {
            _this.$message({message: "退出失败" ,center: true ,type: 'error'});
            console.log(error);
        })
      }
    }
  }
</script>

<style scoped lang="scss">
  @import "../../assets/css/header";
</style>
