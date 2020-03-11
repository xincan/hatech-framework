<template>
  <div class="myPage">
    <div id="canvasDiv" ref='canvasDiv' class="busCanvasDiv"></div>
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


      let data = [{"id":"6e3656e9-a0c6-4322-85d2-ade1e661adbe","type":"image","draggable":true,"position":[211,-58],"style":{"x":10,"y":100,"width":70,"height":70,"image":"/static/resources/type_4.jpg","text":"041","font":null,"textAlign":null},"zlevel":0},{"id":"d409c2ae-f162-4926-81ad-545d818ca1ce","type":"image","draggable":true,"position":[269,-60],"style":{"x":100,"y":100,"width":70,"height":70,"image":"/static/resources/type_4.jpg","text":"042","font":null,"textAlign":null},"zlevel":0},{"id":"34565e79-7acc-401e-9618-072202dffafe","type":"image","draggable":true,"position":[326,-65],"style":{"x":190,"y":100,"width":70,"height":70,"image":"/static/resources/type_4.jpg","text":"043","font":null,"textAlign":null},"zlevel":0},{"id":"bfb3d0ad-92e5-4daf-8137-460a57371b9c","type":"image","draggable":true,"position":[96,278],"style":{"x":280,"y":100,"width":70,"height":70,"image":"/static/resources/type_3.jpg","text":"031","font":null,"textAlign":null},"zlevel":0},{"id":"3059c71d-e65f-4a76-8c35-2d2f7d7c3530","type":"image","draggable":true,"position":[-1,91],"style":{"x":370,"y":100,"width":70,"height":70,"image":"/static/resources/type_3.jpg","text":"032","font":null,"textAlign":null},"zlevel":0},{"id":"16619e45-e06c-443b-8e0e-ac67978effc3","type":"image","draggable":true,"position":[-238,190],"style":{"x":460,"y":100,"width":70,"height":70,"image":"/static/resources/type_1.jpg","text":"011","font":null,"textAlign":null},"zlevel":0},{"id":"578e7e0a-3f78-4cb8-9dcd-b4f8fc16d058","type":"image","draggable":true,"position":[-18,173],"style":{"x":550,"y":100,"width":70,"height":70,"image":"/static/resources/type_1.jpg","text":"011","font":null,"textAlign":null},"zlevel":0},{"id":"c2e4e02c-ee37-4883-8db5-ef9d41090536","type":"image","draggable":true,"position":[-413,379],"style":{"x":640,"y":100,"width":70,"height":70,"image":"/static/resources/type_2.jpg","text":"021","font":null,"textAlign":null},"zlevel":0},{"id":"c83241fe-4851-470a-8052-f1bc6f78f0cb","type":"image","draggable":true,"position":[-177.5260312927601,390.4732773007479],"style":{"x":730,"y":100,"width":70,"height":70,"image":"/static/resources/type_2.jpg","text":"021","font":null,"textAlign":null},"zlevel":0},{"id":"74ef263f-3c4f-4230-86f5-19a4c78d9591","type":"link","fromId":"34565e79-7acc-401e-9618-072202dffafe","toId":"3059c71d-e65f-4a76-8c35-2d2f7d7c3530","shape":{"x1":516.1346071010104,"y1":106.99999597355333,"x2":438.8653780382774,"y2":188.999994162576,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#000","fill":null,"lineWidth":"2"},"linkPointsType":["intersect","intersect"],"zlevel":1},{"id":"40440800-693e-4d60-82c5-0e8cc5c5b4a3","type":"link","fromId":"6e3656e9-a0c6-4322-85d2-ade1e661adbe","toId":"3059c71d-e65f-4a76-8c35-2d2f7d7c3530","shape":{"x1":292.75167450217606,"y1":113.9999958189577,"x2":367.2483171522131,"y2":188.999994162576,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#000","fill":null,"lineWidth":"2"},"linkPointsType":["intersect","intersect"],"zlevel":1},{"id":"4da035a7-2ee5-4935-a491-d9ad4dc358e3","type":"link","fromId":"d409c2ae-f162-4926-81ad-545d818ca1ce","toId":"3059c71d-e65f-4a76-8c35-2d2f7d7c3530","shape":{"x1":403.99999419289793,"y1":111.99999586312788,"x2":403.99999419289793,"y2":188.999994162576,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#000","fill":null,"lineWidth":"2"},"linkPointsType":["intersect","top"],"zlevel":1},{"id":"f0cc6c2c-b743-4442-8e1b-80876252c886","type":"link","fromId":"3059c71d-e65f-4a76-8c35-2d2f7d7c3530","toId":"16619e45-e06c-443b-8e0e-ac67978effc3","shape":{"x1":366.9999950100462,"y1":259.2999926099942,"x2":293.99999662225775,"y2":324.99999115900386,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#000","fill":null,"lineWidth":"2"},"linkPointsType":["intersect","right"],"zlevel":1},{"id":"c8d459ce-3943-488c-b699-a23f56977c3e","type":"link","fromId":"3059c71d-e65f-4a76-8c35-2d2f7d7c3530","toId":"578e7e0a-3f78-4cb8-9dcd-b4f8fc16d058","shape":{"x1":440.9999933757497,"y1":250.07935789299785,"x2":529.9999914101767,"y2":307.9999915344504,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#000","fill":null,"lineWidth":"2"},"linkPointsType":["intersect","left"],"zlevel":1},{"id":"d4ca98d8-b929-451d-b82b-064827ad51a4","type":"link","fromId":"16619e45-e06c-443b-8e0e-ac67978effc3","toId":"bfb3d0ad-92e5-4daf-8137-460a57371b9c","shape":{"x1":293.99999662225775,"y1":324.99999115900386,"x2":373.9999948554506,"y2":412.999989215516,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#000","fill":null,"lineWidth":"2"},"linkPointsType":["right","left"],"zlevel":1},{"id":"082206ff-d918-4585-b326-9b5132f3fc4e","type":"link","fromId":"578e7e0a-3f78-4cb8-9dcd-b4f8fc16d058","toId":"bfb3d0ad-92e5-4daf-8137-460a57371b9c","shape":{"x1":529.9999914101767,"y1":340.6470496369665,"x2":447.999993221154,"y2":412.999989215516,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#000","fill":null,"lineWidth":"2"},"linkPointsType":["intersect","right"],"zlevel":1},{"id":"71cbb7b3-689c-4739-88e9-8f964f811936","type":"link","fromId":"bfb3d0ad-92e5-4daf-8137-460a57371b9c","toId":"c2e4e02c-ee37-4883-8db5-ef9d41090536","shape":{"x1":373.9999948554506,"y1":446.36605990719477,"x2":298.9999965118323,"y2":513.999986984922,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#000","fill":null,"lineWidth":"2"},"linkPointsType":["intersect","right"],"zlevel":1},{"id":"8588342a-1b60-460e-8f93-81326b5f7146","type":"link","fromId":"bfb3d0ad-92e5-4daf-8137-460a57371b9c","toId":"c83241fe-4851-470a-8052-f1bc6f78f0cb","shape":{"x1":447.999993221154,"y1":436.5848237979393,"x2":550.4405826169123,"y2":501.8833213326275,"breakPoints":null,"arrowLength":15,"arrowAngle":20,"arrowType":"hollow"},"style":{"stroke":"#000","fill":null,"lineWidth":"2"},"linkPointsType":["intersect","intersect"],"zlevel":1}];

      console.log("数据：",data);
      var content = document.getElementById('canvasDiv');
      console.log(content.offsetWidth,"----offsetWidth");
      console.log(content.offsetHeight,"------offsetHeight");
      console.log("文字宽度：",Gdraw.util.getContext().measureText("大家好大家好大家好").width,Gdraw.util.getContext().canvas.height);

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

      let nodeList=[],linkList=[];
      for(let v of data){
        let el=null;
        if(v.type=='image'){
          el = new Gdraw.Image({
            id:v.id,
            draggable:v.draggable,
            isShowLinkElement:true, //是否是点击显示连接路径的元素
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
                shape:{
                  arrowLength:0 //箭头长度
                },
                zlevel:v.zlevel
              })
              this.editor.add(link);
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
  .busCanvasDiv {
    border-radius: 5px;
    width: 100%;
    height: 100%;
    background-color: #ecefff;
  }
</style>
