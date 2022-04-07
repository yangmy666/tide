import request from "@/utils/request";

export default class LoginApi{
    /**
     * 登录
     * @param form
     */
    public static login(form:object){
        return request({
            method:'POST',
            url: '/tide-system/login',
            data:form
        })
    }
}
