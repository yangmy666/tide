import{i as t}from"./index.33b684e9.js";import{d as a,f as e,v as s,r,o as l,c as d,w as i,u as o,h as u}from"./vendor.068ae998.js";import"./index.60e66b1e.js";const n=a({setup(a){let n=e([]);return s((()=>{(class{static list(a){return t({method:"GET",url:"/tide-system/user/list",params:a})}}).list().then((t=>{n.value=t.data}))})),(t,a)=>{const e=r("el-table-column"),s=r("el-table");return l(),d(s,{data:o(n),style:{width:"100%"}},{default:i((()=>[u(e,{prop:"id",label:"ID",width:"180"}),u(e,{prop:"username",label:"用户名",width:"180"})])),_:1},8,["data"])}}});export{n as default};