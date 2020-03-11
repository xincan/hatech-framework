<template>
  <div class="myPage">
    <div class="top">
      <div class='text'>审批流程图</div>
    </div>
    <div ref='canvasDiv' class="busCanvasDiv"></div>
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

    },
    created() {
    },
    mounted() {


      var data = [{"id":"f54908e6-d922-4516-8a6f-bd7452e6a9fd","type":"ellipse","myData":{"meaning":"0","approver":null,"subProcess":""},"position":[60,28],"shape":{"cx":150,"cy":331.8,"rx":50,"ry":25},"style":{"stroke":"#6d73ff","fill":"#ffe2ea","text":"开始","lineWidth":1,"font":null,"textAlign":null},"zlevel":-1},{"id":"f9d8df1d-1510-4007-b9a7-a47e94b6c97e","type":"ellipse","myData":{"meaning":"1","approver":null,"subProcess":""},"position":[-25,27],"shape":{"cx":1273,"cy":331.8,"rx":50,"ry":25},"style":{"stroke":"#6d73ff","fill":"#ffe2ea","text":"结束","lineWidth":1,"font":null,"textAlign":null},"zlevel":-1},{"id":"47131405-c62d-4272-8edf-eb7ff757df1f","type":"rect","myData":{"meaning":"2","approver":null,"subProcess":""},"position":[313,-165],"shape":{"r":5,"x":347,"y":319,"width":142,"height":48},"style":{"stroke":"#6d73ff","fill":"#d6f8ff","text":"经理A审批","lineWidth":1,"font":null,"textAlign":null},"zlevel":-1},{"id":"c8cdbe8f-39cc-47df-b7a6-b87ef533befe","type":"polygon","myData":{"meaning":"2","approver":null,"subProcess":""},"position":[-76,27],"shape":{"points":[[533,310],[608,335],[533,360],[458,335]],"smooth":false,"smoothConstraint":null},"style":{"stroke":"#6d73ff","fill":"#d6f8ff","text":"经理B审批","lineWidth":1,"font":null,"textAlign":null},"zlevel":-1},{"id":"65b74193-cdae-4ad5-8611-ba4f3201e9c7","type":"rect","myData":{"meaning":"2","approver":null,"subProcess":""},"position":[351,88],"shape":{"r":5,"x":309,"y":247,"width":150,"height":50},"style":{"stroke":"#6d73ff","fill":"#d6f8ff","text":"主管A审批","lineWidth":1,"font":null,"textAlign":null},"zlevel":-1},{"id":"8e01145d-4758-4afb-8da8-f6145e8c6349","type":"rect","myData":{"meaning":"2","approver":null,"subProcess":""},"position":[-20,9],"shape":{"r":5,"x":949,"y":325,"width":150,"height":50},"style":{"stroke":"#6d73ff","fill":"#d6f8ff","text":"总经理审核","lineWidth":1,"font":null,"textAlign":null},"zlevel":-1},{"id":"446e37ab-45db-44fc-b2e8-18d8b499243b","type":"link","fromId":"f54908e6-d922-4516-8a6f-bd7452e6a9fd","toId":"c8cdbe8f-39cc-47df-b7a6-b87ef533befe","shape":{"x1":262.5,"y1":359.8,"x2":379.5,"y2":361.1233933161954,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#7983ff","fill":null,"lineWidth":"2"},"linkPointsType":["right","intersect"],"zlevel":1},{"id":"9be0c988-79a9-47c4-8381-867cb00a4b20","type":"link","fromId":"c8cdbe8f-39cc-47df-b7a6-b87ef533befe","toId":"65b74193-cdae-4ad5-8611-ba4f3201e9c7","shape":{"x1":534.5,"y1":362,"x2":658,"y2":360,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#7983ff","fill":null,"lineWidth":"2"},"linkPointsType":["right","left"],"zlevel":1},{"id":"078ddbd5-a203-4a60-82af-32bcf911b31d","type":"link","fromId":"65b74193-cdae-4ad5-8611-ba4f3201e9c7","toId":"8e01145d-4758-4afb-8da8-f6145e8c6349","shape":{"x1":812,"y1":360,"x2":927,"y2":359.4010416666667,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#7983ff","fill":null,"lineWidth":"2"},"linkPointsType":["right","intersect"],"zlevel":1},{"id":"6862bc63-ad34-4e1e-937f-4e31537f3eff","type":"link","fromId":"c8cdbe8f-39cc-47df-b7a6-b87ef533befe","toId":"47131405-c62d-4272-8edf-eb7ff757df1f","shape":{"x1":457,"y1":334.5,"x2":658,"y2":177.46715328467153,"breakPoints":[[457,176]],"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#7983ff","fill":null,"lineWidth":"2"},"linkPointsType":["top","intersect"],"zlevel":1},{"id":"b082b782-3314-46a6-b50e-3c1ed6724333","type":"link","fromId":"47131405-c62d-4272-8edf-eb7ff757df1f","toId":"8e01145d-4758-4afb-8da8-f6145e8c6349","shape":{"x1":804,"y1":178,"x2":1003.4098360655738,"y2":332,"breakPoints":[[1000,176]],"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#7983ff","fill":null,"lineWidth":"2"},"linkPointsType":["right","intersect"],"zlevel":1},{"id":"4f384e05-8ddb-4c9c-848f-50afca35cda5","type":"link","fromId":"8e01145d-4758-4afb-8da8-f6145e8c6349","toId":"f9d8df1d-1510-4007-b9a7-a47e94b6c97e","shape":{"x1":1081,"y1":359,"x2":1195.5,"y2":358.86287425149703,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#7983ff","fill":null,"lineWidth":"2"},"linkPointsType":["right","intersect"],"zlevel":1}]

      console.log("数据：",data);

      var gd = new Gdraw(this.$refs.canvasDiv);
      commonUtil.drawSizeCon([gd]);
      var page1=gd.pageAdmin.open({
        dragPage:true,
        zoom:0.1,
        zoomType:'center'
      });

      let nodeList=[],linkList=[];
      for(let v of data){
        let el=null;
        if(v.type=='rect'){
          el=new Gdraw.Rect({
            id:v.id,
            position:v.position,
            shape: v.shape,
            style: v.style,
            zlevel:v.zlevel
          })
        }else if(v.type=='ellipse'){
          el=new Gdraw.Ellipse({
            id:v.id,
            position:v.position,
            shape: v.shape,
            style: v.style,
            zlevel:v.zlevel
          })
        }else if(v.type=='polygon'){
          el=new Gdraw.Polygon({
            id:v.id,
            position:v.position,
            shape: v.shape,
            style: v.style,
            zlevel:v.zlevel
          })
        }else if(v.type=='circle'){
          el=new Gdraw.Circle({
            id:v.id,
            position:v.position,
            shape: v.shape,
            style: v.style,
            zlevel:v.zlevel
          })
        }
        if(v.type=='link'){
          linkList.push(v);
        }else{
          page1.add(el);
          nodeList.push(el);
        }
      }
      //连线
      for(let v of linkList){
        for(let v1 of nodeList){
          for(let v2 of nodeList){
            if(v.fromId==v1.id&&v.toId==v2.id){
              let link= new Gdraw.Link({
                from:v1,
                to:v2,
                linkPointsType: v.linkPointsType,
                shape: v.shape,
                style: v.style,
                zlevel:v.zlevel
              })
              page1.add(link);
              link.id=v.id;
            }
          }
        }
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
