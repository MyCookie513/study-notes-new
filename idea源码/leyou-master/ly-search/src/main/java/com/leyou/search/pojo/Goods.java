package com.leyou.search.pojo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * 所有的查询字段有：
 * 　　　　　all： title  category： 类别名称    brand ： 品牌名称
 *          创建时间
 *          价格集合：
 *          skus： 所有子商品的   标题：title    价格     图片
 *          商品所有可搜索的规格参数
 *
 *
 *
 *
 *
 *
 *
 * @author bystander
 * @date 2018/9/22
 */
@Data
@Document(indexName = "goods", type = "docs", shards = 1, replicas = 1)
public class Goods {

        @Id
        private Long id;  //SpuId

        @Field(type = FieldType.Text, analyzer = "ik_max_word")
        private String all;  //所有需要被搜索的信息，包括品牌，分类，标题

        @Field(type = FieldType.Keyword, index = false)
        private String subtitle;  //父标题

        private Long brandId;
        private Long cid1;
        private Long cid2;
        private Long cid3;

        private Date createTime;
        private Set<Double> price;  //是所有sku的价格集合。方便根据价格进行筛选过滤

        @Field(type = FieldType.Keyword, index = false)
        private String skus;  //sku信息的json结构数据
        private Map<String, Object> specs;  //可搜索的规格参数，key是参数名，值是参数值




}
