<script setup lang="ts">
import {ref,reactive} from 'vue'
import RegisterApi from "@/api/system/RegisterApi";

//提交到后端的邮箱 账号 密码
let form=ref({
    mail:'',
    username:'',
    password:'',
    code: ''
})
//表单验证规则
const rules = reactive({
    username: [
        { required: true, message: '请设置用户名', trigger: 'blur' }
    ],
    password:[
        { required: true, message: '请设置密码', trigger: 'blur' }
    ],
    password2:[
        { required: true, message: '请确认密码', trigger: 'blur' }
    ],
    mail:[
        { required: true, message: '请输入邮箱账号', trigger: 'blur' }
    ],
    code:[
        { required: true, message: '请输入邮箱验证码', trigger: 'blur' }
    ]
})
//确认的密码
let password2=ref('')
//验证码失效倒计时
let countDown=ref('')
//发送验证码
function send(){
    RegisterApi.sendCode(form.value.mail).then(res=>{
        if(res.status==0){
            for (let i=res.data;i>0;i--){
                setTimeout(() => {
                    countDown.value=i+'s'
                }, 1000);
            }
        }
    })
}
//提交注册
function register(){

}
</script>

<template>
    <div style="width: 400px;text-align: center;position: absolute;height: 20px;top: 0;left: 0;right: 0;bottom: 0;margin: 15% auto;">
        <el-form :model="form" :rules="rules" label-width="20%">
            <el-form-item label="账号" prop="username">
                <el-input v-model="form.username" placeholder="请设置账号"/>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="form.password" placeholder="请设置密码" type="password" show-password/>
            </el-form-item>
            <el-form-item label="确认密码" prop="password2">
                <el-input v-model="password2" placeholder="请再输入一次密码" type="password" show-password/>
            </el-form-item>
            <el-form-item label="邮箱" prop="mail">
                <el-input style="width: 60%" v-model="form.mail" placeholder="请输入邮箱"/>
                <el-button style="margin-left: 2%" size="small" type="primary" @click="send">发送验证码</el-button>
            </el-form-item>
            <el-form-item label="验证码" prop="code">
                <el-input style="width: 60%" v-model="form.code" placeholder="请输入你收到的验证码"/>{{countDown}}
            </el-form-item>
            <el-button type="primary" @click="register">注册</el-button>
        </el-form>
    </div>
</template>

<style scoped>

</style>
