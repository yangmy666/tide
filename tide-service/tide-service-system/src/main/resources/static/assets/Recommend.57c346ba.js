import{d as e,k as t,f as l,r as n,o as s,c as a,w as o,h as i,u,m as r,t as d,n as c,p as f,g as p,F as m,q as h}from"./vendor.83ae7723.js";import{r as v}from"./index.7bfec6ce.js";import{i as b}from"./index.045aba51.js";const k=e({props:{num:null,isLike:{type:Boolean},size:null},setup(e){const c=e;t((()=>{c.isLike&&(f.value="../../public/like.svg")}));let f=l("../../public/notLike.svg");return(t,l)=>{const c=n("el-image"),p=n("el-button"),m=n("el-button-group");return s(),a(m,{size:e.size},{default:o((()=>[i(p,null,{default:o((()=>[i(c,{src:u(f)},null,8,["src"])])),_:1}),i(p,{disabled:""},{default:o((()=>[r("span",null,d(e.num),1)])),_:1})])),_:1},8,["size"])}}});const q={class:"card-header"},x=["textContent"],g=["textContent"];var w=((e,t)=>{const l=e.__vccOpts||e;for(const[n,s]of t)l[n]=s;return l})(e({props:{questioner:null,question:null,like:null},setup:e=>(t,l)=>{const u=n("el-button"),c=n("el-button-group"),f=n("el-card");return s(),a(f,{class:"box-card",shadow:"hover"},{header:o((()=>[r("div",q,[i(c,{size:"small"},{default:o((()=>[i(u,null,{default:o((()=>[r("span",{style:{"text-align":"left"},textContent:d(e.questioner)},null,8,x)])),_:1})])),_:1}),i(k,{style:{float:"right"},num:e.like,size:"small"},null,8,["num"])])])),default:o((()=>[r("span",{style:{"word-wrap":"break-word","word-break":"break-all",overflow:"hidden","font-weight":"bold","font-size":"15px"},textContent:d(e.question),class:"text"},null,8,g)])),_:1})}}),[["__scopeId","data-v-77a26698"]]);const _={"infinite-scroll-distance":"0.5","infinite-scroll-immediate":"false",style:{margin:"0 auto",width:"60%",float:"left"}},y={style:{width:"100%",height:"300px"}},z=e({setup(e){let n=l([]),o=l(!1);function i(){o.value=!0,class{static load(){return b({method:"GET",url:"/tide-system/recommend/load"})}}.load().then((e=>{n.value=n.value.concat(e.data),o.value=!1})).catch((()=>{o.value=!1}))}return t((()=>{i()})),(e,t)=>{const l=c("loading"),d=c("infinite-scroll");return f((s(),p("div",_,[(s(!0),p(m,null,h(u(n),((e,t)=>(s(),a(w,{style:{width:"100%",margin:"10px"},questioner:e.questioner,question:e.question,like:Number(e.like),key:t,onClick:t=>function(e){const t=v.resolve({path:"/questionContext",query:{questionId:e}}).href;window.open(t,"_blank")}(Number(e.id))},null,8,["questioner","question","like","onClick"])))),128)),f(r("div",y,null,512),[[l,u(o)]])])),[[d,i]])}}});export{z as default};
