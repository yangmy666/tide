<script setup lang="ts">
import {ref} from 'vue'
import router from "@/utils/router";

//组件入参
defineProps<{}>()
function goLogin(){
    router.push("/login")
}
function goUser(){
    router.push("/system/user")
}
</script>

<template>
主页
    <el-button @click="goLogin">登录</el-button>
    <el-button @click="goUser">用户管理</el-button>
</template>

<style scoped>

</style>
