import axios from 'axios';
import { ElNotification } from 'element-plus'
import router from '@/utils/router';
import {Status} from '@/utils/request/Status';
import Result from '@/utils/request/Result';

const instance = axios.create({
    baseURL: 'http://47.94.147.204/api',
    //baseURL: 'http://localhost:8080/api',
    timeout: 10000
})

/*const token={
    'id':1,
    'username':'ymy'
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
instance.interceptors.response.use((response):Result=> {
    const res=response.data
    process(res)
    return res
},
    (error) => {
    let { message } = error;
    if (message == 'Network Error') {
        ElNotification({
            type: 'error',
            title: '后端接口连接异常'
        })
    } else if (message.includes('timeout')) {
        ElNotification({
            type: 'error',
            title: '系统接口请求超时'
        })
    } else if (message.includes('Request failed with status code')) {
        ElNotification({
            type: 'error',
            title: '系统接口' + message.substring(message.length - 3) + '异常',
        })
    }
    return Promise.reject(error);
})

function process(res:Result){
    const duration=2000
    if(res.status==Status.success){
        ElNotification({
            type: 'success',
            title: res.message,
            duration: duration
        })
    }
    if(res.status==Status.warning){
        ElNotification({
            type: 'warning',
            title: res.message,
            message: res.data,
            duration: duration
        })
    }
    if(res.status==Status.failure){
        ElNotification({
            type: 'error',
            title: res.message,
            message: res.data,
            duration: duration
        })
    }
    if(res.status==Status.unAuthorized){
        ElNotification({
            type: 'warning',
            title: res.message,
            message: res.data,
            duration: duration
        })
        //去登录
        router.push('/login')
    }
    if(res.status==Status.permissionDenied){
        ElNotification({
            type: 'warning',
            title: res.message,
            message: res.data,
            duration: duration
        })
        //回退
        router.back()
    }
}

export default instance
