<script setup lang="ts">
import {ref} from 'vue'
import {useRoute} from "vue-router";

//取出路由传递的面试题id
const questionId=ref(useRoute().query.questionId)
//
</script>

<template>

</template>

<style scoped>

</style>
