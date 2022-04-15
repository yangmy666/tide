<script setup lang="ts">
import {onBeforeMount, ref} from 'vue'
import router from "@/utils/router";
import { Search } from '@element-plus/icons-vue'
import Login from '@/pages/Login.vue'
import sheep from '@/../public/sheep.ico'

onBeforeMount(()=>{
    recommend()
})

const handleSelect = (key: string, keyPath: string[]) => {

}
//推荐
function recommend(){
    router.push("/recommend")
}
//测试
function test(){
    router.push("/test")
}
let searchInput=ref('')
//登录弹窗
let loginVisible=ref(false)

//关闭登录弹窗
function closeLoginDialog(){
    loginVisible.value=false
}
</script>

<template>
    <el-menu style="position:fixed;top:0;width:100%;height:45px;padding: 0;margin: 0;z-index:1" default-active="0"
             background-color="#00BFFF"
             text-color="#ffffff"
             active-text-color="#ffffff"
             mode="horizontal"
             @select="handleSelect">
        <el-menu-item index="0" @click="recommend">推荐</el-menu-item>
        <el-menu-item index="1">
            <el-input v-model="searchInput" type="text"
                      placeholder="搜索面试题" :suffix-icon="Search"/>
        </el-menu-item>
        <el-menu-item index="2" >提问</el-menu-item>
        <el-menu-item index="3" @click="loginVisible=true">登录</el-menu-item>
        <el-menu-item index="4">历史记录</el-menu-item>
        <el-menu-item index="5">BUG反馈</el-menu-item>
        <el-menu-item index="6" @click="test">测试</el-menu-item>
    </el-menu>

    <router-view style="position:absolute;top:45px;z-index: 0"/>
    <el-backtop :right="100" :bottom="100">
        <div style="height: 100%;width: 100%;text-align: center;line-height: 40px;color: #1989fa;">
            <el-image :src="sheep"/>
        </div>
    </el-backtop>
    <el-dialog v-model="loginVisible" center width="30%"
               title="登录">
        <Login :closeLoginDialog="closeLoginDialog"/>
    </el-dialog>
</template>

<style scoped>

</style>
