
import Vue from 'vue';
import ElementUI from 'element-ui';
import router from './router/routers';
import {get,post,patch,put, del} from './config/http'


import 'font-awesome/css/font-awesome.css';
import './assets/css/font/hatech-icon.css';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/css/hatech.scss';

import Hatech from './Hatech';

import Home from "./Home";

//定义全局变量
Vue.prototype.$get = get;
Vue.prototype.$post = post;
Vue.prototype.$patch = patch;
Vue.prototype.$put = put;
Vue.prototype.$delete = del;

Vue.use(ElementUI);

new Vue({
  el: '#hatech'
  ,router
  // ,render: h => h(Hatech)
  ,render: h => h(Home)
});
