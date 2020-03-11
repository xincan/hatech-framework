

<!--

  弹出层封装

-->

<template>

  <!-- 表格操作对应弹出层 -->
  <div class="hatech-dialog">
    <!--
        编辑用户信息
        公用一个弹出层时需要加上v-if判断使之重新渲染组件 避免重置按钮出现数据混乱现象

        custom-class="hatech-dialog"              自定义弹出层class名称
        v-if="form.dialogFormVisible"             判断弹出层是否显示、隐藏（重新加载渲染弹出层）
        :title="form.title"                       设置弹出层标题
        :visible.sync="form.dialogFormVisible"    判断弹出层是否显示、隐藏（不重新加载渲染弹出层）
        :width="form.formWidth"                   设置弹出层宽度
        :before-close="formClose"                 弹出层右上角关闭icon
    -->
    <el-dialog
      v-if="form.dialogFormVisible"
      :title="form.title"
      :visible.sync="form.dialogFormVisible"
      :width="form.formWidth"
      :before-close="_hatechDialogClose"
    >
      <div class="hatech-top-line"></div>     <!-- 弹出层划线，上 -->

      <!-- 弹出层form表单插槽定义 -->
      <slot name="hatech-dialog-from"></slot>

      <div class="hatech-bottom-line"></div>    <!-- 弹出层划线，上 -->
      <div slot="footer" class="dialog-footer">
        <el-button
          v-for="(option,key) in form.formOption"
          :key="key"
          v-if="option.isShow"
          :type="option.type"
          :size="option.size"
          @click="_hatechFormSubmit({key:key, fun:option.fun, option:option})"
        >{{option.name}}</el-button>
        <el-button size="mini" @click="_hatechDialogConsole">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "Hatech-Dialog"
    ,props:{
      hatechDialog:{type: Object}
      ,form: {type: Object}
    }
    ,data(){
      return {

      }
    }
    ,methods: {

      /**
       * 弹出层操作
       * 表单取消操作, 回归重置表单、列表数据然后关闭
       * @Method formSubmit
       */
      _hatechDialogClose(done){
        this.hatechDialog.$refs[this.form.name].resetFields();
        done();
      }

      /**
       * 弹出层操作
       * 表单取消操作，重置表单数据，关闭弹出层
       * @Method formSubmit
       */
      ,_hatechDialogConsole(){
        this.hatechDialog.$refs[this.form.name].resetFields();
        this.hatechDialog.form.dialogFormVisible = false;
      }

      /**
       * 弹出层操作
       * 提交弹出层中form表单数据信息
       * @Method formSubmit
       */
      ,_hatechFormSubmit(param){
        param.id=this.form.data.id;
        param.row= this.form.data;
        this.hatechDialog[param.fun] ? this.hatechDialog[param.fun].call(this, param) : '';
      }
    }
  }
</script>

<style scoped lang="scss">
  @import "../../assets/css/dialog";
</style>
