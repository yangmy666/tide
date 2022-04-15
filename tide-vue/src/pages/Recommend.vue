<script setup lang="ts">
import {onBeforeMount, ref} from 'vue'
import QuestionCard from '@/components/QuestionCard.vue'
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

</script>

<template>
    <div v-infinite-scroll="load" infinite-scroll-distance="0.5"
         infinite-scroll-immediate="false" style="margin: 0 auto;width: 60%;float: left">
        <QuestionCard style="width: 100%;margin: 10px" v-for="(item,index) in questionList"
                      :question-id="Number(item.id)"
                  :questioner="item.questioner"
                  :question="item.question"
                  :likeNum="Number(item.likeNum)"
                  :is-like="item.isLike"
                  :create-time="item.createTime"
                  :key="index"/>
        <div style="width: 100%;height: 300px" v-loading="loading"></div>
    </div>
</template>

<style scoped>

</style>
