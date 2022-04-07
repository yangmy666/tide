<script setup lang="ts">
import {onMounted, ref} from 'vue'
import UserApi from '@/api/system/UserApi'

let tableData=ref([])
onMounted(()=>{
    UserApi.list().then(res=>{
        tableData=ref(res.data)
    })
})
</script>

<template>
    <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="Date" width="30" />
        <el-table-column prop="name" label="Name" width="180" />
    </el-table>
</template>

<style scoped>

</style>
