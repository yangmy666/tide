<script setup lang="ts">
import {onBeforeMount, ref} from 'vue'
import {useRoute} from "vue-router";
import QuestionContextApi from "@/api/QuestionContextApi"
import Question from "@/components/Question.vue"

//取出路由传递的面试题id
const questionId=ref(useRoute().query.questionId)
onBeforeMount(()=>{
    QuestionContextApi.load(Number(questionId)).then(res=>{
        questionContext.value=res.data
    })
})
let questionContext=ref({
    questioner:'',
    question:'',
    likeNum:0,
    isLike:false
})
</script>

<template>
    <Question :questioner="questionContext.questioner"
              :question="questionContext.question"
              :like-num="questionContext.likeNum"
              :is-like="questionContext.isLike"/>
</template>

<style scoped>

</style>
