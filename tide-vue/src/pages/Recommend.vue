<script setup lang="ts">
import {onBeforeMount, ref} from 'vue'
import Question from '@/components/Question.vue'
import router from "@/utils/router";
import RecommendApi from "@/api/RecommendApi";

//面试题
let questionList:any=ref([])
//加载标志
let loading=ref(false)

onBeforeMount(()=>{
    load()
})

//加载面试题推荐
function load(){
    loading.value=true
    RecommendApi.load().then(res=>{
        questionList.value=questionList.value.concat(res.data)
        loading.value=false
    }).catch(()=>{
        loading.value=false
    })
}

//跳转面试题内容
function questionContext(id:number){
    const href:any=router.resolve({
        path: '/questionContext',
        query:{questionId:id}
    }).href;
    window.open(href, '_blank')
}
</script>

<template>
    <div v-infinite-scroll="load" infinite-scroll-distance="0.5"
         infinite-scroll-immediate="false" style="margin: 0 auto;width: 60%;float: left">
        <Question style="width: 100%;margin: 10px" v-for="(item,index) in questionList"
                  :questioner="item.questioner"
                  :question="item.question"
                  :likeNum="Number(item.likeNum)"
                  :is-like="item.isLike"
                  :key="index"
                  @click="questionContext(Number(item.id))"/>
        <div style="width: 100%;height: 300px" v-loading="loading"></div>
    </div>
</template>

<style scoped>

</style>
