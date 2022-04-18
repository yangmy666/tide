import{r as e}from"./index.1a5cc2f6.js";import{E as t}from"./vendor.83ae7723.js";var n={exports:{}},r=function(e,t){return function(){for(var n=new Array(arguments.length),r=0;r<n.length;r++)n[r]=arguments[r];return e.apply(t,n)}},o=r,s=Object.prototype.toString;function i(e){return Array.isArray(e)}function a(e){return void 0===e}function u(e){return"[object ArrayBuffer]"===s.call(e)}function c(e){return null!==e&&"object"==typeof e}function f(e){if("[object Object]"!==s.call(e))return!1;var t=Object.getPrototypeOf(e);return null===t||t===Object.prototype}function l(e){return"[object Function]"===s.call(e)}function p(e,t){if(null!=e)if("object"!=typeof e&&(e=[e]),i(e))for(var n=0,r=e.length;n<r;n++)t.call(null,e[n],n,e);else for(var o in e)Object.prototype.hasOwnProperty.call(e,o)&&t.call(null,e[o],o,e)}var d={isArray:i,isArrayBuffer:u,isBuffer:function(e){return null!==e&&!a(e)&&null!==e.constructor&&!a(e.constructor)&&"function"==typeof e.constructor.isBuffer&&e.constructor.isBuffer(e)},isFormData:function(e){return"[object FormData]"===s.call(e)},isArrayBufferView:function(e){return"undefined"!=typeof ArrayBuffer&&ArrayBuffer.isView?ArrayBuffer.isView(e):e&&e.buffer&&u(e.buffer)},isString:function(e){return"string"==typeof e},isNumber:function(e){return"number"==typeof e},isObject:c,isPlainObject:f,isUndefined:a,isDate:function(e){return"[object Date]"===s.call(e)},isFile:function(e){return"[object File]"===s.call(e)},isBlob:function(e){return"[object Blob]"===s.call(e)},isFunction:l,isStream:function(e){return c(e)&&l(e.pipe)},isURLSearchParams:function(e){return"[object URLSearchParams]"===s.call(e)},isStandardBrowserEnv:function(){return("undefined"==typeof navigator||"ReactNative"!==navigator.product&&"NativeScript"!==navigator.product&&"NS"!==navigator.product)&&("undefined"!=typeof window&&"undefined"!=typeof document)},forEach:p,merge:function e(){var t={};function n(n,r){f(t[r])&&f(n)?t[r]=e(t[r],n):f(n)?t[r]=e({},n):i(n)?t[r]=n.slice():t[r]=n}for(var r=0,o=arguments.length;r<o;r++)p(arguments[r],n);return t},extend:function(e,t,n){return p(t,(function(t,r){e[r]=n&&"function"==typeof t?o(t,n):t})),e},trim:function(e){return e.trim?e.trim():e.replace(/^\s+|\s+$/g,"")},stripBOM:function(e){return 65279===e.charCodeAt(0)&&(e=e.slice(1)),e}},h=d;function m(e){return encodeURIComponent(e).replace(/%3A/gi,":").replace(/%24/g,"$").replace(/%2C/gi,",").replace(/%20/g,"+").replace(/%5B/gi,"[").replace(/%5D/gi,"]")}var g=function(e,t,n){if(!t)return e;var r;if(n)r=n(t);else if(h.isURLSearchParams(t))r=t.toString();else{var o=[];h.forEach(t,(function(e,t){null!=e&&(h.isArray(e)?t+="[]":e=[e],h.forEach(e,(function(e){h.isDate(e)?e=e.toISOString():h.isObject(e)&&(e=JSON.stringify(e)),o.push(m(t)+"="+m(e))})))})),r=o.join("&")}if(r){var s=e.indexOf("#");-1!==s&&(e=e.slice(0,s)),e+=(-1===e.indexOf("?")?"?":"&")+r}return e},y=d;function v(){this.handlers=[]}v.prototype.use=function(e,t,n){return this.handlers.push({fulfilled:e,rejected:t,synchronous:!!n&&n.synchronous,runWhen:n?n.runWhen:null}),this.handlers.length-1},v.prototype.eject=function(e){this.handlers[e]&&(this.handlers[e]=null)},v.prototype.forEach=function(e){y.forEach(this.handlers,(function(t){null!==t&&e(t)}))};var b=v,w=d,E=function(e,t,n,r,o){return e.config=t,n&&(e.code=n),e.request=r,e.response=o,e.isAxiosError=!0,e.toJSON=function(){return{message:this.message,name:this.name,description:this.description,number:this.number,fileName:this.fileName,lineNumber:this.lineNumber,columnNumber:this.columnNumber,stack:this.stack,config:this.config,code:this.code,status:this.response&&this.response.status?this.response.status:null}},e},S={silentJSONParsing:!0,forcedJSONParsing:!0,clarifyTimeoutError:!1},O=E,j=function(e,t,n,r,o){var s=new Error(e);return O(s,t,n,r,o)},x=j,A=d,N=A.isStandardBrowserEnv()?{write:function(e,t,n,r,o,s){var i=[];i.push(e+"="+encodeURIComponent(t)),A.isNumber(n)&&i.push("expires="+new Date(n).toGMTString()),A.isString(r)&&i.push("path="+r),A.isString(o)&&i.push("domain="+o),!0===s&&i.push("secure"),document.cookie=i.join("; ")},read:function(e){var t=document.cookie.match(new RegExp("(^|;\\s*)("+e+")=([^;]*)"));return t?decodeURIComponent(t[3]):null},remove:function(e){this.write(e,"",Date.now()-864e5)}}:{write:function(){},read:function(){return null},remove:function(){}},C=function(e){return/^([a-z][a-z\d+\-.]*:)?\/\//i.test(e)},R=function(e,t){return t?e.replace(/\/+$/,"")+"/"+t.replace(/^\/+/,""):e},T=d,P=["age","authorization","content-length","content-type","etag","expires","from","host","if-modified-since","if-unmodified-since","last-modified","location","max-forwards","proxy-authorization","referer","retry-after","user-agent"],U=d,k=U.isStandardBrowserEnv()?function(){var e,t=/(msie|trident)/i.test(navigator.userAgent),n=document.createElement("a");function r(e){var r=e;return t&&(n.setAttribute("href",r),r=n.href),n.setAttribute("href",r),{href:n.href,protocol:n.protocol?n.protocol.replace(/:$/,""):"",host:n.host,search:n.search?n.search.replace(/^\?/,""):"",hash:n.hash?n.hash.replace(/^#/,""):"",hostname:n.hostname,port:n.port,pathname:"/"===n.pathname.charAt(0)?n.pathname:"/"+n.pathname}}return e=r(window.location.href),function(t){var n=U.isString(t)?r(t):t;return n.protocol===e.protocol&&n.host===e.host}}():function(){return!0};function B(e){this.message=e}B.prototype.toString=function(){return"Cancel"+(this.message?": "+this.message:"")},B.prototype.__CANCEL__=!0;var L=B,q=d,_=function(e,t,n){var r=n.config.validateStatus;n.status&&r&&!r(n.status)?t(x("Request failed with status code "+n.status,n.config,null,n.request,n)):e(n)},D=N,J=g,z=function(e,t){return e&&!C(t)?R(e,t):t},F=function(e){var t,n,r,o={};return e?(T.forEach(e.split("\n"),(function(e){if(r=e.indexOf(":"),t=T.trim(e.substr(0,r)).toLowerCase(),n=T.trim(e.substr(r+1)),t){if(o[t]&&P.indexOf(t)>=0)return;o[t]="set-cookie"===t?(o[t]?o[t]:[]).concat([n]):o[t]?o[t]+", "+n:n}})),o):o},I=k,H=j,M=S,V=L,X=function(e){return new Promise((function(t,n){var r,o=e.data,s=e.headers,i=e.responseType;function a(){e.cancelToken&&e.cancelToken.unsubscribe(r),e.signal&&e.signal.removeEventListener("abort",r)}q.isFormData(o)&&delete s["Content-Type"];var u=new XMLHttpRequest;if(e.auth){var c=e.auth.username||"",f=e.auth.password?unescape(encodeURIComponent(e.auth.password)):"";s.Authorization="Basic "+btoa(c+":"+f)}var l=z(e.baseURL,e.url);function p(){if(u){var r="getAllResponseHeaders"in u?F(u.getAllResponseHeaders()):null,o={data:i&&"text"!==i&&"json"!==i?u.response:u.responseText,status:u.status,statusText:u.statusText,headers:r,config:e,request:u};_((function(e){t(e),a()}),(function(e){n(e),a()}),o),u=null}}if(u.open(e.method.toUpperCase(),J(l,e.params,e.paramsSerializer),!0),u.timeout=e.timeout,"onloadend"in u?u.onloadend=p:u.onreadystatechange=function(){u&&4===u.readyState&&(0!==u.status||u.responseURL&&0===u.responseURL.indexOf("file:"))&&setTimeout(p)},u.onabort=function(){u&&(n(H("Request aborted",e,"ECONNABORTED",u)),u=null)},u.onerror=function(){n(H("Network Error",e,null,u)),u=null},u.ontimeout=function(){var t=e.timeout?"timeout of "+e.timeout+"ms exceeded":"timeout exceeded",r=e.transitional||M;e.timeoutErrorMessage&&(t=e.timeoutErrorMessage),n(H(t,e,r.clarifyTimeoutError?"ETIMEDOUT":"ECONNABORTED",u)),u=null},q.isStandardBrowserEnv()){var d=(e.withCredentials||I(l))&&e.xsrfCookieName?D.read(e.xsrfCookieName):void 0;d&&(s[e.xsrfHeaderName]=d)}"setRequestHeader"in u&&q.forEach(s,(function(e,t){void 0===o&&"content-type"===t.toLowerCase()?delete s[t]:u.setRequestHeader(t,e)})),q.isUndefined(e.withCredentials)||(u.withCredentials=!!e.withCredentials),i&&"json"!==i&&(u.responseType=e.responseType),"function"==typeof e.onDownloadProgress&&u.addEventListener("progress",e.onDownloadProgress),"function"==typeof e.onUploadProgress&&u.upload&&u.upload.addEventListener("progress",e.onUploadProgress),(e.cancelToken||e.signal)&&(r=function(e){u&&(n(!e||e&&e.type?new V("canceled"):e),u.abort(),u=null)},e.cancelToken&&e.cancelToken.subscribe(r),e.signal&&(e.signal.aborted?r():e.signal.addEventListener("abort",r))),o||(o=null),u.send(o)}))},W=d,$=function(e,t){w.forEach(e,(function(n,r){r!==t&&r.toUpperCase()===t.toUpperCase()&&(e[t]=n,delete e[r])}))},K=E,G={"Content-Type":"application/x-www-form-urlencoded"};function Q(e,t){!W.isUndefined(e)&&W.isUndefined(e["Content-Type"])&&(e["Content-Type"]=t)}var Y,Z={transitional:S,adapter:(("undefined"!=typeof XMLHttpRequest||"undefined"!=typeof process&&"[object process]"===Object.prototype.toString.call(process))&&(Y=X),Y),transformRequest:[function(e,t){return $(t,"Accept"),$(t,"Content-Type"),W.isFormData(e)||W.isArrayBuffer(e)||W.isBuffer(e)||W.isStream(e)||W.isFile(e)||W.isBlob(e)?e:W.isArrayBufferView(e)?e.buffer:W.isURLSearchParams(e)?(Q(t,"application/x-www-form-urlencoded;charset=utf-8"),e.toString()):W.isObject(e)||t&&"application/json"===t["Content-Type"]?(Q(t,"application/json"),function(e,t,n){if(W.isString(e))try{return(t||JSON.parse)(e),W.trim(e)}catch(r){if("SyntaxError"!==r.name)throw r}return(n||JSON.stringify)(e)}(e)):e}],transformResponse:[function(e){var t=this.transitional||Z.transitional,n=t&&t.silentJSONParsing,r=t&&t.forcedJSONParsing,o=!n&&"json"===this.responseType;if(o||r&&W.isString(e)&&e.length)try{return JSON.parse(e)}catch(s){if(o){if("SyntaxError"===s.name)throw K(s,this,"E_JSON_PARSE");throw s}}return e}],timeout:0,xsrfCookieName:"XSRF-TOKEN",xsrfHeaderName:"X-XSRF-TOKEN",maxContentLength:-1,maxBodyLength:-1,validateStatus:function(e){return e>=200&&e<300},headers:{common:{Accept:"application/json, text/plain, */*"}}};W.forEach(["delete","get","head"],(function(e){Z.headers[e]={}})),W.forEach(["post","put","patch"],(function(e){Z.headers[e]=W.merge(G)}));var ee=Z,te=d,ne=ee,re=function(e){return!(!e||!e.__CANCEL__)},oe=d,se=function(e,t,n){var r=this||ne;return te.forEach(n,(function(n){e=n.call(r,e,t)})),e},ie=re,ae=ee,ue=L;function ce(e){if(e.cancelToken&&e.cancelToken.throwIfRequested(),e.signal&&e.signal.aborted)throw new ue("canceled")}var fe=d,le=function(e,t){t=t||{};var n={};function r(e,t){return fe.isPlainObject(e)&&fe.isPlainObject(t)?fe.merge(e,t):fe.isPlainObject(t)?fe.merge({},t):fe.isArray(t)?t.slice():t}function o(n){return fe.isUndefined(t[n])?fe.isUndefined(e[n])?void 0:r(void 0,e[n]):r(e[n],t[n])}function s(e){if(!fe.isUndefined(t[e]))return r(void 0,t[e])}function i(n){return fe.isUndefined(t[n])?fe.isUndefined(e[n])?void 0:r(void 0,e[n]):r(void 0,t[n])}function a(n){return n in t?r(e[n],t[n]):n in e?r(void 0,e[n]):void 0}var u={url:s,method:s,data:s,baseURL:i,transformRequest:i,transformResponse:i,paramsSerializer:i,timeout:i,timeoutMessage:i,withCredentials:i,adapter:i,responseType:i,xsrfCookieName:i,xsrfHeaderName:i,onUploadProgress:i,onDownloadProgress:i,decompress:i,maxContentLength:i,maxBodyLength:i,transport:i,httpAgent:i,httpsAgent:i,cancelToken:i,socketPath:i,responseEncoding:i,validateStatus:a};return fe.forEach(Object.keys(e).concat(Object.keys(t)),(function(e){var t=u[e]||o,r=t(e);fe.isUndefined(r)&&t!==a||(n[e]=r)})),n},pe="0.26.1",de=pe,he={};["object","boolean","number","function","string","symbol"].forEach((function(e,t){he[e]=function(n){return typeof n===e||"a"+(t<1?"n ":" ")+e}}));var me={};he.transitional=function(e,t,n){return function(r,o,s){if(!1===e)throw new Error(function(e,t){return"[Axios v"+de+"] Transitional option '"+e+"'"+t+(n?". "+n:"")}(o," has been removed"+(t?" in "+t:"")));return t&&!me[o]&&(me[o]=!0),!e||e(r,o,s)}};var ge=d,ye=g,ve=b,be=function(e){return ce(e),e.headers=e.headers||{},e.data=se.call(e,e.data,e.headers,e.transformRequest),e.headers=oe.merge(e.headers.common||{},e.headers[e.method]||{},e.headers),oe.forEach(["delete","get","head","post","put","patch","common"],(function(t){delete e.headers[t]})),(e.adapter||ae.adapter)(e).then((function(t){return ce(e),t.data=se.call(e,t.data,t.headers,e.transformResponse),t}),(function(t){return ie(t)||(ce(e),t&&t.response&&(t.response.data=se.call(e,t.response.data,t.response.headers,e.transformResponse))),Promise.reject(t)}))},we=le,Ee={assertOptions:function(e,t,n){if("object"!=typeof e)throw new TypeError("options must be an object");for(var r=Object.keys(e),o=r.length;o-- >0;){var s=r[o],i=t[s];if(i){var a=e[s],u=void 0===a||i(a,s,e);if(!0!==u)throw new TypeError("option "+s+" must be "+u)}else if(!0!==n)throw Error("Unknown option "+s)}},validators:he},Se=Ee.validators;function Oe(e){this.defaults=e,this.interceptors={request:new ve,response:new ve}}Oe.prototype.request=function(e,t){"string"==typeof e?(t=t||{}).url=e:t=e||{},(t=we(this.defaults,t)).method?t.method=t.method.toLowerCase():this.defaults.method?t.method=this.defaults.method.toLowerCase():t.method="get";var n=t.transitional;void 0!==n&&Ee.assertOptions(n,{silentJSONParsing:Se.transitional(Se.boolean),forcedJSONParsing:Se.transitional(Se.boolean),clarifyTimeoutError:Se.transitional(Se.boolean)},!1);var r=[],o=!0;this.interceptors.request.forEach((function(e){"function"==typeof e.runWhen&&!1===e.runWhen(t)||(o=o&&e.synchronous,r.unshift(e.fulfilled,e.rejected))}));var s,i=[];if(this.interceptors.response.forEach((function(e){i.push(e.fulfilled,e.rejected)})),!o){var a=[be,void 0];for(Array.prototype.unshift.apply(a,r),a=a.concat(i),s=Promise.resolve(t);a.length;)s=s.then(a.shift(),a.shift());return s}for(var u=t;r.length;){var c=r.shift(),f=r.shift();try{u=c(u)}catch(l){f(l);break}}try{s=be(u)}catch(l){return Promise.reject(l)}for(;i.length;)s=s.then(i.shift(),i.shift());return s},Oe.prototype.getUri=function(e){return e=we(this.defaults,e),ye(e.url,e.params,e.paramsSerializer).replace(/^\?/,"")},ge.forEach(["delete","get","head","options"],(function(e){Oe.prototype[e]=function(t,n){return this.request(we(n||{},{method:e,url:t,data:(n||{}).data}))}})),ge.forEach(["post","put","patch"],(function(e){Oe.prototype[e]=function(t,n,r){return this.request(we(r||{},{method:e,url:t,data:n}))}}));var je=Oe,xe=L;function Ae(e){if("function"!=typeof e)throw new TypeError("executor must be a function.");var t;this.promise=new Promise((function(e){t=e}));var n=this;this.promise.then((function(e){if(n._listeners){var t,r=n._listeners.length;for(t=0;t<r;t++)n._listeners[t](e);n._listeners=null}})),this.promise.then=function(e){var t,r=new Promise((function(e){n.subscribe(e),t=e})).then(e);return r.cancel=function(){n.unsubscribe(t)},r},e((function(e){n.reason||(n.reason=new xe(e),t(n.reason))}))}Ae.prototype.throwIfRequested=function(){if(this.reason)throw this.reason},Ae.prototype.subscribe=function(e){this.reason?e(this.reason):this._listeners?this._listeners.push(e):this._listeners=[e]},Ae.prototype.unsubscribe=function(e){if(this._listeners){var t=this._listeners.indexOf(e);-1!==t&&this._listeners.splice(t,1)}},Ae.source=function(){var e;return{token:new Ae((function(t){e=t})),cancel:e}};var Ne=Ae,Ce=d,Re=d,Te=r,Pe=je,Ue=le;var ke=function e(t){var n=new Pe(t),r=Te(Pe.prototype.request,n);return Re.extend(r,Pe.prototype,n),Re.extend(r,n),r.create=function(n){return e(Ue(t,n))},r}(ee);ke.Axios=Pe,ke.Cancel=L,ke.CancelToken=Ne,ke.isCancel=re,ke.VERSION=pe,ke.all=function(e){return Promise.all(e)},ke.spread=function(e){return function(t){return e.apply(null,t)}},ke.isAxiosError=function(e){return Ce.isObject(e)&&!0===e.isAxiosError},n.exports=ke,n.exports.default=ke;var Be,Le,qe=n.exports;(Le=Be||(Be={}))[Le.load=0]="load",Le[Le.success=1]="success",Le[Le.warning=2]="warning",Le[Le.failure=3]="failure",Le[Le.unAuthorized=-1]="unAuthorized",Le[Le.permissionDenied=-2]="permissionDenied";const _e=qe.create({baseURL:"http://47.94.147.204/api",timeout:1e4});_e.interceptors.request.use((e=>{const t=localStorage.getItem("access-token");return null!=t&&(e.headers={"access-token":t}),e})),_e.interceptors.response.use((n=>{const r=n.data;return r.status==Be.success&&t({type:"success",title:r.message,offset:100}),r.status==Be.warning&&t({type:"warning",title:r.message,message:r.data,offset:100}),r.status==Be.failure&&t({type:"error",title:r.message,message:r.data,offset:100}),r.status==Be.unAuthorized&&(t({type:"warning",title:r.message,message:r.data,offset:100}),e.push("/login")),r.status==Be.permissionDenied&&(t({type:"warning",title:r.message,message:r.data,offset:100}),e.back()),r}),(e=>{let{message:n}=e;return"Network Error"==n?t({type:"error",title:"后端接口连接异常",offset:100}):n.includes("timeout")?t({type:"error",title:"系统接口请求超时",offset:100}):n.includes("Request failed with status code")&&t({type:"error",title:"系统接口"+n.substring(n.length-3)+"异常",offset:100}),Promise.reject(e)}));export{_e as i};
