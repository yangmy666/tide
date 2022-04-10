<script setup lang="ts">
import {onBeforeMount, reactive, ref} from 'vue'
import Question from '@/components/Question.vue'
import router from "@/utils/router";
import QuestionApi from "@/api/QuestionApi";

onBeforeMount(()=>{
    const questionsCache=sessionStorage.getItem("questionsCache")
    if(questionsCache!=null){
        questions.value=JSON.parse(questionsCache)
    }else{
        loadQuestions()
    }
})

//面试题推荐
let questions:any=ref([])

//加载面试题推荐
function loadQuestions(){
    QuestionApi.list().then(res=>{
        questions.value=res.data
    })
}

//跳转面试题内容
function questionContext(id:number){
    //先将当前推荐缓存到sessionStorage再跳转,那样返回回来还能继续原来的浏览位置
    const questionsCache=JSON.stringify(questions.value)
    sessionStorage.setItem("questionsCache",questionsCache)
    router.push({path:"/questionContext",query:{questionId:id}})
}
</script>

<template>
    <div style="margin: 0 auto;width: 50%">
        <Question v-for="(item,index) in questions"
                  :questioner="item.questioner"
                  :question="item.question"
                  :star="Number(item.star)"
                  :key="index"
                  @click="questionContext(Number(item.id))"/>
    </div>
</template>

<style scoped>

</style>
