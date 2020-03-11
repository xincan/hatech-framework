import Vue from 'vue';
import VueRouter from 'vue-router';
import axios from 'axios'

// import Dashboard from "@/components/views/dashboard/Dashboard";

// import SystemController from "@/page/system/manage/SystemController";
// import AreaManage from "@/page/system/manage/AreaManage";
// import MenuManage from "@/page/system/manage/MenuManage";
// import UserManage from "@/page/system/manage/UserManage";
// import RoleManage from "@/page/system/manage/RoleManage";
// import PermissionManage from "@/page/system/manage/PermissionManage";

// import WarnController from "@/page/system/warn/WarnController";
// import WarnManage from "@/page/system/warn/WarnManage";




const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
};

const routes = [
  {
    path: '/login',
    name: 'login',
    component: resolve => require(['@/components/views/login/LoginPage.vue'], resolve)
  }
  , {
    path: '/registry',
    name: 'registry',
    component: resolve => require(['@/components/views/login/RegistryPage.vue'], resolve)
  }
  , {
    path: '/hatech',
    name: 'hatech',
    component: resolve => require(['@/Hatech.vue'], resolve),
    children: []
  }
  , {
    path: '/',
    redirect: {name: 'login'}
  }

];

Vue.use(VueRouter);
let router = new VueRouter({routes});

let flag = 0;
router.beforeEach((to, from, next) => {
  if (to.path !== '/login' && to.path !== '/registry') {
    const token = localStorage.getItem("token");
    if (!token) {
      // 未登录则跳转到登录页
      router.push({"path": "/login"});
      return;
    }
    if (flag === 0) {
      // 初始化加载菜单
      axios.get("/api/xincan-transaction-system/menu/list", {}).then(response => {
        let allRouters = routes;
        // 添加子目录路径跳转
        let hatechRouter = allRouters.find(function (router) {
          if (router.path === "/hatech") {
            return router;
          }
        });
        let routers = hatechRouter.children;
        routers.push({
          path: '/hatech/dashboard',
          name: 'dashboard',
          params: {menu: '主页'},
          component: resolve => require(['@/components/views/dashboard/Dashboard.vue'], resolve)
        });
        let resData = response.data;
        if (resData.data && resData.data.length > 0) {
          // 将后台获取的menu写入到sessionStorage中
          sessionStorage.setItem("menu", JSON.stringify(resData.data));
          for (let menu of resData.data) {
            routers.push({
              path: "/hatech/" + menu.code,
              name: menu.code,
              params: menu.params,
              component: resolve => require(['@/components' + menu.path + '.vue'], resolve)
            });
            if (menu.children && menu.children.length > 0) {
              for (let router of menu.children) {
                routers.push({
                  path: "/hatech/" + router.code,
                  name: router.code,
                  params: router.params,
                  component: resolve => require(['@/components' + router.path + '.vue'], resolve)
                });
              }
            }
          }
        }
        router.addRoutes(allRouters);
        flag++;
        next({ ...to, replace: true});
      }).catch(error => {
        console.log(error);
      });
    } else {
      next()
    }
  } else {
    next()
  }
});

export default router;
