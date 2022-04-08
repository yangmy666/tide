<script setup lang="ts">
import {ref} from 'vue'

//提交到后端的邮箱 账号 密码
let form=ref({
    mail:'',
    username:'',
    password:''
})
//邮箱验证码
let code=ref('')
//确认的密码
let password2=ref('')
//发送验证码
function send(){

}
//提交注册
function register(){

}
</script>

<template>
    <div style="width: 400px;text-align: center;position: absolute;height: 20px;top: 0;left: 0;right: 0;bottom: 0;margin: 15% auto;">
        <el-form :model="form" label-width="20%">
            <el-form-item label="邮箱">
                <el-input style="width: 60%" v-model="form.mail" placeholder="请输入邮箱"/>
                <el-button style="margin-left: 2%" size="small" type="primary" @click="send">发送验证码</el-button>
            </el-form-item>
            <el-form-item label="验证码">
                <el-input style="width: 60%" v-model="code" placeholder="请输入你收到的验证码"/>
            </el-form-item>
            <el-form-item label="账号">
                <el-input v-model="form.username" placeholder="请设置账号"/>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="form.password" placeholder="请设置密码" type="password" show-password/>
            </el-form-item>
            <el-form-item label="确认密码">
                <el-input v-model="password2" placeholder="请再输入一次密码" type="password" show-password/>
            </el-form-item>
            <el-button type="primary" @click="register">注册</el-button>
        </el-form>
    </div>
</template>

<style scoped>

</style>
