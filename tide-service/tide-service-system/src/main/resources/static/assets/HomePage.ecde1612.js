import{r as e}from"./index.2af5d905.js";import{i as l}from"./index.5238a522.js";import{d as a,f as o,r as t,o as n,g as u,h as d,w as s,u as i,j as r,k as f,l as c,F as m,s as p,m as g}from"./vendor.83ae7723.js";const x={style:{"text-align":"center"}},h=r("注册"),v=r("登录"),w=a({props:{closeLoginDialog:null},setup(a){const r=a;let f=o({username:"",password:""});const c=o(!1);function m(){c.value=!0,class{static login(e){return l({method:"POST",url:"/tide-system/login",data:e})}}.login(f.value).then((e=>{1==e.status&&(localStorage.setItem("access-token",e.data),null!=r.closeLoginDialog&&r.closeLoginDialog()),c.value=!1})).catch((()=>{c.value=!1}))}function p(){const l=e.resolve({path:"/register"}).href;window.open(l,"_blank")}return(e,l)=>{const a=t("el-input"),o=t("el-form-item"),r=t("el-form"),g=t("el-button");return n(),u("div",x,[d(r,{model:i(f),"label-width":"55px"},{default:s((()=>[d(o,{label:"账号"},{default:s((()=>[d(a,{modelValue:i(f).username,"onUpdate:modelValue":l[0]||(l[0]=e=>i(f).username=e),placeholder:"请输入账号"},null,8,["modelValue"])])),_:1}),d(o,{label:"密码"},{default:s((()=>[d(a,{modelValue:i(f).password,"onUpdate:modelValue":l[1]||(l[1]=e=>i(f).password=e),placeholder:"请输入密码",type:"password","show-password":""},null,8,["modelValue"])])),_:1})])),_:1},8,["model"]),d(g,{onClick:p},{default:s((()=>[h])),_:1}),d(g,{loading:c.value,type:"primary",onClick:m},{default:s((()=>[v])),_:1},8,["loading"])])}}}),_=g("div",{style:{margin:"auto 1%"}},null,-1),V=r("推荐"),y=r("测试"),k=r("提问"),b=r("登录"),C=r("历史记录"),U=r("BUG反馈"),j=a({setup(l){f((()=>{r()}));const a=(e,l)=>{};function r(){e.push("/recommend")}function g(){e.push("/test")}let x=o(""),h=o(!1);function v(){h.value=!1}return(e,l)=>{const o=t("el-menu-item"),f=t("el-input"),j=t("el-menu"),D=t("router-view"),F=t("el-dialog");return n(),u(m,null,[d(j,{style:{position:"fixed",top:"0",width:"100%",height:"45px",padding:"0",margin:"0","z-index":"1"},"default-active":"0","background-color":"#00BFFF","text-color":"#ffffff","active-text-color":"#ffffff",mode:"horizontal",onSelect:a},{default:s((()=>[_,d(o,{index:"0",onClick:r},{default:s((()=>[V])),_:1}),d(o,{index:"5",onClick:g},{default:s((()=>[y])),_:1}),d(f,{modelValue:i(x),"onUpdate:modelValue":l[0]||(l[0]=e=>c(x)?x.value=e:x=e),type:"text",style:{width:"15%",margin:"auto 1%  auto 55%"},placeholder:"搜索面试题","suffix-icon":i(p)},null,8,["modelValue","suffix-icon"]),d(o,{index:"1"},{default:s((()=>[k])),_:1}),d(o,{index:"2",onClick:l[1]||(l[1]=e=>c(h)?h.value=!0:h=!0)},{default:s((()=>[b])),_:1}),d(o,{index:"3"},{default:s((()=>[C])),_:1}),d(o,{index:"4"},{default:s((()=>[U])),_:1})])),_:1}),d(D,{style:{position:"absolute",top:"45px","z-index":"0"}}),d(F,{modelValue:i(h),"onUpdate:modelValue":l[2]||(l[2]=e=>c(h)?h.value=e:h=e),center:"",width:"30%",title:"登录"},{default:s((()=>[d(w,{closeLoginDialog:v})])),_:1},8,["modelValue"])],64)}}});export{j as default};
