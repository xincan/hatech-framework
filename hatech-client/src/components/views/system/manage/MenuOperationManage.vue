
<template>

    <div class="hatech-panel">
      <div class="hatech-row">

        <div class="hatech-item hatech-cell-3" style="background-color: #f9f9f9">
          <div class="hatech-item-header">
            <div class="hatech-item-header-title">
              <span class="title-menu"><i class="hatech-icon hatech-yanzheng-1"></i>菜单信息</span>
            </div>

            <div class="hatech-item-header-option">
              <span><i class="el-icon-plus"></i></span>
              <span><i class="el-icon-edit"></i></span>
              <span><i class="el-icon-delete"></i></span>
            </div>
          </div>
          <div class="hatech-item-body" >
            <el-input placeholder="输入菜单名称" v-model="searchMenu" :style="{marginTop:'-1px'}"></el-input>
            <div :style="{height:'calc(100% - 40px)', overflow: 'auto', overflowX: 'hidden'}">
              <el-tree class="filter-tree"
                       :data="menu.data"
                       :props="defaultProps"
                       node-key="id"
                       :highlight-current="true"
                       default-expand-all
                       :filter-node-method="findNode"
                       ref="menuTree"
                       :style="{background:'#f9f9f9'}"
                       @node-click="getCheckedNode"
              ></el-tree>
            </div>
          </div>

        </div>

        <div class="hatech-item hatech-cell-6" style="background-color: #f9f9f9">

          <div class="hatech-item-header">
            <div class="hatech-item-header-title">
              <span class="title-menu"><i class="hatech-icon hatech-yanzheng-1"></i>操作信息</span>
            </div>

            <div class="hatech-item-header-option">
              <span><i class="el-icon-plus"></i></span>
              <span><i class="el-icon-edit"></i></span>
              <span><i class="el-icon-delete"></i></span>
            </div>
          </div>
          <div class="hatech-item-body" >
            <div :style="{height:'100%', overflow: 'auto', overflowX: 'hidden', textAlign: 'center'}">
              <p style="color: #000;font-weight: 600">页面操作按钮</p>
              <div class="pageOperation">
                <el-checkbox
                  border
                  :key="key"
                  :disabled="operation.disabled"
                  v-for="(operate, key) in operation.pageData"
                  :style="{margin: '10px'}"
                  v-model="operate.checked"
                  @change="changeOperation(operate)"
                >{{operate.operationName}}</el-checkbox>
              </div>
              <div class="tableOperation">
                <p style="color: #000;font-weight: 600">表格操作按钮</p>
                <el-checkbox
                  border
                  :key="key"
                  :disabled="operation.disabled"
                  v-for="(operate, key) in operation.tableData"
                  :style="{margin: '10px'}"
                  v-model="operate.checked"
                  :checked="operate.checked"
                  @change="changeOperation(operate)"
                >{{operate.operationName}}</el-checkbox>
              </div>
              <div class="allOperation" style="margin-top: 50px">
                <el-button  :disabled="operation.disabled" type="primary" @click="saveOperation">确定</el-button>
                <el-button  :disabled="operation.disabled">重置</el-button>
              </div>
            </div>
          </div>

        </div>

        <div class="hatech-item hatech-cell-3" style="background-color: #f9f9f9">

          <div class="hatech-item-header">
            <div class="hatech-item-header-title">
              <span class="title-menu"><i class="hatech-icon hatech-yanzheng-1"></i>菜单操作信息</span>
            </div>

            <div class="hatech-item-header-option">
              <span><i class="el-icon-plus"></i></span>
              <span><i class="el-icon-edit"></i></span>
              <span><i class="el-icon-delete"></i></span>
            </div>
          </div>
          <div class="hatech-item-body">
            <div :style="{height:'100%', overflow: 'auto', overflowX: 'hidden'}">
              <el-tree class="filter-tree"
                       :data="menuOperation.data"
                       :props="defaultProps"
                       node-key="id"
                       :highlight-current="true"
                       default-expand-all
                       :filter-node-method="findNode"
                       ref="menuOperationTree"
                       :style="{background:'#f9f9f9'}"
              ></el-tree>
            </div>
          </div>

        </div>

      </div>
    </div>

</template>

<script>

  import * as TreeUtil from '../../../../utils/TreeUtil.js';

    export default {
      name: "MenuOperationManage",
      components: {},
      data() {
          return {
            searchMenu: '', // 左侧下拉树检索文字

            defaultProps: { // 树的字段映射
              children: 'children',
              label: 'label'
            },

            menu: {         // 菜单数据处理
              data: [],
              selectMenu: null
            },

            operation: {    // 操作数据处理
              disabled: true,
              data: null,
              pageData:[],   //页面操作按钮
              tableData:[]   //表格操作按钮
            },

            menuOperation: {  // 菜单操作数据处理
              dataTemp: null, // 临时数据对象（包括菜单和按钮，并简历菜单按钮关联关系）
              data: null      // 菜单操作数据对象，用于右侧数据展示
            }
          }
      },
      mounted() {

        // 加载菜单信息
        this.initMenuInfo();

        // 加载操作信息
        this.initOperationInfo();

      },
      methods: {

        /**
         * 初始化操作信息
         * @Method add
         */
        initMenuInfo(){
          this.operation.pageData=[];
          this.operation.tableData=[];
          this.$get("/api/operation/all", {}).then(response => {
            for(let data of response.data) {
              data.checked = false;
            }
            //this.operation.data = response.data;
            for(let v of response.data) {
                if(v.type==='view') {
                  this.operation.pageData.push(v)
                } else if(v.type=='table') {
                  this.operation.tableData.push(v)
                }
            }
          }).catch(function (error) {
          });
        },

        /**
         * 初始化菜单信息
         * @Method add
         */
        initOperationInfo(){
          this.$get("/api/menu/tree", {}).then(response => {
            // 设置菜单数据
            this.menu.data = response.data;
            // 设置右侧菜单操作中的菜单数据
            this.menuOperation.data = response.data ;

            //将菜单信息也作为一个操作项，组装成一级对象
            let data = [];
            for(let mo of this.menuOperation.data) {
              data.push({ id: mo.id, label: mo.label, parentId: mo.parentId, checked: mo.checked });
              if(mo.children && mo.children.length > 0) {
                for(let moc of mo.children) {
                  data.push({ id: moc.id, label: moc.label, parentId: moc.parentId, checked: moc.checked });
                }
              }
            }
            this.menuOperation.dataTemp = data;
          }).catch(function (error) {
          });
        },

        /**
         * 模糊搜索节点树数据
         * @Method onTableSearch
         */
        findNode(value, data) {
          if (!value) return true;
          return data.label.indexOf(value) !== -1;
        },
        /**
         *根据指定菜单id查询操作
         *
         **/
        findOperationById(data,id){
          for(let v of data) {
            if(v.id===id) {
              if(v.children) {
                for(let a of v.children) {
                  if(a.id.indexOf('button')===-1) break;
                  if(a.type==='view') {
                    for(let m of this.operation.pageData) {
                      if(m.id===a.buttonId) {
                        m.checked=true;
                      }
                    }
                  }
                  else if(a.type==='table') {
                    for(let m of this.operation.tableData) {
                      if(m.id===a.buttonId) {
                        m.checked=true;
                      }
                    }
                  }

                }
              }
            } else {
              if(v.children&&v.children.length>0) {
                this.findOperationById(v.children,id)  //递归匹配对应的id
              }
            }
          }
        },

        /**
         * 菜单树操作
         * 点击节点，获取当前选中节点
         * @param node      传递给 data 属性的数组中该节点所对应的对象
         * @param checked   节点对应的 Node
         * @param current   节点组件本身
         */
        getCheckedNode(node,children, current) {
          if(node.children && node.children.length > 0){
            this.operation.disabled = true;
          }else {
            this.operation.disabled = false;
          }
          this.menu.selectMenu = node;
          for(let v of this.operation.pageData) {
            v.checked=false;
          }
          for(let v of this.operation.tableData) {
            v.checked=false;
          }
          this.findOperationById(this.menuOperation.data,this.menu.selectMenu.id)
        },

        changeOperation(checked) {
          // 判断是否有选中菜单
          if(this.menu.selectMenu === null){
            this.$message({message: '请选中菜单在进行配置操作' ,center: true ,type: 'info'});
            return false;
          }
          // 获取选中菜单信息
          let checkMenuId = this.menu.selectMenu.id;
          // 如果没有选中操作按钮，则进行增加，反之删除
          if(checked.checked){
            // 建立菜单与操作之间的父子关系
            this.menuOperation.dataTemp.push({
              id: 'button-' + checkMenuId + '-' + checked.id,
              label: checked.operationName,
              parentId: checkMenuId,
              checked: true,
              type:checked.type,
              buttonId:checked.id
            });
          }else {
            for(let i = 0; i<this.menuOperation.dataTemp.length; i++){
              if(this.menuOperation.dataTemp[i].id === 'button-' + checkMenuId + '-' + checked.id){
                this.menuOperation.dataTemp.splice(i, 1);
              }
            }
          }

          // 将数据转化成树状结构(数据深拷贝)
          let tree = TreeUtil.getTree(-1, JSON.parse(JSON.stringify(this.menuOperation.dataTemp)));
          // 更新菜单操作数据
          this.menuOperation.data = tree;

          // 更改选中操作的是否选中状态
         /* for(let ch of this.operation.pageData) {
            if(ch.id === checked.id){
              ch.checked = !ch.checked;
            }
          }
          for(let ch of this.operation.tableData) {
            if(ch.id === checked.id){
              ch.checked = !ch.checked;
            }
          }*/
        },

        /**
        * 保存对应菜单的操作
         * @param treeData   右侧树形结构
        * */
        saveOperation(){
          this.$post('/api/operation/save',{operation:this.menuOperation.data})
            .then(response=>{
              if(response.code===200) {
                this.$message.success('保存成功');
              } else {
                this.$message.error('保存失败');
              }
            })
        }

      },
      watch: {
        searchMenu(val) {
          this.$refs.menuTree.filter(val);
        }
      }
    }
</script>

<style scoped lang="scss">

</style>
