<script setup lang="ts">
import {ref} from 'vue'

defineProps<{
    //问题
    question?:string
    //提出者
    user?:{
        username:string
    }
}>()

</script>

<template>
    <el-descriptions>
        <el-descriptions-item width="20%">{{user.username}}</el-descriptions-item>
        <el-descriptions-item width="80%">{{question}}</el-descriptions-item>
    </el-descriptions>
</template>

<style scoped>

</style>
