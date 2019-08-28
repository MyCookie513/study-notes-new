<template>
  <div>
    <v-layout class="pa-2">
      <!-- flex： 收缩   可以控制内部组件的宽度-->
      <v-flex xs2>
        <v-btn small color="info">新增品牌</v-btn>
      </v-flex >
      <!--spacer 具有撑开的功能-->
      <v-spacer/>
      <v-flex xs4>
        <!--搜索框 v-model 关联一个数据-->
        <v-text-field label="搜索" hide-details append-icon="search" v-model="key"></v-text-field>
      </v-flex>
    </v-layout>
    <!--
    header： 定义表头
    items： 表内显示的数据
    pagination:
            page: 当前的页数
            rowsPerPage: 每页的条数
            sortBy： 排序的字段
            descending： 是否倒序
    -->
    <v-data-table
      :headers="headers"
      :items="brands"
      :pagination.sync="pagination"
      :total-items="totalBrands"
      :loading="loading"
      class="elevation-1"
    >
      <template slot="items" slot-scope="props">
      <td class="text-xs-center">{{ props.item.id }}</td>
      <td class="text-xs-center">{{ props.item.name }}</td>
      <td class="text-xs-center"><img v-if="props.item.image" :src="props.item.image" width="130" height="40"/></td>
      <td class="text-xs-center">{{ props.item.letter }}</td>
        <td class="text-xs-center">
          <!--内部使用了比较漂亮的btn-->
          <v-btn text icon color="info" small="6">
            <v-icon>edit</v-icon>
          </v-btn>
          <v-btn text icon color="error" small="6">
            <v-icon>delete</v-icon>
          </v-btn>
        </td>

      </template>
    </v-data-table>
  </div>
</template>

<script>
  export default {
    name: "myBrand",
    data () {
      return {
        totalBrands: 0, // 总条数
        brands: [], // 当前页品牌数据
        loading: true, // 是否在加载中
        pagination: {}, // 分页信息
        key:'',//搜索的内容
        headers: [ // 头信息
          {text: 'id', align: 'center', value: 'id'},
          {text: '名称', align: 'center', value: 'name', sortable: false},
          {text: 'LOGO', align: 'center', value: 'image', sortable: false},
          {text: '首字母', align: 'center', value: 'letter'},
          {text: '操作', align: 'center'},
        ],
        show: false,// 控制对话框的显示
        oldBrand: {}, // 即将被编辑的品牌数据
        isEdit: false, // 是否是编辑
      }
    },
    /*watch  data体中的那个数据看是否发生了变化 相当于一个触发器*/
    watch:{
      key(){
        this.loading=true;
        this.getDataFromServer() ;// 调用数据初始化函数
        this.loading=false;
      },
      pagination:{/* table信息的变化 触发的事件*/
        deep: true,
          handler(){
          this.getDataFromServer();
        },
      }
    },
    methods: {
      getDataFromServer(){ // 从服务端加载数据的函数

        const brands = this.$http.get("/item/brand/page",{
          params:{
            page:this.pagination.page,
            rows:this.pagination.rowsPerPage,
            sortBy:this.pagination.sortBy,
            desc:this.pagination.descending,
            key: this.key,
          }
        }).then(resp=>{
          /*返回来的数据返回到Items 和 total 总条数*/
          this.brands=resp.data.items;
          this.totalBrands=resp.data.total;
        });

      },
    addBrand() {
      // 修改标记
      this.isEdit = false;
      // 控制弹窗可见：
      this.show = true;
      // 把oldBrand变为null
      this.oldBrand = null;
    },
    editBrand(oldBrand){
      // 根据品牌信息查询商品分类
      this.$http.get("/item/category/bid/" + oldBrand.id)
        .then(({data}) => {
          // 修改标记
          this.isEdit = true;
          // 控制弹窗可见：
          this.show = true;
          // 获取要编辑的brand
          this.oldBrand = oldBrand
          // 回显商品分类
          this.oldBrand.categories = data;
        })
    },
    closeWindow(){
      // 重新加载数据
      this.getDataFromServer();
      // 关闭窗口
      this.show = false;
    }
    },
    // 渲染后执行从其他服务调用工具  vue生命周期的一个阶段
    mounted(){
      this.loading=true;
      this.getDataFromServer() ;// 调用数据初始化函数
      this.loading=false;
    }
  }
</script>

<style scoped>

</style>
