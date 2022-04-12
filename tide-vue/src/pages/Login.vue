<script setup lang="ts">
import {ref} from 'vue'
import LoginApi from '@/api/LoginApi'
import router from "@/utils/router";

const props=defineProps<{
    closeLoginDialog?:Function
}>()

//登录表单
let form=ref({
  username:'',
  password:''
})
const loading=ref(false)
//登录方法
function doLogin(){
    loading.value=true
    LoginApi.login(form.value).then(res=>{
        if(res.status==1){
            //将token存入localStorage
            localStorage.setItem('access-token',res.data)
            if(props.closeLoginDialog!=undefined){
                props.closeLoginDialog()
            }
        }
        loading.value=false
    }).catch(()=>{
        loading.value=false
    })
}
//注册跳转
function register(){
    const href:any=router.resolve({
        path: '/register'
    }).href;
    window.open(href, '_blank')
}
</script>

<template>
  <div style="text-align: center;">
      <el-form :model="form" label-width="55px">
          <el-form-item label="账号">
              <el-input v-model="form.username" placeholder="请输入账号"/>
          </el-form-item>
          <el-form-item label="密码">
              <el-input v-model="form.password" placeholder="请输入密码" type="password" show-password/>
          </el-form-item>
      </el-form>
      <el-button @click="register">注册</el-button>
      <el-button :loading="loading" type="primary" @click="doLogin">登录</el-button>
  </div>
</template>

<style scoped>

</style>
