import axios from "axios";
import { ElMessage } from 'element-plus'
import router from "@/utils/router";

const instance = axios.create({
    baseURL: 'http://localhost:8080',
    headers:{
        'Content-Type':'application/json;charset=UTF-8',
    }
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
            'access-token': encodeURIComponent(token)
        }
    }
    return request
})

// 响应拦截器
instance.interceptors.response.use(response=> {
    const res=response.data
    if(res.status==-2){
        //权限不足
        ElMessage({
            message: res.message,
            type: 'warning',
            center:true
        })
        router.back()
    }
    if(res.status==-1){
        //未登录或者令牌过期
        ElMessage({
            message: res.message,
            type: 'warning',
            center:true
        })
        router.push("/")
    }
    if(res.status==1){
        //操作成功
        ElMessage({
            message: res.message,
            type: 'success',
            center:true
        })
    }
    if(res.status==2){
        //操作警告
        ElMessage({
            message: res.message,
            type: 'warning',
            center:true
        })
    }
    if(res.status==3){
        //操作失败
        ElMessage({
            message: res.message,
            type: 'error',
            center:true
        })
    }
    return res
})

export default instance