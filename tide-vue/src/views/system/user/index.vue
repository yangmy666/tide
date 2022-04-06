<script setup lang="ts">
import {onMounted, ref} from 'vue'

//组件入参
defineProps<{}>()
//组件data
const tableData=ref([])
onMounted(()=>{

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
