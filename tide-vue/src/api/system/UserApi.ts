import request from "@/utils/request";

export default class UserApi{
    /**
     * 用户列表
     * @param query
     */
    public static list(query:object={}){
        return request({
                       method:'GET',
                       url: '/tide-system/user/list',
                       params:query
        })
    }
}