import{r as e}from"./index.aa9d0b84.js";import{i as l}from"./index.a49b8d12.js";import{d as a,f as t,r as o,o as u,g as d,h as n,w as s,u as r,j as i,k as f,l as m,F as c,s as p,m as h}from"./vendor.068ae998.js";const v={style:{"text-align":"center"}},x=i("注册"),g=i("登录"),w=a({setup(a){let i=t({username:"",password:""});const f=t(!1);function m(){f.value=!0,class{static login(e){return l({method:"POST",url:"/tide-system/login",data:e})}}.login(i.value).then((l=>{1==l.status&&(localStorage.setItem("access-token",l.data),e.push("/")),f.value=!1})).catch((()=>{f.value=!1}))}function c(){const l=e.resolve({path:"/register"}).href;window.open(l,"_blank")}return(e,l)=>{const a=o("el-input"),t=o("el-form-item"),p=o("el-form"),h=o("el-button");return u(),d("div",v,[n(p,{model:r(i),"label-width":"55px"},{default:s((()=>[n(t,{label:"账号"},{default:s((()=>[n(a,{modelValue:r(i).username,"onUpdate:modelValue":l[0]||(l[0]=e=>r(i).username=e),placeholder:"请输入账号"},null,8,["modelValue"])])),_:1}),n(t,{label:"密码"},{default:s((()=>[n(a,{modelValue:r(i).password,"onUpdate:modelValue":l[1]||(l[1]=e=>r(i).password=e),placeholder:"请输入密码",type:"password","show-password":""},null,8,["modelValue"])])),_:1})])),_:1},8,["model"]),n(h,{onClick:c},{default:s((()=>[x])),_:1}),n(h,{loading:f.value,type:"primary",onClick:m},{default:s((()=>[g])),_:1},8,["loading"])])}}}),_=h("div",{style:{margin:"auto 1%"}},null,-1),V=i("推荐"),b=i("提问"),k=i("登录"),y=i("历史记录"),U=i("BUG反馈"),j=a({setup(l){f((()=>{i()}));const a=(e,l)=>{};function i(){e.push("/recommend")}let h=t(""),v=t(!1);return(e,l)=>{const t=o("el-menu-item"),f=o("el-input"),x=o("el-menu"),g=o("router-view"),j=o("el-dialog");return u(),d(c,null,[n(x,{"default-active":"0","background-color":"#00BFFF","text-color":"#ffffff","active-text-color":"#ffffff",mode:"horizontal",onSelect:a},{default:s((()=>[_,n(t,{index:"0",onClick:i},{default:s((()=>[V])),_:1}),n(f,{modelValue:r(h),"onUpdate:modelValue":l[0]||(l[0]=e=>m(h)?h.value=e:h=e),type:"text",style:{width:"15%",margin:"auto 1%  auto 55%"},placeholder:"搜索面试题","suffix-icon":r(p)},null,8,["modelValue","suffix-icon"]),n(t,{index:"1"},{default:s((()=>[b])),_:1}),n(t,{index:"2",onClick:l[1]||(l[1]=e=>m(v)?v.value=!0:v=!0)},{default:s((()=>[k])),_:1}),n(t,{index:"3"},{default:s((()=>[y])),_:1}),n(t,{index:"4"},{default:s((()=>[U])),_:1})])),_:1}),n(g),n(j,{modelValue:r(v),"onUpdate:modelValue":l[2]||(l[2]=e=>m(v)?v.value=e:v=e),center:"",width:"30%",title:"登录"},{default:s((()=>[n(w)])),_:1},8,["modelValue"])],64)}}});export{j as default};
