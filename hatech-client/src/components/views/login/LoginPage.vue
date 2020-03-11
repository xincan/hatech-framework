
<template>
  <div class="login">
    <el-input type="text" v-model="username" placeholder="请输入用户名"></el-input>
    <el-input type="password" v-model="password" placeholder="请输入密码"></el-input>
    <el-button type="primary" @click="login">登录</el-button>
    <a class="registry" v-on:click="registry">注册</a>
  </div>
</template>

<script>
    import axios from 'axios'
    import qs from 'qs'

    export default {
        name: 'login',
        props: [''],
        data() {
            return {
                username: "",
                password: "",
            };
        },
        computed: {

        },
        mounted() {
            console.log(this.$route);
        },
        methods: {
            registry(){
              this.$router.push({ path: '/registry' })
            },
            login() {
                let _this = this;
                const postData = {
                    "grant_type": "password",
                    "username": this.username,
                    "password": this.password,
                    "scope": "server"
                };
                const options = {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                        'header_username': 'xincan-transaction-system',
                        'header_password': '123456'
                    },
                    data: qs.stringify(postData),
                    url: '/api/xincan-transaction-system/user/login',
                };
                axios(
                    options
                ).then(function(response) {
                    debugger;
                    if (response.data.code === 200) {
                        _this.$message({message: "登陆成功", center: true, type: 'success'});
                        // 将token保存在localStorage
                        localStorage.setItem("token", JSON.stringify(response.data.data));
                        // 页面跳转到 /hatech
                        _this.$router.push({path: '/hatech/dashboard', query: {"loginUser": _this.username}})
                    }
                    else {
                        _this.$message({message: response.data.msg ,center: true ,type: 'error'});
                    }
                }).catch(function(error) {
                    _this.$message({message: "登陆失败" ,center: true ,type: 'error'});
                })
            }
        }
    }

</script>

<style scoped lang="scss">
  .login {
    width: 500px;
    margin-left: calc(50% - 250px);
    margin-top: 200px;
  }

  .login .el-input {
   margin: .5rem 0;
  }

  .login .el-button--primary {
    width: 100%;
    margin: .5rem 0;
  }

  .registry {
    cursor: pointer;
    float: right;
  }
</style>
