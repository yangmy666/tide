import{d as s,r as e,o as t,c as a,w as n,m as o,t as r,j as i,k as u,f as l,g as d,F as c,n as m,u as q}from"./vendor.068ae998.js";import{r as p}from"./index.60e66b1e.js";import{i as h}from"./index.33b684e9.js";const f={class:"card-header"},g={style:{"text-align":"left"}},y={style:{float:"right"}},v=s({props:{questioner:null,question:null,star:null},setup:s=>(u,l)=>{const d=e("el-card");return t(),a(d,{shadow:"hover",style:{margin:"5px"}},{default:n((()=>[o("div",f,[o("span",g,r(s.questioner),1),o("span",y,r(s.star),1)]),i(" "+r(s.question),1)])),_:1})}});const x={style:{margin:"0 auto",width:"50%"}},C=s({setup(s){u((()=>{const s=sessionStorage.getItem("questionsCache");null!=s?e.value=JSON.parse(s):class{static list(){return h({method:"GET",url:"/tide-system/question/recommend"})}}.list().then((s=>{e.value=s.data}))}));let e=l([]);return(s,n)=>(t(),d("div",x,[(t(!0),d(c,null,m(q(e),((s,n)=>(t(),a(v,{questioner:s.questioner,question:s.question,star:Number(s.star),key:n,onClick:t=>function(s){const t=JSON.stringify(e.value);sessionStorage.setItem("questionsCache",t),p.push({path:"/questionContext",query:{questionId:s}})}(Number(s.id))},null,8,["questioner","question","star","onClick"])))),128))]))}});export{C as default};