<script setup lang="ts">
import {onMounted,ref} from 'vue'
import UserApi from '@/api/system/UserApi'

let tableData:any=ref([])

onMounted(()=>{
    UserApi.list().then(res=>{
        tableData.value=res.data
    })
})

</script>

<template>
    <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="ID" width="180" />
        <el-table-column prop="username" label="用户名" width="180" />
    </el-table>
</template>

<style scoped>

</style>
