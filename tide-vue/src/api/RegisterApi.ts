import request from "@/utils/request";

export default class RegisterApi{

    public static sendMailCode(mail:string){
        return request({
            method:'POST',
            url: '/tide-system/sendMailCode',
            params:{
                mail:mail
            }
        })
    }

    public static register(user:object){
        return request({
            method:'POST',
            url: '/tide-system/register',
            data:user
        })
    }
}