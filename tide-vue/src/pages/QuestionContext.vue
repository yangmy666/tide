<script setup lang="ts">
import {ref} from 'vue'
import {useRoute} from "vue-router";

//取出路由传递的参数
const questionId=ref(useRoute().query.questionId)
</script>

<template>
    问题内容
{{questionId}}
</template>

<style scoped>

</style>
