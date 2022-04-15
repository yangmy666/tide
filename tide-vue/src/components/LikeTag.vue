<script setup lang="ts">
import {ref,onBeforeMount} from 'vue'
import notLike from '@/../public/notLike.svg'
import like from '@/../public/notLike.svg'

onBeforeMount(()=>{
    if(props.isLike){
        url.value=like
    }
})

const props = defineProps<{
    //点赞数
    num?:number
    //是否已赞
    isLike?:boolean
}>()

let url=ref(notLike)
</script>

<template>
    <el-tag color="#ffffff">
        <el-image :src="url" />{{num}}
    </el-tag>
</template>

<style scoped>

</style>
