import request from "@/utils/request";

export default class QuestionApi{
    /**
     * 面试题列表
     * @param query
     */
    public static list(){
        return request({
            method:'GET',
            url: '/tide-system/question/recommend',
        })
    }
}