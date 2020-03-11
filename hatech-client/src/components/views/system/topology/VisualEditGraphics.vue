<template>
  <div class="myPage">
    <div class="top">
      <el-button @click="addGraph('rect')" type="primary">添加矩形</el-button>
      <el-button @click="addGraph('isogon')" type="primary">添加正六边形</el-button>
      <el-button @click="addGraph('ellipse')" type="primary">添加椭圆</el-button>
      <el-button @click="addGraph('circle')" type="primary">添加圆形</el-button>
      <el-button @click="addGraph('rhombus')" type="primary">添加菱形</el-button>
      <el-button @click="myDelete" type="primary">删除</el-button>
      <el-button @click="save" type="primary">console.log(data)</el-button>
    </div>
    <div ref="canvasDiv" class="canvasDiv"></div>
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
      addGraph:function (type) {
        if(type=='rect'){
          let rect=new Gdraw.Rect({
            draggable:true,
            shape: {
              x: 50,
              y: 50,
              width: 200,
              height: 100,
            },
            style: {
              stroke: '#6d73ff',
              fill: '#d7f1ff',
              text: 'test',
              lineWidth:3
            },
          })
          this.editor.add(rect);
        }else if(type=='isogon'){
          let rect=new Gdraw.Isogon({
            draggable:true,
            shape: {
              x: 100,
              y: 100,
              r: 50,
              n:6
            },
            style: {
              stroke: '#6d73ff',
              fill: '#d7f1ff',
              text: 'test',
              lineWidth:3
            },
          })
          this.editor.add(rect);
        }else if(type=='circle'){
          let rect=new Gdraw.Circle({
            draggable:true,
            shape: {
              cx: 100,
              cy: 100,
              r: 50,
            },
            style: {
              stroke: '#6d73ff',
              fill: '#d7f1ff',
              text: 'test',
              lineWidth:3
            },
          })
          this.editor.add(rect);
        }else if(type=='ellipse'){
          let rect=new Gdraw.Ellipse({
            draggable:true,
            shape: {
              cx: 100,
              cy: 100,
              rx: 100,
              ry: 50,
            },
            style: {
              stroke: '#6d73ff',
              fill: '#d7f1ff',
              text: 'test',
              lineWidth:3
            },
          })
          this.editor.add(rect);
        }else if(type=='rhombus'){
          let rect=new Gdraw.Polygon({
            draggable:true,
            shape: {
              points: [[100,100],[150,150],[100,200],[50,150]],
            },
            style: {
              stroke: '#6d73ff',
              fill: '#d7f1ff',
              text: 'test',
              lineWidth:3
            },
          })
          this.editor.add(rect);
        }

      },
      myDelete:function () {
        this.editor.remove(this.editor.getSelected())
      },
      save:function () {
        console.log(this.editor.getEditedElment())
      }
    },
    created() {
    },
    mounted() {
      var Vue=this;
      var gd = new Gdraw(this.$refs.canvasDiv);
      Vue.gd=gd;
      commonUtil.drawSizeCon([gd]);



      var page=gd.pageAdmin.open({
        dragPage:true,
        zoom:0.1,
        zoomType:'center'
      })

      var editor=new Gdraw.Editor()
      Vue.editor=editor;

      page.add(editor);

      let rect = new Gdraw.Rect({
        draggable:true,
        position:[-50,0],
        shape: {
          x: 300,
          y: 300,
          width: 200,
          height: 100,
        },
        style: {
          stroke: '#6d73ff',
          fill: '#d7f1ff',
          text: 'test',
          lineWidth:3
        },
      });

      let rect2 = new Gdraw.Rect({
        draggable:true,
        shape: {
          x: 800,
          y: 300,
          width: 200,
          height: 100,
        },
        style: {
          stroke: '#ff341b',
          fill: '#d7f1ff',
          text: 'test2',
          lineWidth:3
        },
      });
      editor.add(rect);
      editor.add(rect2);
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
    width: 100%;
    height: calc(100% - 50px);
    background-color: #ecefff;
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
