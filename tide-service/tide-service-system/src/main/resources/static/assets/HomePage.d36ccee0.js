import{r as e}from"./index.1ea2711b.js";import{i as l}from"./index.261c904e.js";import{d as a,f as o,r as t,o as n,g as u,h as s,w as d,u as i,j as r,k as c,l as f,F as m,s as p,m as g}from"./vendor.83ae7723.js";const x={style:{"text-align":"center"}},h=r("注册"),v=r("登录"),w=a({props:{closeLoginDialog:null},setup(a){const r=a;let c=o({username:"",password:""});const f=o(!1);function m(){f.value=!0,class{static login(e){return l({method:"POST",url:"/tide-system/login",data:e})}}.login(c.value).then((e=>{1==e.status&&(localStorage.setItem("access-token",e.data),null!=r.closeLoginDialog&&r.closeLoginDialog()),f.value=!1})).catch((()=>{f.value=!1}))}function p(){const l=e.resolve({path:"/register"}).href;window.open(l,"_blank")}return(e,l)=>{const a=t("el-input"),o=t("el-form-item"),r=t("el-form"),g=t("el-button");return n(),u("div",x,[s(r,{model:i(c),"label-width":"55px"},{default:d((()=>[s(o,{label:"账号"},{default:d((()=>[s(a,{modelValue:i(c).username,"onUpdate:modelValue":l[0]||(l[0]=e=>i(c).username=e),placeholder:"请输入账号"},null,8,["modelValue"])])),_:1}),s(o,{label:"密码"},{default:d((()=>[s(a,{modelValue:i(c).password,"onUpdate:modelValue":l[1]||(l[1]=e=>i(c).password=e),placeholder:"请输入密码",type:"password","show-password":""},null,8,["modelValue"])])),_:1})])),_:1},8,["model"]),s(g,{onClick:p},{default:d((()=>[h])),_:1}),s(g,{loading:f.value,type:"primary",onClick:m},{default:d((()=>[v])),_:1},8,["loading"])])}}}),_=g("div",{style:{margin:"auto 1%"}},null,-1),V=r("推荐"),y=r("提问"),b=r("登录"),k=r("历史记录"),U=r("BUG反馈"),j=a({setup(l){c((()=>{r()}));const a=(e,l)=>{};function r(){e.push("/recommend")}let g=o(""),x=o(!1);function h(){x.value=!1}return(e,l)=>{const o=t("el-menu-item"),c=t("el-input"),v=t("el-menu"),j=t("router-view"),C=t("el-dialog");return n(),u(m,null,[s(v,{style:{position:"fixed",top:"0",width:"100%",height:"45px",padding:"0",margin:"0","z-index":"1"},"default-active":"0","background-color":"#00BFFF","text-color":"#ffffff","active-text-color":"#ffffff",mode:"horizontal",onSelect:a},{default:d((()=>[_,s(o,{index:"0",onClick:r},{default:d((()=>[V])),_:1}),s(c,{modelValue:i(g),"onUpdate:modelValue":l[0]||(l[0]=e=>f(g)?g.value=e:g=e),type:"text",style:{width:"15%",margin:"auto 1%  auto 55%"},placeholder:"搜索面试题","suffix-icon":i(p)},null,8,["modelValue","suffix-icon"]),s(o,{index:"1"},{default:d((()=>[y])),_:1}),s(o,{index:"2",onClick:l[1]||(l[1]=e=>f(x)?x.value=!0:x=!0)},{default:d((()=>[b])),_:1}),s(o,{index:"3"},{default:d((()=>[k])),_:1}),s(o,{index:"4"},{default:d((()=>[U])),_:1})])),_:1}),s(j,{style:{position:"absolute",top:"45px","z-index":"0"}}),s(C,{modelValue:i(x),"onUpdate:modelValue":l[2]||(l[2]=e=>f(x)?x.value=e:x=e),center:"",width:"30%",title:"登录"},{default:d((()=>[s(w,{closeLoginDialog:h})])),_:1},8,["modelValue"])],64)}}});export{j as default};
