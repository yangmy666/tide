import request from "@/utils/request";

export default class RegisterApi{

    public static sendCode(mail){
        return request({
            method:'POST',
            url: '/tide-system/register/sendCode',
            data:mail
        })
    }

    public static register(form){
        return request({
            method:'POST',
            url: '/tide-system/register',
            data:form
        })
    }
}