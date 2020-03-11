<template>
  <div class="myPage">
    <div class="top">
      <el-button @click="getPicture('png')" type="primary">下载当前窗口可见图形（png）</el-button>
      <el-button @click="getPicture('jpg')" type="primary">下载当前页面全部图形（jpg）</el-button>
      <el-button @click="getPicture('url')" type="primary">获取base64</el-button>
    </div>
    <div ref="canvasDiv" class="canvasDiv"></div>
    <div class="code">
      <el-scrollbar style="height: 100%">
				<pre>
					<code class="javascript">
            //创建一个gdraw对象

            var gd = new Gdraw(Dom);

            //添加你的图形

            //直接下载图片

            this.gd.savePicture({
              backgroundColor:"#FFF", //要添加的背景颜色
              type:"window", //类型，window导出当前可见的，all导出当前页面被渲染的
              name:"test", //名称
              format:"png"  //canvas可以导出的格式
            })

            //或者base64

            this.gd.getDataURL({
              backgroundColor:"#FFF",
              type:"window",
              format:"png"
            }))

            //要注意的是，如果type选择为all，则必须使用page功能。
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
        gd:null
      }
    },
    components: {},
    computed: {},
    methods: {
      getPicture:function(type){
        if(type){
          if(type=="png"){
            this.gd.savePicture({
              backgroundColor:"#FFF",
              type:"window",
              name:"window",
              format:"png"
            })
          }else if(type=="jpg"){
            this.gd.savePicture({
              backgroundColor:"#FFF",
              type:"all",
              name:"all",
              format:"jpg"
            })
          }else{
            alert(this.gd.getDataURL({
              backgroundColor:"#FFF",
              type:"window",
              format:"png"
            }))
          }
        }

      }
    },
    created() {
    },
    mounted() {
      let gd = new Gdraw(this.$refs.canvasDiv);
      this.gd = gd;
      commonUtil.drawSizeCon([gd]);


      let page = gd.pageAdmin.open();
      let circle = new Gdraw.Circle({
        shape: {
          cx: 50,
          cy: 300,
          r: 100,
        },
        style: {
          stroke: '#802cff',
          fill: '#8fff5c',
          text: "当前窗口部分可见",
        },
      });
      page.add(circle);

      let circle2 = new Gdraw.Circle({
        shape: {
          cx: 400,
          cy: 300,
          r: 100,
        },
        style: {
          stroke: '#ff6fd6',
          fill: '#77cfff',
          text: "当前窗口可见",
        },
      });

      page.add(circle2);
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
    border-radius: 5px;
    line-height: 50px;
    width: 100%;
    background-color: #c5c3d6;
    height:50px;
    .text{
      text-align: center;
    }
  }
</style>
