
<!--
  左侧导航栏
-->

<template>
  <div id="navigation">
    <ul>
      <!-- 循环遍历一级菜单，判断点击选中、鼠标浮动样式 -->
      <li
        v-for="(nav,key) in menus"
        :class=" key === pKey ? 'active' : ''"
        @click="clickParentBtn(nav, key)"
      >
        <!-- 设置一级菜单图标和名称 -->
        <span><i :class="'fa ' + nav.icon" />&nbsp;&nbsp;{{ nav.menuName }}</span>

        <!-- 设置一级菜单图标，判断如果菜单展开状态，箭头向上，反之向下 -->
        <span v-if="nav.children && nav.children.length > 0"><i :class="'fa ' + (key === pKey ? 'fa-angle-up' : 'fa-angle-down')" /></span>

        <!-- 设置一级菜单右侧选中‘缺口’图标 如果点击的是当前一级菜单并且没有子节点则显示缺口 -->
        <span v-if="key === pKey && nav.children === undefined"><i :class="'fa fa-caret-left caret'" /></span>

        <!-- 设置一级菜单右侧选中‘缺口’图标 如果点击的是当前一级菜单并且有子节点，并且子节点个数为0则显示缺口 -->
        <span v-if="key === pKey && nav.children && nav.children.length === 0"><i :class="'fa fa-caret-left caret'" /></span>

        <!-- 判断是否有二级菜单，如果有则显示，反之则隐藏 -->
        <div
          :class="'child ' + (key === pKey ? ' is-show' : 'is-hide')"
          v-if="nav.children && nav.children.length > 0"
        >
          <ul>
            <!--
                 循环二级菜单
                 判断是否有二级菜单，如果有则显示，反之则隐藏
                 如果一级菜单被点击，则显示二级菜单，反之则隐藏
            -->
            <li
              :class="index === cKey ? 'active' : ''"
              v-for="(child, index) in nav.children"
              @click.stop="clickChildBtn(child, index)"
            >
              <span><i :class="'fa ' + child.icon" />&nbsp;&nbsp;{{ child.menuName }}</span>
              <span><i :class="'fa ' + (index === cKey ? 'fa-caret-left caret' : '')" /></span>
            </li>
          </ul>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>

    export default {

        /**
         *  组件名称
         */
        name: "Navigation"

        ,data() {
            return {
                pKey: 0           // 系统默认自动展开选中第一个一级菜单
                ,cKey: 0          // 系统默认自动选中第一个一级菜单下的第一个二级菜单
                ,menus:[{
                    id: 0,
                    menuName: '主页',
                    icon: 'fa-home',
                    code: 'dashboard',
                    path: '/hatech/dashboard',
                    params: "{\"menu\":\"主页\"}"
                }]
            }
        }
        ,created(){
            // 初始化加载菜单
            this.initMenuAndRouters();
        }
        ,mounted(){



        }
        ,methods: {

            /**
             * 初始化菜单和路由
             *
             */
            initMenuAndRouters(){
                let menuStore = sessionStorage.getItem("menu");
                this.menus = this.menus.concat(JSON.parse(menuStore));

              // this.$get("/api/menu/list", {}).then( response => {
              //   let allRouters = this.$router.options.routes;
              //   // 添加子目录路径跳转
              //   let hatechRouter = allRouters.find(function(router){
              //       if (router.path === "/hatech") {
              //           return router;
              //       }
              //   });
              //   let routers = hatechRouter.children;
              //   routers.push({
              //       path: '/hatech/dashboard',
              //       name: 'dashboard',
              //       params: {menu:'主页'},
              //       component: resolve => require(['@/components/views/dashboard/Dashboard.vue'], resolve)
              //   });
              //   if(response.data && response.data.length > 0){
              //     this.menus = this.menus.concat(response.data);
              //     for(let menu of response.data) {
              //       routers.push({
              //         path: "/hatech/" + menu.code,
              //         name: menu.code,
              //         params: menu.params,
              //         component: resolve => require(['@/components' + menu.path + '.vue'], resolve)
              //       });
              //       if(menu.children && menu.children.length > 0) {
              //         for(let router of menu.children) {
              //           routers.push({
              //             path: "/hatech/" + router.code,
              //             name: router.code,
              //             params: router.params,
              //             component: resolve => require(['@/components' + router.path + '.vue'], resolve)
              //           });
              //         }
              //       }
              //     }
              //   }
              //   // console.log(routers);
              //   // this.$router.addRoutes(routers);
              //   console.log(allRouters);
              //   this.$router.addRoutes(allRouters);
              // }).catch( error => {
              //     console.log(error);
              // });

            },

            /**
             * 左侧一级菜单点击事件，触发路由跳转
             * @Method controlBtn
             */
            clickParentBtn(menu, key){
                this.pKey = key;        // 点击一级菜单：改变当前点击菜单的下标
                this.cKey = 0;          // 默认展示第一个二级菜单
                // 点击一级菜单，判断是否有子节点，如果有则显示默认子节点的第一个节点，进行路由跳转
                if(menu.children && menu.children.length > 0){
                    this.$router.push({name: menu.children[0].code, params: JSON.parse(menu.params)});
                }else {
                    this.$router.push({name: menu.code, params: JSON.parse(menu.params) });
                }
            }

            /**
             * 左侧二级菜单点击事件，触发路由跳转
             * @Method controlBtn
             */
            ,clickChildBtn(menu, index){
                this.cKey = index;
                this.$router.push({name: menu.code,params: JSON.parse(menu.params)});
            }

        }
    }
</script>

<style scoped lang="scss">
  @import "../../assets/css/navigation";
</style>
