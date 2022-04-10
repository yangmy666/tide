<script setup lang="ts">
import {onBeforeMount, ref} from 'vue'
import router from "@/utils/router";
import { Search } from '@element-plus/icons-vue'
import Login from '@/pages/Login.vue'

onBeforeMount(()=>{
    recommend()
})

const handleSelect = (key: string, keyPath: string[]) => {

}
//推荐
function recommend(){
    router.push("/recommend")
}
let searchInput=ref('')
//登录弹窗
let loginVisible=ref(false)
</script>

<template>
    <el-menu default-active="0"
             background-color="#00BFFF"
             text-color="#ffffff"
             active-text-color="#ffffff"
             mode="horizontal"
             @select="handleSelect">
        <div style="margin: auto 1%"></div>
        <el-menu-item index="0" @click="recommend">推荐</el-menu-item>
        <el-input v-model="searchInput" type="text" style="width:15%;margin: auto 1%  auto 55%"
                  placeholder="搜索面试题"
                  :suffix-icon="Search"/>
        <el-menu-item index="1" >提问</el-menu-item>
        <el-menu-item index="2" @click="loginVisible=true">登录</el-menu-item>
        <el-menu-item index="3">历史记录</el-menu-item>
        <el-menu-item index="4">BUG反馈</el-menu-item>
    </el-menu>
    <router-view/>
    <el-dialog v-model="loginVisible" center width="30%"
               title="登录">
        <Login/>
    </el-dialog>
</template>

<style scoped>

</style>
