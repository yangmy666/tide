import request from "@/utils/request";

export default class RegisterApi{

    public static sendCode(mail:string){
        return request({
            method:'POST',
            url: '/tide-system/sendMailCode',
            params:{
                mail:mail
            }
        })
    }

    public static register(form:object){
        return request({
            method:'POST',
            url: '/tide-system/register',
            data:form
        })
    }
}