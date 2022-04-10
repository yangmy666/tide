<script setup lang="ts">
import {ref} from 'vue'

defineProps<{
    //提问人
    questioner?:string
    //问题
    question?:string
    //点赞数
    star?:number
}>()

</script>

<template>
    <el-card shadow="hover" style="margin: 5px">
        <div class="card-header">
            <span style="text-align: left">{{questioner}}</span>
            <span style="float: right">{{star}}</span>
        </div>
        {{question}}
    </el-card>
</template>

<style scoped>

</style>
