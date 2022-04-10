<script setup lang="ts">
import {onBeforeMount, reactive, ref} from 'vue'
import Question from '@/components/Question.vue'
import router from "@/utils/router";
import QuestionApi from "@/api/QuestionApi";

onBeforeMount(()=>{
    QuestionApi.list().then(res=>{
        questions.values()=res.data
    })
})

let questions=reactive([/*
    {
        id:1,
        question:'AQS的state为什么要加volatile关键字？',
        user:{
            id:1,
            username:'ymy'
        }
    },
    {
        id:2,
        question:'HashMap JDK1.7到1.8有什么变化？',
        user:{
            id:1,
            username:'ymy'
        }
    },
    {
        id:3,
        question:'MySQL七八张表联查如何优化',
        user:{
            id:1,
            username:'ymy'
        }
    },*/])

function questionContext(id:number){
    router.push({path:"/questionContext",query:{questionId:id}})
}
</script>

<template>
    <div style="margin: 0 auto;width: 50%">
        <Question v-for="(item,index) in questions"
                  :question="item.question"
                  :user="item.user"
                  :key="index"
                  @click="questionContext(item.id)"/>
    </div>
</template>

<style scoped>

</style>
