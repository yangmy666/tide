import request from "@/utils/request";

export default class QuestionContextApi {
    /**
     * 加载推荐
     * @param questionId
     */
    public static load(questionId:number){
        return request({
            method:'GET',
            url: '/tide-system/questionContext/load',
            params:{
                questionId:questionId
            }
        })
    }
}