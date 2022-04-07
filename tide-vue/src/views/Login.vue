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
    LoginApi.login(form.value).then(token=>{
        //将token存入localStorage
        localStorage.setItem('access-token',token)
        router.push('/system/user')
    })
}
</script>

<template>
  <div style="width: 300px;margin:0 auto;text-align: center">
    <el-form :model="form" label-width="120px">
      <el-form-item label="账号">
        <el-input v-model="form.username" placeholder="请输入账号"/>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password" placeholder="请输入密码" type="password" show-password/>
      </el-form-item>
    </el-form>
    <el-button type="primary" @click="doLogin">登录</el-button>
  </div>
</template>

<style scoped>

</style>
