import request from "@/utils/request";

export default class LoginApi{
    /**
     * 登录
     * @param user
     */
    public static login(user:object){
        return request({
            method:'POST',
            url: '/tide-system/login',
            data:user
        })
    }
}
