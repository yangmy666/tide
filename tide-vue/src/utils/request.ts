import axios from "axios";
import { ElNotification } from 'element-plus'
import router from "@/utils/router";
import {Status} from "@/utils/Status";

const instance = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 5000
})

/*const token={
    "id":1,
    "username":"ymy"
}
const accessToken=JSON.stringify(token)
console.log(accessToken)
const encode=window.btoa(accessToken)
console.log(encode)
const decode=window.atob(encode)
console.log(decode)
const t=JSON.parse(decode)
console.log(t)*/

//请求拦截器
instance.interceptors.request.use(request=>{
    //携带token
    const token=localStorage.getItem('access-token')
    if(token!=null){
        request.headers={
            'access-token': token
        }
    }
    return request
})

// 响应拦截器
instance.interceptors.response.use(response=> {
    const res=response.data
    if(res.status==Status.success){
        ElNotification({
            type: 'success',
            title: res.title
        })
    }
    if(res.status==Status.warning){
        ElNotification({
            type: 'warning',
            title: res.title,
            message: res.data
        })
    }
    if(res.status==Status.failure){
        ElNotification({
            type: 'error',
            title: res.title,
            message: res.data
        })
    }
    if(res.status==Status.unAuthorized){
        ElNotification({
            type: 'warning',
            title: res.title,
            message: res.data
        })
        //去登录
        router.push("/login")
    }
    if(res.status==Status.permissionDenied){
        ElNotification({
            type: 'warning',
            title: res.title,
            message: res.data
        })
        //回退
        router.back()
    }
    return res
})

export default instance