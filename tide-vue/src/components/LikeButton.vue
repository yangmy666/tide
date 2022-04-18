<script setup lang="ts">
import {ref,onBeforeMount,watch} from 'vue'
import notLike from '@/../public/notLike.svg'
import like from '@/../public/notLike.svg'

onBeforeMount(()=>{
    if(props.isLike){
        url.value=like
    }else{
        url.value=notLike
    }
})

//todo 监听isLike来变换点赞图标
watch(()=>props.isLike,newVal=>{
    if(newVal){
        console.log(1)
        url.value=like
    }else{
        console.log(2)
        url.value=notLike
    }
    console.log(url.value)
})

const props = defineProps<{
    //点赞数
    num?:number
    //是否已赞
    isLike?:boolean
    //大小
    size?:string
}>()

let url=ref('')
</script>

<template>
    <el-button-group :size="size">
        <el-button>
            <el-image :src="url" /><span>{{num}}</span>
        </el-button>
    </el-button-group>
</template>

<style scoped>

</style>
