import{Q as e}from"./Question.142c65ec.js";import{r as i}from"./index.66f1d1a4.js";import{i as t}from"./index.0572f668.js";import{d as s,f as n,k as a,n as o,p as l,o as u,g as r,F as d,q as m,u as c,m as f,c as k}from"./vendor.83ae7723.js";const p={"infinite-scroll-distance":"0.5","infinite-scroll-immediate":"false",style:{margin:"0 auto",width:"60%",float:"left"}},h={style:{width:"100%",height:"300px"}},q=s({setup(s){let q=n([]),v=n(!1);function x(){v.value=!0,class{static load(){return t({method:"GET",url:"/tide-system/recommend/load"})}}.load().then((e=>{q.value=q.value.concat(e.data),v.value=!1})).catch((()=>{v.value=!1}))}return a((()=>{x()})),(t,s)=>{const n=o("loading"),a=o("infinite-scroll");return l((u(),r("div",p,[(u(!0),r(d,null,m(c(q),((t,s)=>(u(),k(e,{style:{width:"100%",margin:"10px"},questioner:t.questioner,question:t.question,likeNum:Number(t.likeNum),"is-like":t.isLike,key:s,onClick:e=>function(e){const t=i.resolve({path:"/questionContext",query:{questionId:e}}).href;window.open(t,"_blank")}(Number(t.id))},null,8,["questioner","question","likeNum","is-like","onClick"])))),128)),l(f("div",h,null,512),[[n,c(v)]])])),[[a,x]])}}});export{q as default};
