import request from "../../utils/request";

/**
 * 登录
 * @param data
 * @returns {AxiosPromise}
 */
export function list(data:object){
    return request({
        method:'GET',
        url: '/tide-system/user/list',
        params:data
    })
}