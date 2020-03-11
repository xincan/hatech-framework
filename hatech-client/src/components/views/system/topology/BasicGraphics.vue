<template>
  <div class="myPage">
    <div class="top">
      <div class='text'>创建基本图形</div>
    </div>
    <div ref="canvasDiv" class="canvasDiv"></div>
    <img v-show="false" ref="image" src="@/assets/READMEFile/dashboard.png">
    <div class="code">
      <el-scrollbar style="height: 100%">
				<pre>
					<code class="javascript">
            //创建一个gdraw对象
            var gd = new Gdraw(Dom);

            //添加一个空心圆
            var arc = new Gdraw.Circle({
              shape: {
                cx: 100,
                cy: 100,
                r: 50,
              },
              style: {
                stroke: '#5a3eff',
                fill:null,
                lineWidth: 5,
                text: "Circle",
              }
            });
            gd.add(arc)

            //添加一个可以拖拽的实心矩形
            var rect = new Gdraw.Rect({
              draggable:true,
              shape: {
                x: 200,
                y: 50,
                width: 200,
                height: 100,
              },
              style: {
                stroke: '#6d73ff',
                fill: '#989bff',
                text: "Rect",
              },
            });
            gd.add(rect);
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
    return {}
  },
  components: {},
  computed: {},
  methods: {},
  created() {
  },
  mounted() {
    let gd = new Gdraw(this.$refs.canvasDiv);
    commonUtil.drawSizeCon([gd]);
    console.log(this.$refs.image.getAttribute('src'),"--------src-----------");
    //添加一个圆形
    let arc = new Gdraw.Circle({
      shape: {
        cx: 100,
        cy: 100,
        r: 50,
      },
      style: {
        stroke: '#5a3eff',
        fill:null,
        lineWidth: 5,
        text: "Circle",
      },
    });
    gd.add(arc)
    //添加一个矩形
    let rect = new Gdraw.Rect({
      draggable:true,
      shape: {
        x: 200,
        y: 50,
        width: 200,
        height: 100,
      },
      style: {
        stroke: '#6d73ff',
        fill: '#989bff',
        text: "Rect",
        textFill:"red"
      },
    });
    gd.add(rect);

    let image = new Gdraw.Image({
      style:{
        x: 50,
        y: 200,
        width: 150,
        height: 100,
        //image:'https://img.zcool.cn/community/01205956a1ca9b6ac7256cb04025c6.png@2o.png',
        //image:this.$refs.image,
        image:'/static/resources/type_1.jpg',
        text:"Image"
      }
    });
    console.log(image,"8888888888888");

    gd.add(image);
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
