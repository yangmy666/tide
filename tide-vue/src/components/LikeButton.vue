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
    //大小
    size?:string
    //是否只读
    readonly?:boolean
}>()

let url=ref(notLike)
</script>

<template>
    <el-button-group :size="size">
        <el-button :disabled="readonly">
            <el-image :src="url" /><span>{{num}}</span>
        </el-button>
    </el-button-group>
</template>

<style scoped>

</style>
