<template>
  <div class="registry">
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="用户注册" name="user">
        <el-input type="text" v-model="user_name" placeholder="请输入用户名"></el-input>
        <el-input type="password" v-model="user_password" placeholder="请输入密码"></el-input>
        <el-button type="primary" @click="userRegistry">注册</el-button>
      </el-tab-pane>
      <el-tab-pane label="租户注册" name="tenant">
        <el-input type="text" v-model="tenant_name" placeholder="请输入租户名"></el-input>
        <el-input type="password" v-model="tenant_password" placeholder="请输入密码"></el-input>
        <el-button type="primary" @click="tenantRegistry">注册</el-button>
      </el-tab-pane>
    </el-tabs>
    <a class="login" v-on:click="login">登录页</a>
  </div>
</template>

<script>
  import axios from 'axios';
  import qs from 'qs';

    export default {
        name: "RegistryPage",
        data() {
            return {
                activeName: 'user',
                user_name: '',
                user_password: '',
                tenant_name: '',
                tenant_password: ''
            };
        },
        methods: {
            handleClick(tab, event) {
                console.log(tab, event);
            },

            // 用户注册
            userRegistry() {
                let that = this;
                const options = {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                    data: qs.stringify({
                        username: this.user_name,
                        password: this.user_password
                    }),
                    url: "/api/xincan-transaction-system/user/registry"
                };
                axios(
                    options
                ).then(function (response) {
                    if (response.data.code === 200) {
                        that.$message({message: response.data.msg ,center: true ,type: 'success'});
                        that.$router.push({"path": "/login"});
                    }
                    else {
                        that.$message({message: response.data.msg ,center: true ,type: 'error'});
                    }
                }).catch(function (error) {console.log(error)});
            },
            // 租户注册
            tenantRegistry() {
                let that = this;
                const options = {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                    data: qs.stringify({
                        tenantName: this.tenant_name,
                        tenantPassword: this.tenant_password
                    }),
                    url: "/api/xincan-transaction-system/tenant/registry"
                };
                axios(
                    options
                ).then(function (response) {
                    if (response.data.code === 200) {
                        that.$message({message: response.data.msg ,center: true ,type: 'success'});
                        that.$router.push({"path": "/login"});
                    }
                    else {
                        that.$message({message: response.data.msg ,center: true ,type: 'error'});
                    }
                }).catch(function (error) {console.log(error)});
            },
            // 跳转登录页
            login() {
                this.$router.push({path: "/login"})
            }
        }
    }
</script>

<style scoped lang="scss">
  .registry {
    width: 600px;
    margin-left: calc(50% - 300px);
    margin-top: 200px;
  }

  .registry .el-input {
    margin: .5rem 0;
  }

  .registry .el-button--primary {
    width: 100%;
    margin: .5rem 0;
  }

  .login {
    cursor: pointer;
    float: right;
  }
</style>
