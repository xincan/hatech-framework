<template>
  <div class="myPage">
    <div class="top">
      <el-button @click=getPicture() type="primary">下载图片</el-button>
      <el-button @click=back() type="primary">后退</el-button>
      <el-button @click=forward() type="primary">前进</el-button>
      <el-button  type="primary">我是页面: <span style="color: #000">{{pageName}}</span></el-button>
    </div>
    <div ref="canvasDiv" class="canvasDiv"></div>
    <div class="code">
      <el-scrollbar style="height: 100%">
				<pre>
					<code class="javascript">
            //创建一个gdraw对象
            var gd = new Gdraw(Dom);

            //创建页面page1
            var page1=gd.pageAdmin.open();

            //添加一个圆形
            var circle = new Gdraw.Circle({
              draggable:true,
              shape: {
                cx: 300,
                cy: 300,
                r: 100,
              },
              style: {
                stroke: '#802cff',
                fill: '#8fff5c',
                text: "双击我打开page2页面",
              },
            });

            //为元素添加事件，双击时打开page2
            circle.on('dblclick',function () {
              openPage2();
            })
            page1.add(circle);

            //定义page2渲染函数
            function openPage2() {
              var page2=gd.pageAdmin.open({
                dragPage:true, //开启邮件拖拽页面
                zoom:0.1,	//开启滚轮页面缩放
                zoomType:'center'  //缩放类型
              })
              var rect = new Gdraw.Rect({
                draggable:true,
                shape: {
                  x: 200,
                  y: 250,
                  width: 200,
                  height: 100,
                },
                style: {
                  stroke: '#6d73ff',
                  fill: '#989bff',
                  text: "双击我打开page3页面",
                },
              });
              rect.on('dblclick',function () {
                //打开page3
                openPage3();
              })
              page2.add(rect);
            }

            //定义page2渲染函数
            function openPage3() {
              var page3=gd.pageAdmin.open({
                dragPage:true,
                zoom:0.1,
                zoomType:'pointer'
              })
              var heart = new Gdraw.Heart({
                draggable:true,
                shape: {
                  cx: 300,
                  cy: 300,
                  width: 70,
                  height: 110,
                },
                style: {
                  stroke: '#ff443a',
                  fill: '#ff8dc9',
                  text: "",
                },
              });
              page3.add(heart);
            }

            //你可以使用这样的方式来调用前进和后退功能

            //前进
            this.gd.pageAdmin.back();

            //后退
            this.gd.pageAdmin.forward();
					</code>
				 </pre>
      </el-scrollbar>
    </div>
  </div>
</template>

<script>
  import Gdraw from '../../../../assets/classLib/gdraw/Gdraw'
  import commonUtil from '../../../../assets/js/common'

  export default {
    data() {
      return {
        pageName:"页面",
        gd:null
      }
    },
    components: {},
    computed: {},
    methods: {
      back:function () {
        this.gd.pageAdmin.back();
        this.pageName=this.gd.pageAdmin.getNowPage().myPageName;
      },
      forward:function () {
        this.gd.pageAdmin.forward();
        this.pageName=this.gd.pageAdmin.getNowPage().myPageName;
      },
      getPicture:function(){
        this.gd.savePicture({
          backgroundColor:"#aef8ff",
          type:"all",
          name:"page",
          format:"png"
        })
      }
    },
    created() {
    },
    mounted() {
      var Vue=this;
      var gd = new Gdraw(this.$refs.canvasDiv);
      Vue.gd=gd;
      commonUtil.drawSizeCon([gd]);


      var page1= gd.pageAdmin.open()
      page1.myPageName='page1(不平移，不缩放)';
      Vue.pageName=page1.myPageName;


      var arc = new Gdraw.Arc({
        draggable:true,
        shape: {
          cx: 300,
          cy: 300,
          r: 100,
        },
        style: {
          stroke: '#802cff',
          fill: '#8fff5c',
          text: "双击我打开page2页面",
        },
      });
      arc.on('dblclick',function () {
        openPage2();
        Vue.pageName=gd.pageAdmin.getNowPage().myPageName;
      })
      page1.add(arc);

      function openPage2() {
        var page2 = gd.pageAdmin.open({
          dragPage:true,
          zoom:0.1,
          zoomType:'center'
        })
        page2.myPageName='page2(开启平移，页面中心为缩放点)';
        var rect = new Gdraw.Rect({
          draggable:true,
          shape: {
            x: 200,
            y: 250,
            width: 200,
            height: 100,
          },
          style: {
            stroke: '#6d73ff',
            fill: '#989bff',
            text: "双击我打开page3页面",
          },
        });
        rect.on('dblclick',function () {
          openPage3();
          Vue.pageName=gd.pageAdmin.getNowPage().myPageName;
        })
        page2.add(rect);
      }


      function openPage3() {

        var page3=gd.pageAdmin.open({
          dragPage:true,
          zoom:0.1,
          zoomType:'pointer'
        })
        page3.myPageName='page3(开启平移，鼠标指针为缩放点)';
        var heart = new Gdraw.Heart({
          draggable:true,
          shape: {
            cx: 300,
            cy: 300,
            width: 70,
            height: 110,
          },
          style: {
            stroke: '#ff443a',
            fill: '#ff8dc9',
            text: "",
          },
        });
        page3.add(heart);
      }

    },
    destroyed: function () {
      window.onresize = null;
    }

  }
</script>

<style scoped lang="scss" rel="stylesheet/scss">
  .myPage{
    width: 100%;
    height:100%;
  }
  .canvasDiv {
    border-radius: 5px;
    float: left;
    width: 50%;
    height: calc(100% - 50px);
    background-color: #ecefff;
  }

  .busCanvasDiv {
    border-radius: 5px;
    width: 100%;
    height: calc(100% - 50px);
    background-color: #ecefff;
  }
  .code{
    font-size: 18px;
    border-radius: 5px;
    background-color: #fbfff6;
    color:#000;
    float: left;
    width: 50%;
    height: calc(100% - 50px);
  }
  .top{
    font-family: 'Adobe 楷体 Std R';
    line-height: 50px;
    border-radius: 5px;
    width: 100%;
    background-color: #c5c3d6;
    height:50px;
    .text{
      text-align: center;
    }
  }
</style>
