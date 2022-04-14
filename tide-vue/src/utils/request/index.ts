import axios from 'axios';
import { ElNotification } from 'element-plus'
import router from '@/utils/router';
import {Status} from '@/utils/request/Status';
import Result from '@/utils/request/Result';

const instance = axios.create({
    //baseURL: 'http://47.94.147.204/api',
    baseURL: 'http://localhost:8080/api',
    timeout: 10000
})

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

    //操作成功
    if(res.status==Status.success){
        ElNotification({
            type: 'success',
            title: res.message,
            offset: 100
        })
    }

    //操作警告
    if(res.status==Status.warning){
        ElNotification({
            type: 'warning',
            title: res.message,
            message: res.data,
            offset: 100
        })
    }

    //操作失败
    if(res.status==Status.failure){
        ElNotification({
            type: 'error',
            title: res.message,
            message: res.data,
            offset: 100
        })
    }

    //未登录
    if(res.status==Status.unAuthorized){
        ElNotification({
            type: 'warning',
            title: res.message,
            message: res.data,
            offset: 100
        })
        //去登录
        router.push('/login')
    }

    //权限不足
    if(res.status==Status.permissionDenied){
        ElNotification({
            type: 'warning',
            title: res.message,
            message: res.data,
            offset: 100
        })
        //回退
        router.back()
    }

    return res
},
    (error) => {
    let { message } = error;
    if (message == 'Network Error') {
        ElNotification({
            type: 'error',
            title: '后端接口连接异常',
            offset: 100
        })
    } else if (message.includes('timeout')) {
        ElNotification({
            type: 'error',
            title: '系统接口请求超时',
            offset: 100
        })
    } else if (message.includes('Request failed with status code')) {
        ElNotification({
            type: 'error',
            title: '系统接口' + message.substring(message.length - 3) + '异常',
            offset: 100
        })
    }
    return Promise.reject(error);
})

export default instance

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
