<script setup lang="ts">
import LikeButton from '@/components/LikeButton.vue'

const props=defineProps<{
    //提问人
    questioner?:string
    //问题
    question?:string
    //点赞数
    like?:number
}>()

</script>

<template>
    <el-card class="box-card" shadow="hover">
        <template #header>
            <div class="card-header">
                <el-button-group size="small">
                    <el-button>
                        <span style="text-align: left" v-text="questioner"/>
                    </el-button>
                </el-button-group>
                <like-button style="float: right" :num="like" size="small"/>
            </div>
        </template>
        <span style="word-wrap:break-word;
        word-break:break-all;overflow: hidden;font-weight:bold;font-size: 15px " v-text="question" class="text"/>
    </el-card>
</template>

<style scoped>
.card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height:10px
}

.text {
    font-size: 14px;
}

.box-card {
    width: 480px;
}
</style>
