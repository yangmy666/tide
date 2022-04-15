<script setup lang="ts">
import {onBeforeMount, ref} from 'vue'
import {useRoute} from "vue-router";
import QuestionContextApi from "@/api/QuestionContextApi"

//取出路由传递的面试题id
const questionId=ref(useRoute().query.questionId)
onBeforeMount(()=>{
    QuestionContextApi.load(Number(questionId.value)).then(res=>{
        questionContext.value=res.data
    })
})
//面试题内容
let questionContext=ref({
    questioner:'',
    question:'',
    likeNum:0,
    isLike:false,
    createTime:''
})
//解答列表
let answerList=ref([])
</script>

<template>

</template>

<style scoped>

</style>
