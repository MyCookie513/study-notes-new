// 使用es6的语法导入js模块
import Vue from '../node_modules/vue/dist/vue';
import VueRouter from '../node_modules/vue-router/dist/vue-router';
import loginForm from './user/login';
import registerForm from './user/register';
import './css/index.css'
Vue.use(VueRouter);

// 创建vue对象
const router = new VueRouter({
    routes: [ // 编写路由规则
        // path: 路由请求路径；component：组件名称
        {path: "/login", component: loginForm},
        {path: "/register", component: registerForm}
    ]
});
var vm = new Vue({
    el: "#app",
    components: {
        loginForm,
        registerForm
    },
    router
});