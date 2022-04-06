import request from "../../utils/request";

/**
 * 登录
 * @param data
 * @returns {AxiosPromise}
 */
export function login(data:{username:string,password:string}){
    return request({
        method:'POST',
        url: '/tide-system/login',
        data:data
    })
}
