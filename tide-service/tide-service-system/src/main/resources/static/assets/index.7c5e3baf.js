import{i as t}from"./index.364deb38.js";import{d as a,f as s,m as e,r,o as l,c as d,w as i,u as o,h as u}from"./vendor.c8305d94.js";import"./index.4d63a568.js";const m=a({setup(a){let m=s([]);return e((()=>{(class{static list(a={}){return t({method:"GET",url:"/tide-system/user/list",params:a})}}).list().then((t=>{m.value=t.data}))})),(t,a)=>{const s=r("el-table-column"),e=r("el-table");return l(),d(e,{data:o(m),style:{width:"100%"}},{default:i((()=>[u(s,{prop:"id",label:"ID",width:"180"}),u(s,{prop:"username",label:"用户名",width:"180"})])),_:1},8,["data"])}}});export{m as default};
