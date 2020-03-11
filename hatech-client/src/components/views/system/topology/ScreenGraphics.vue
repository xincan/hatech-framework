<template>
  <div class="myPage">
    <div id="canvasDiv" ref='canvasDiv' class="busCanvasDiv"></div>
  </div>
</template>

<script>
  import Gdraw from '../../../../assets/classLib/gdraw/Gdraw'
  import commonUtil from '../../../../assets/js/common'
  import Random from '../../../../assets/classLib/utilLib/Random'

  export default {
    data() {
      return {
        gd:null
      }
    },
    components: {},
    computed: {},
    methods: {

    },
    created() {
    },
    mounted() {

      let rows = [{
        label:"标题1",
        data:[{
          id:"0011",
          name:"name_0011"
        },{
          id:"0012",
          name:"name_0012"
        },{
          id:"0013",
          name:"name_0013"
        }]
      },{
        label:"标题2",
        data:[{
          id:"0021",
          name:"name_0021"
        },{
          id:"0022",
          name:"name_0022"
        },{
          id:"0023",
          name:"name_0023"
        },{
          id:"0024",
          name:"name_0024"
        }]
      },{
        label:"标题3",
        data:[{
          id:"0031",
          name:"name_0031"
        },{
          id:"0032",
          name:"name_0032"
        },{
          id:"0033",
          name:"name_0033"
        },{
          id:"0034",
          name:"name_0034"
        },{
          id:"0035",
          name:"name_0035"
        }]
      }];

      let linkList = [{
        id:"link_001",
        fromId:"0012",
        toId:"0022"
      },{
        id:"link_002",
        fromId:"0012",
        toId:"0023"
      },{
        id:"link_003",
        fromId:"0013",
        toId:"0021"
      },{
        id:"link_003",
        fromId:"0022",
        toId:"0031"
      },{
        id:"link_003",
        fromId:"0023",
        toId:"0031"
      },{
        id:"link_003",
        fromId:"0023",
        toId:"0035"
      },{
        id:"link_003",
        fromId:"0021",
        toId:"0033"
      }];

      let nodeList = [];



      console.log("数据：",rows);
      console.log("文字宽度：",Gdraw.util.getContext().measureText("大家好大家好大家好").width,Gdraw.util.getContext());

      var Vue=this;
      var gd = new Gdraw(this.$refs.canvasDiv);
      Vue.gd=gd;
      commonUtil.drawSizeCon([gd]);

      var page=gd.pageAdmin.open({
        dragPage:true,
        zoom:0.1,
        zoomType:'center'
      })

      var editor=new Gdraw.ShowEditor()
      Vue.editor=editor;
      page.add(editor);

      let currentX = 20;
      let currentY = 30;
      let upAreaId = "";  //上区域id
      let downAreaId = ""; //下区域id
      for (let row of rows) {
        // 添加标题
        this.editor.add(new Gdraw.Rect({
          draggable:false,
          shape: {
            x: currentX,
            y: currentY,
            width: row.label.length*30+20,
            height: 50,
          },
          style: {
            stroke: '#6d73ff',
            fill: '#989bff',
            text: row.label,
            textFill:"red",
            fontSize:30
          },
        }));
        currentY = currentY + 80;
        //获取获取下边距id
        downAreaId = Random.getUUID();
        for (let i = 0; i < row.data.length; i++) {
          if (i != 0) {
            currentX = currentX + Gdraw.util.getContext().measureText(row.data[i].name).width + 40;
          }
          if (currentX > 1200) {
            currentX = 20;
            currentY = currentY + 60;
          }

          let el = new Gdraw.Rect({
            id:row.data[i].id,
            draggable:true,
            isShowLinkElement:true, //是否是点击显示连接路径的元素
            isAreaElement:true, //是否是限制区域的元素
            areaIdList:[upAreaId,downAreaId], //限制区域的id
            shape: {
              x: currentX,
              y: currentY,
              width: Gdraw.util.getContext().measureText(row.data[i].name).width+20,
              height: 45,
            },
            style: {
              stroke: '#6d73ff',
              fill: '#989bff',
              text: row.data[i].name,
              textFill:"red",
            },
          })
          this.editor.add(el);
          nodeList.push(el);
        }

        this.editor.add(new Gdraw.Line({
          id:downAreaId,
          draggable:false,
          shape: {
            x1: 0,
            y1: currentY+80,
            x2: 1600,
            y2: currentY+80,
          }
        }))

        upAreaId = downAreaId; //交换位置
        currentX = 20;
        currentY = currentY+100
      }


      /*let nodeList=[],linkList=[];
      for(let v of data){
        let el=null;
        if(v.type=='image'){
          el = new Gdraw.Image({
            id:v.id,
            draggable:v.draggable,
            position:v.position,
            style:{
              x: v.style.x,
              y: v.style.y,
              width: v.style.width,
              height: v.style.height,
              image:v.style.image,
              text:v.style.text,
              textFill:'#ffffff'
            }
          })
          nodeList.push(el);
          this.editor.add(el);
        } else if (v.type=='link') {
          linkList.push(v);
        }
      }
*/
      //连线
      for(let v of linkList){
        for(let v1 of nodeList){
          for(let v2 of nodeList){
            if(v.fromId==v1.id&&v.toId==v2.id){
              let link= new Gdraw.Link({
                from:v1,
                to:v2,
                linkPointsType: ["intersect","intersect"],
                //shape: v.shape,
                //style: v.style,
                shape:{
                  arrowLength:0 //箭头长度
                },
              })
              this.editor.add(link);
              link.id=v.id;
            }
          }
        }
      }

      //获取页面元素用于后台保存
      console.log("-----页面元素-----",this.editor.getEditedElment())

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
  .busCanvasDiv {
    border-radius: 5px;
    width: 100%;
    height: 100%;
    background-color: #ecefff;
  }
</style>
