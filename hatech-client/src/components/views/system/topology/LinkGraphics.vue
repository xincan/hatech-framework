<template>
  <div class="myPage">
    <div class="top">
      <div class='text'>图形连线</div>
    </div>
    <div  ref='canvasDiv' class="canvasDiv">

    </div>
    <div class="code">
      <el-scrollbar style="height: 100%">
				<pre>
					<code class="javascript">
            //创建一个gdraw对象
            var gd = new Gdraw(Dom);

            //添加图形
            var circle = new Gdraw.Circle({
              draggable:true,
              shape: {
                cx: 100,
                cy: 200,
                r: 50,
              },
              style: {
                stroke: '#802cff',
                fill: '#8fff5c',
                text: "from",
              },
            });
            gd.add(circle);
            var rect = new Gdraw.Rect({
              draggable:true,
              shape: {
                x: 300,
                y: 100,
                width: 200,
                height: 100,
              },
              style: {
                stroke: '#6d73ff',
                fill: '#989bff',
                text: "to",
              },
            });
            gd.add(rect);

            //将圆和矩形链接
            var link = new Gdraw.Link({
              from:circle,
              to:rect,
              style:{
                stroke: '#ff131c'
              },
              shape:{
                breakPoints:[[200,150]], //折断点的坐标[x,y]
                arrowLength:0
              }

            })
            gd.add(link);

            //为连线添加高亮
            link.on('mouseover', function () {
              gd.addHover(this, {
                stroke: '#8684ff',
                lineWidth: 3
              });
            });
            link.on('mouseout', function () {
              gd.removeHover(this);
            });

            //再添加一个心形
            var heart = new Gdraw.Heart({
              draggable:true,
              shape: {
                cx: 250,
                cy: 350,
                width: 70,
                height: 110,
              },
              style: {
                stroke: '#ff443a',
                fill: '#ff8dc9',
                text: "to",
              },
            });
            gd.add(heart);

            //空心箭头链接圆和心形
            var link2 = new Gdraw.Link({
              from:circle,
              to:heart,
              linkPointsType:['bottom','intersect']
            })
            gd.add(link2);

            //实心箭头链接矩形和心形
            var link3 = new Gdraw.Link({
              from:rect,
              to:heart,
              linkPointsType:['intersect','intersect'],
              shape:{
                arrowType:'solid'  //arrowType箭头类型:hollow/solid
              },
              style:{
                fill:'#777dff'
              }
            })
            gd.add(link3);
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
      var gd = new Gdraw(this.$refs.canvasDiv);
      commonUtil.drawSizeCon([gd]);

      var circle = new Gdraw.Circle({
        draggable:true,
        shape: {
          cx: 100,
          cy: 200,
          r: 50,
        },
        style: {
          stroke: '#802cff',
          fill: '#8fff5c',
          text: "Circle",
        },
      });
      gd.add(circle);

      var rect = new Gdraw.Rect({
        draggable:true,
        shape: {
          x: 300,
          y: 100,
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

      var link = new Gdraw.Link({
        from:circle,
        to:rect,
        style:{
          stroke: '#ff131c'
        },
        shape:{
          breakPoints:[[200,150],[220,200]], //折断点的坐标[x,y]
          arrowLength:0, //箭头长度
        }
      })
      gd.add(link);

      link.on('mouseover', function () {
        gd.addHover(this, {
          stroke: '#8684ff',
          lineWidth: 3
        });
      });
      link.on('mouseout', function () {
        gd.removeHover(this);
      });


      var heart = new Gdraw.Heart({
        draggable:true,
        shape: {
          cx: 250,
          cy: 350,
          width: 70,
          height: 110,
        },
        style: {
          stroke: '#ff443a',
          fill: '#ff8dc9',
          text: "Heart",
        },
      });
      gd.add(heart);

      var link2 = new Gdraw.Link({
        from:circle,
        to:heart,
        linkPointsType:['bottom','intersect']
      })
      gd.add(link2);


      var link3 = new Gdraw.Link({
        from:rect,
        to:heart,
        linkPointsType:['intersect','intersect'],//定义点连接的位置 bottom top left right intersect
        shape:{
          arrowType:'solid' //定义箭头的类型 hollow(默认),solid
        },
        style:{
          fill:'#777dff'
        }
      })

      gd.add(link3);

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
