import{i as a}from"./index.c5ffa6eb.js";import{d as t,f as s,m as e,r,o as d,c as l,w as i,u as o,h as u}from"./vendor.c8305d94.js";import"./index.ea8dd21d.js";const m=t({setup(t){let m=s([]);return e((()=>{(class{static list(t={}){return a({method:"GET",url:"/tide-system/user/list",params:t})}}).list().then((a=>{m.value=a.data}))})),(a,t)=>{const s=r("el-table-column"),e=r("el-table");return d(),l(e,{data:o(m),style:{width:"100%"}},{default:i((()=>[u(s,{prop:"id",label:"ID",width:"180"}),u(s,{prop:"username",label:"用户名",width:"180"})])),_:1},8,["data"])}}});export{m as default};