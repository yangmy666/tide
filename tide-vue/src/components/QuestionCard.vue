<script setup lang="ts">
import LikeButton from '@/components/LikeButton.vue'
import {ref} from 'vue'
import router from "@/utils/router";

const props=defineProps<{
    //问题id
    questionId:number
    //提问用户
    questioner:string
    //问题
    question:string
    //点赞数
    likeNum:number
    //当前用户是否点赞
    isLike:boolean
    //提问时间
    createTime:string
}>()

//跳转面试题内容
function questionContext(){
    const href:any=router.resolve({
        path: '/questionContext',
        query:{questionId:props.questionId}
    }).href;
    window.open(href, '_blank')
}

const il=ref(props.isLike)
//点赞
function doLike(){
    il.value = !il.value;
}
</script>

<template>
    <div>
        <el-card shadow="hover" @click="questionContext">
            <el-tag style="float: left" color="#ffffff" v-text="questioner"/>
            <div style="display:inline-block;margin-left: 10px;margin-right: 5px;">
            <span style="word-wrap:break-word;word-break:break-all;
        overflow: hidden;font-weight:bold;font-size: 15px " v-text="question"/>
            </div>
            <el-tag style="float: right;" color="#ffffff" v-text="createTime"/>
        </el-card>
        <LikeButton @click="doLike" style="position: relative;bottom:42px;left: 80%" :num="likeNum" :is-like="il" size="small"/>
    </div>
</template>

<style scoped>

</style>
