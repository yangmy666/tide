import{d as e,r as t,o as r,c as o,a as n,b as s,e as i,i as c}from"./vendor.83ae7723.js";!function(){const e=document.createElement("link").relList;if(!(e&&e.supports&&e.supports("modulepreload"))){for(const e of document.querySelectorAll('link[rel="modulepreload"]'))t(e);new MutationObserver((e=>{for(const r of e)if("childList"===r.type)for(const e of r.addedNodes)"LINK"===e.tagName&&"modulepreload"===e.rel&&t(e)})).observe(document,{childList:!0,subtree:!0})}function t(e){if(e.ep)return;e.ep=!0;const t=function(e){const t={};return e.integrity&&(t.integrity=e.integrity),e.referrerpolicy&&(t.referrerPolicy=e.referrerpolicy),"use-credentials"===e.crossorigin?t.credentials="include":"anonymous"===e.crossorigin?t.credentials="omit":t.credentials="same-origin",t}(e);fetch(e.href,t)}}();const d=e({setup:e=>(e,n)=>{const s=t("router-view");return r(),o(s)}}),a={},l=function(e,t){return t&&0!==t.length?Promise.all(t.map((e=>{if((e=`./${e}`)in a)return;a[e]=!0;const t=e.endsWith(".css"),r=t?'[rel="stylesheet"]':"";if(document.querySelector(`link[href="${e}"]${r}`))return;const o=document.createElement("link");return o.rel=t?"stylesheet":"modulepreload",t||(o.as="script",o.crossOrigin=""),o.href=e,document.head.appendChild(o),t?new Promise(((e,t)=>{o.addEventListener("load",e),o.addEventListener("error",t)})):void 0}))).then((()=>e())):e()},u=[{path:"/test",component:()=>l((()=>import("./Test.ad3220b1.js")),["assets/Test.ad3220b1.js","assets/vendor.83ae7723.js"])},{path:"/",component:()=>l((()=>import("./HomePage.79659dbf.js")),["assets/HomePage.79659dbf.js","assets/index.0572f668.js","assets/vendor.83ae7723.js"]),children:[{path:"/recommend",component:()=>l((()=>import("./Recommend.d3156a4d.js")),["assets/Recommend.d3156a4d.js","assets/Question.142c65ec.js","assets/Question.8796e391.css","assets/vendor.83ae7723.js","assets/index.0572f668.js"])}]},{path:"/questionContext",component:()=>l((()=>import("./QuestionContext.02459f36.js")),["assets/QuestionContext.02459f36.js","assets/vendor.83ae7723.js","assets/index.0572f668.js","assets/Question.142c65ec.js","assets/Question.8796e391.css"])},{path:"/register",component:()=>l((()=>import("./Register.25212de2.js")),["assets/Register.25212de2.js","assets/index.0572f668.js","assets/vendor.83ae7723.js"])}],m=n({history:s(),routes:u});const p=i(d);p.use(m),p.use(c),p.mount("#app");export{m as r};