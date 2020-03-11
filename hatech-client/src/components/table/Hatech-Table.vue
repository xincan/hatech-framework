
<!--
    Table表格插件封装
-->

<template>

  <div class="hatech-plugin-table">

    <!-- 按条件查询模块 -->
    <slot name="hatech-search"></slot>

    <div class="hatech-table">
      <!-- 表格头部布局 -->
      <div class="hatech-table-header">
        <div class="hatech-table-header-left"><ul><li>{{table.title}}</li></ul></div>
        <div class="hatech-table-header-right" v-if="table.showHeaderOption">
          <!--表格头部操作项-->
          <!-- 表格头部操作按钮集合 -->
          <ul>
            <li
              v-for="(option, key) in table.headerOption"
              v-if="option.isShow"
              :key="key"
              :title="option.name"
              @click="_hatechTableOptionBtn({key:key, fun:option.fun, option: option})"
            >
              <i :class="option.icon"></i>
            </li>
            <li title="显隐列">
              <el-popover placement="bottom" width="200" trigger="click">
                <el-checkbox v-for="(column,key) in table.column" :key="key" :checked="column.isHide" :name="column.prop" @change="_onIsCellHide(column)">{{column.label}}</el-checkbox>
                <i class="el-icon-menu" slot="reference"></i>
              </el-popover>
            </li>
          </ul>
        </div>
      </div>
      <!-- 表格主体布局 -->
      <div class="hatech-table-body">
        <el-table
          stripe
          border
          resizable
          size="small"
          :data="table.data"
          :ref="table.id"
          :style="'width: ' + table.tableWidth"
          @sort-change="_sortChange"
          @row-click="_rowClick"
          @selection-change="_tableChangeRows"
          @header-dragend="_tableCellDragend"
        >
          <!-- 表格多选设置 -->
          <el-table-column type="selection" align="center" width="40" fixed="left"></el-table-column>
          <!-- 表格编号设置 -->
          <el-table-column label="编号" v-if="table.isIndexShow" type="index"  align="center" width="70" fixed="left" :index="_tableIndex"></el-table-column>

          <!-- 表格列循环设置 -->
          <el-table-column
            header-align = "center"
            align = "left"
            sortable='custom'
            show-overflow-tooltip
            v-if="column.isHide"
            v-for = "(column, key) in table.column"
            :key="key"
            :prop = "column.prop"
            :label = "column.label"
            :width = "column.width"
          >

            <template slot-scope="scope" >
              <!--如果当前列存在格式化、点击参数则走第一个div-->
              <div
                v-if="column.formatter && column.click"
                @click.stop="_onTableFmtClick({event:column.click,row: scope.row})"
                v-html="column.formatter[scope.row[column.prop]] ? column.formatter[scope.row[column.prop]].replace('${value}', scope.row[column.prop]) : scope.row[column.prop]"
              ></div>
              <!--如果当前列存在格式化则走第二个div-->
              <div
                v-else-if="column.formatter"
                v-html="column.formatter[scope.row[column.prop]] ? column.formatter[scope.row[column.prop]].replace('${value}', scope.row[column.prop]) : scope.row[column.prop]"
              ></div>
              <!--否则则走第三个div-->
              <div v-else >{{ scope.row[column.prop] }}</div>
            </template>

          </el-table-column>
          <!-- 表格操作列设置 -->
          <el-table-column prop="option" v-if="table.showTableOption" :width="table.cellOptionWidth" header-align="center" align="center" label="操作" fixed="right">
            <template slot-scope="scope">
              <i
                v-for="(option,key) in table.cellOption"
                v-if="option.isShow && scope.row[option.prop] == option.value"
                :key="key"
                :title="option.name"
                :class="option.icon"
                @click.stop="_hatechTableOptionBtn({key: key, fun: option.fun, index: scope.$index, row: scope.row, option: option})"
              >
              </i>
            </template>
          </el-table-column>
        </el-table>
      </div>

      <!--表格底部布局，表格分页设置-->
      <div class="hatech-table-footer">
        <el-pagination
          background
          layout="total, sizes, prev, pager, next, jumper"
          :current-page="table.page" :page-sizes="table.pageSize" :page-size="table.size" :total="table.count"
          @size-change="_tableSizeChange"
          @current-change="_tableCurrentChange"
        ></el-pagination>
      </div>

    </div>

  </div>
</template>

<script>

  export default {
    components: { }
    ,props: {
      hatechTable:{type: Object}
      ,table: { type: Object}
    }
    ,data() {
        return {

        }
    }
    ,mounted() {

      // 通过数据库查询用户保存的表格显隐列显示方式
      this._initCellIsHide();
      // 初始化加载后台表格数据, 判断是否手动加载还是自动加载,如果参数不存在则走自动加载
      if(this.table.autoInit || this.table.autoInit === undefined){
        this._initTable();
      }else{
        // 初始化查询参数
        this._search();
        this.$emit("init-table", this.table.search);
      }

    }

    ,methods: {

      /**
       * 初始化表格查询参数
       * @Method initCellIsHide
       */
      _search(){
        this.table.search.page = this.table.page;
        this.table.search.size = this.table.size;
        this.table.search.sortName = this.table.sort.sortName;
        this.table.search.sortType = this.table.sort.sortType;
      }

      /**
       * 初始化数据
       * 初始化读取数据库隐藏列,每列的宽度
       * @Method initCellIsHide
       */
      ,_initCellIsHide(){
        let that = this;
        this.$get(this.table.showCellUrl, { name: this.table.id }).then( response => {
          if(response.data !== undefined && response.data !== null){
            // 将后台读取字符串JSON数据，转换成JSON数据
            let cell = JSON.parse(response.data.content);
            if(cell.length > 0){
              let newColumn = [];
              // 比对两个集合修改列显示状态
              that.table.column.forEach(clm => {
                cell.forEach(cel => {
                  if(clm.prop === cel.prop){
                    clm.isHide = cel.isHide;
                    clm.width = cel.width;
                    newColumn.push(clm);
                  }
                });
              });
              that.table.column=[];   // 清空列显示数据，后续紧跟着渲染使之vue执行树双向绑定
              that.$nextTick(()=>{    // 数据DOM元素重新渲染之前，加载数据
                that.table.column = newColumn;
              });
            }
          }
        }).catch( error => {console.log(error);});
      }

      /**
       * 表格数据格式化点击操作
       * 格式化点击事件
       * @Method onTableFmtClick
       */
      ,_onTableFmtClick(param){
        this.hatechTable[param.event] ? this.hatechTable[param.event].call(this, param) : '';
      }

      /**
       * 自定义表格按钮统一操作
       *  判断父组件函数是否存在，如果存在则执行，否则不执行
       * @Method formSubmit
       */
      ,_hatechTableOptionBtn(param){
        // 判断如果param.row有数据说明是点击列表右侧按钮，否则是列表头部右侧按钮
        if(param.row !== undefined){
          this.table.select.push(param.row);
        }
        param.select = this.table.select;
        this.hatechTable[param.fun] ? this.hatechTable[param.fun].call(this, param) : '';
      }

      /**
       * 表格头部排序操作
       * @Method _sortChange
       */
      ,_sortChange(column){
        if(column !== null && this.table.sort.custom){
          // column.order == ascending 表示升序，descending 表示降序，否则为空
          this.table.sort.sortName = column.prop;
          this.table.sort.sortType = "descending" === column.order ? "DESC":"ASC";
          this._initTable();
        }
      }

      /**
       * 表格操作
       * 表格行选中操作
       * @Method _rowClick
       */
      ,_rowClick(row){
        this.$emit("row-click",row);
      }

      /**
       * 表格处理操作
       * 勾选表格列数据显示隐藏
       * type说明：
       * 【1: table列的显示隐藏，2：table列的拖拽】
       * @Method excuteTable
       */
      ,_excuteTable(column, type){
        let cellString = [];
        // 遍历表头，更改表头数据模型，并拼接表头数据
        this.table.column.forEach( cell => {
          if( cell.prop === column.prop){
            if(type === 1){ // 隐藏处理
              cell.isHide = !column.isHide;
            }else{          // 拖拽宽度处理
              cell.width = column.width;
            }
          }
          cellString.push({'prop': cell.prop, 'width': cell.width , 'isHide': cell.isHide});
        });
        console.log(this.table.dropCellUrl);
        // 将操作列数据保存到后台
        this.$put(this.table.dropCellUrl, {
            name:this.table.id, content: cellString
          }).then( response => {
        }).catch( error => {console.log(error);});
      }

      /**
       * 表格头部按钮操作
       * 勾选表格列数据显示隐藏
       * @Method onIsCellHide
       */
      ,_onIsCellHide(column) {
        this._excuteTable(column,1);
      }

      /**
       * 表格头部列拖拽操作
       * 选中列边框进行左右拖拽，改变列的宽度，并更改模型数据，将其保存到数据库中
       * @Method tableCellDragend
       */
      ,_tableCellDragend(newWidth, oldWidth, column, event){
        this._excuteTable({prop: column.property, width: column.width}, 2);
      }

      /**
       * 表格列序号计算
       * 重新计算数据下标
       * @Method tableIndex
       */
      ,_tableIndex(index){
        return ((this.table.page - 1) * this.table.size) + index + 1;
      }
      /**
       * 初始化数据
       * 初始化加载列表数据
       * @Method _initTable
       */
      ,_initTable(){
        // 表格查询封装
        this._search();
        let that = this;
        this.$get(this.table.url, this.table.search).then( response => {
          that.table.count = response.count;
          that.table.data = response.data;
        }).catch( error => {console.log(error);});
      }

      /**
       * 表格分页
       * 点击每页条数下拉列表进行选择数据进行查询
       * @Method tableSizeChange
       */
      ,_tableSizeChange(size) {
        this.table.size = size;
        this._initTable();
      }

      /**
       * 表格分页
       * 首先数据选择渲染this.table.page数据
       * 其次调用初始化table数据
       * @Method tableCurrentChange
       */
      ,_tableCurrentChange(page) {
        this.table.page = page;
        this._initTable();
      }

      /**
       * 表格操作
       * 表格数据多选操作
       * @Method tableChangeRows
       */
      ,_tableChangeRows(row){
        this.table.select = row;
      }

    }
  }
</script>


<style scoped lang="scss">
  @import "../../assets/css/table";
</style>
