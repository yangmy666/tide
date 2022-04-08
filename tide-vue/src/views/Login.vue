<script setup lang="ts">
import {ref} from 'vue'
import LoginApi from '@/api/system/LoginApi'
import router from "@/utils/router";

//登录表单
let form=ref({
  username:'',
  password:''
})
//登录方法
function doLogin(){
    LoginApi.login(form.value).then(res=>{
        if(res.status==1){
            //将token存入localStorage
            localStorage.setItem('access-token',res.data)
            router.push('/system/user')
        }
    })
}
//注册跳转
function register(){
    router.push("/register")
}
</script>

<template>
  <div style="width: 240px;text-align: center;position: absolute;
    height: 150px;
     top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    margin: 15% auto;
">
    <el-form :model="form" label-width="55px">
      <el-form-item label="账号">
        <el-input v-model="form.username" placeholder="请输入账号"/>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password" placeholder="请输入密码" type="password" show-password/>
      </el-form-item>
    </el-form>
    <el-button type="primary" @click="doLogin">登录</el-button>
      <el-button @click="register">注册</el-button>
  </div>
</template>

<style scoped>

</style>
