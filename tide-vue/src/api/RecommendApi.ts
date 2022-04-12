import request from "@/utils/request";

export default class RecommendApi {
    /**
     * 加载推荐
     * @param query
     */
    public static load(){
        return request({
            method:'GET',
            url: '/tide-system/recommend/load',
        })
    }
}