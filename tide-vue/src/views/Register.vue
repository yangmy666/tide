<script setup lang="ts">
import {ref,reactive,unref} from 'vue'
import RegisterApi from "@/api/system/RegisterApi";
import router from "@/utils/router";

//提交到后端的邮箱 账号 密码
let form=ref({
    mail:'',
    username:'',
    password:'',
    code: ''
})
//确认的密码
let password2=ref('')

//表单验证规则
const validPass2 = (rule: any, value: any, callback: any) => {
    if(form.value.password!=''&&password2.value==''){
        callback(new Error('请再输入一次密码'))
    }else if (password2.value != form.value.password) {
        callback(new Error('两次输入密码不一致'))
    }else {
        callback()
    }
}
const rules = reactive({
    username: [
        { required: true, message: '请设置用户名'}
    ],
    password:[
        { required: true, message: '请设置密码'}
    ],
    password2:[
        {validator:validPass2}
    ],
    mail:[
        { required: true, message: '请输入邮箱账号'}
    ],
    code:[
        { required: true, message: '请输入邮箱验证码'}
    ]
})

//发送验证码
function send(){
    RegisterApi.sendCode(form.value.mail).then(res=>{
        if(res.status==0){
            djs(res.data)
        }
    })
}
//验证码失效倒计时
let countDown=ref('')
function djs(num:number){
    if(num>0){
        countDown.value=num+'s'
        setTimeout(() => {
            num--
            djs(num)
        }, 1000);
    }
    if(num==0){
        countDown.value=''
    }
}

//提交注册
const ruleFormRef=ref()
let loading=ref(false)
async function submit(){
    loading.value=true
    await unref(ruleFormRef).validate((valid:any) => {
        if (valid) {
            RegisterApi.register(form.value).then(res=>{
                if(res.status==1){
                    router.push("/login")
                }
                countDown.value=''
                loading.value=false
            }).catch(()=>{
                loading.value=false
            })
        }else{
            loading.value=false
        }
    });
}

//重置表单
function reset() {
    password2.value=''
    unref(ruleFormRef).resetFields()
    countDown.value=''
}
</script>

<template>
    <div style="width: 400px;text-align: center;position: absolute;height: 20px;top: 0;left: 0;right: 0;bottom: 0;margin: 15% auto;">
        <el-form ref="ruleFormRef" :model="form" :rules="rules" label-width="20%">
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
            <el-button @click="reset">重置</el-button>
            <el-button type="primary" :loading="loading" @click="submit">注册</el-button>
        </el-form>
    </div>
</template>

<style scoped>

</style>
