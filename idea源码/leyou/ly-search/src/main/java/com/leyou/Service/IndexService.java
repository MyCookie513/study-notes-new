
package com.leyou.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jason.Utills.JsonUtils;
import com.jason.pojo.Sku;
import com.jason.pojo.SpuBo;
import com.jason.pojo.SpuDetail;
import com.leyou.common.utils.JsonUtils;
import com.leyou.feignClient.GoodsClient;
import com.leyou.item.bo.SpuBO;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.pojo.SpuDetail;
import com.leyou.pojo.Goods;
import com.leyou.pojo.Params;
import com.leyou.search.client.CategoryClient;
import com.leyou.search.client.GoodsClient;
import com.leyou.search.client.SpecificationClient;
import com.leyou.search.pojo.Goods;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jason.Utills.JsonUtils;
import com.leyou.pojo.Spu_specifications;

import java.util.*;

*/
/**
 * @Author: taft
 * @Date: 2018-8-29 16:56
 *//*

@Service
public class IndexService {

    public static void main(String[] args) {

        String jason="[{\"group\":\"主芯片\",\n" +
                "    \"params\":\n" +
                "       [\n" +
                "         {\"k\":\"CPU品牌\",\"searchable\":true,\"global\":true,\"v\":\"骁龙（Snapdragon)\"},\n" +
                "         {\"k\":\"CPU型号\",\"searchable\":false,\"global\":true,\"v\":\"骁龙617（msm8952）\"},\n" +
                "         {\"k\":\"CPU核数\",\"searchable\":true,\"global\":true,\"v\":\"八核\"},\n" +
                "         {\"k\":\"CPU频率\",\"searchable\":true,\"global\":true,\"numerical\":true,\"unit\":\"GHz\",\"v\":1.5}\n" +
                "       ]\n" +
                "   }]";
        List<Spu_specifications> spu_specifications= JsonUtils.nativeRead(jason, new TypeReference< List<Spu_specifications>>() {
        });

        System.out.println(JsonUtils.serialize(spu_specifications));
    }
    @Autowired
    private CategoryClient categoryClient;

    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private SpecificationClient specificationClient;

    public Goods buildGoods(SpuBo spu){
        Long id = spu.getId();
        //准备数据

        */
/**
         * 获取商品分类的名称  categoryName ， spu title*//*


        List<String> names = this.goodsClient.queryNameByIds(Arrays.asList(spu.getCid1(),spu.getCid2(),spu.getCid3())).getBody();
        //all字段里面有spu的title和分类字段
        String all = spu.getTitle()+" "+ StringUtils.join(names," ");

         */
/**
         * sku ：            id,title,image,price
         * spu : all sku prices
         *//*

        List<Sku> skus = this.goodsClient.querySkuBySpuId(id).getBody();
        //处理sku
        //把商品价格取出单独存放，便于展示
        List<Long> prices = new ArrayList<>();
        List<Map<String,Object>> skuList = new ArrayList<>();
        for (Sku sku : skus) {
            prices.add(sku.getPrice());
            Map<String,Object> skuMap = new HashMap<>();
            skuMap.put("id",sku.getId());
            skuMap.put("title",sku.getTitle());
            skuMap.put("image", StringUtils.isBlank(sku.getImages()) ? "":sku.getImages().split(",")[0]);
            skuMap.put("price",sku.getPrice());
            skuList.add(skuMap);
        }

        */
/**
         * spuDetail : spuDetail all search 字段---》  specs.put(name,value);
         * *//*


        SpuDetail spuDetail = this.goodsClient.querySpuDetailById(id).getBody();
        String json=spuDetail.getSpecifications();
        List<Spu_specifications> spu_specifications= JsonUtils.nativeRead(json, new TypeReference< List<Spu_specifications>>() {
        });
        */
/**
         * 存储所有的可搜索字段
         *//*

        Map<String, Object> specs = new HashMap<>();

        for (int i=0;i<spu_specifications.size();i++){
            List<Params> Lparams=spu_specifications.get(i).getParams();
            for (Params p:Lparams){
                if (p.isSearchable()){
                    */
/**
                     * 是否是特有属性
                     *//*

                    if (p.isGlobal()){
                        specs.put(p.getK(),p.getV());
                    }else{
                        //是特有属性时的情况


                    }
                }
            }
        }



        //查询分类对应的规格参数---》查询搜索字段参数
        List<SpecParam> params = this.specificationClient.querySpecParam(null, spu.getCid3(), true, null);

        //通用规格参数值
        Map<Long, String> genericMap =
                    JsonUtils.parseMap(spuDetail.getGenericSpec(), Long.class, String.class);

        //特有规格参数的值
        Map<Long,List<String>> specialMap = JsonUtils.nativeRead(spuDetail.getSpecialSpec(), new TypeReference<Map<Long, List<String>>>() {
        });

        //处理规格参数显示问题，默认显示id+值，处理后显示id对应的名称+值
       // Map<String, Object> specs = new HashMap<>();

        for (SpecParam param : params) {
            //规格参数的编号id id：1 表示的是品牌，4颜色
            Long paramId = param.getId();

            //今后显示的名称
            String name = param.getName();//品牌，机身颜色
            //通用参数
            Object value = null;
            if (param.getGeneric()){
                //通用参数
                value = genericMap.get(paramId);

                if (param.getNumeric()){
                    //数值类型需要加分段
                    value = this.chooseSegment(value.toString(),param);
                }
            }
            else {//特有参数
                value = specialMap.get(paramId);

            }
            if (null==value){
                value="其他";
            }
            specs.put(name,value);
        }

        Goods goods = new Goods();
        goods.setId(spu.getId());
        //这里如果要加品牌，可以再写个BrandClient，根据id查品牌
        goods.setAll(all);
        goods.setSubTitle(spu.getSubTitle());
        goods.setBrandId(spu.getBrandId());
        goods.setCid1(spu.getCid1());
        goods.setCid2(spu.getCid2());
        goods.setCid3(spu.getCid3());
        goods.setCreateTime(spu.getCreateTime());
        goods.setPrice(prices);
        goods.setSkus(JsonUtils.serialize(skuList));
        goods.setSpecs(specs);

        return goods;
    }

    private String chooseSegment(String value, SpecParam p) {
        double val = NumberUtils.toDouble(value);
        String result = "其它";
        // 保存数值段
        for (String segment : p.getSegments().split(",")) {
            String[] segs = segment.split("-");
            // 获取数值范围
            double begin = NumberUtils.toDouble(segs[0]);
            double end = Double.MAX_VALUE;
            if(segs.length == 2){
                end = NumberUtils.toDouble(segs[1]);
            }
            // 判断是否在范围内
            if(val >= begin && val < end){
                if(segs.length == 1){
                    result = segs[0] + p.getUnit() + "以上";
                }else if(begin == 0){
                    result = segs[1] + p.getUnit() + "以下";
                }else{
                    result = segment + p.getUnit();//4.5  4-5英寸
                }
                break;
            }
        }
        return result;
    }
}


*/
/***

 [
   { "group":"主体",
     "params":
       [
        {"k":"品牌","searchable":false,"global":true,"v":null},
        {"k":"型号","searchable":false,"global":true,"v":"G9青春版（全网通版）"},
        {"k":"上市年份","searchable":false,"global":true,"numerical":true,"unit":"年","v":2016.0}
       ]
   },
   { "group":"基本信息",
     "params":
        [
         {"k":"机身颜色","searchable":false,"global":false,"options":["白色","金色","玫瑰 金"]},
         {"k":"机身重量（g）","searchable":false,"global":true,"numerical":true,"unit":"g","v":143},
         {"k":"机身材质工艺","searchable":true,"global":true,"v":null}
        ]
   },
   { "group":"操作系统",
     "params":
        [
         {"k":"操作系统","searchable":true,"global":true,"v":"Android"}
        ]
   },
   [{"group":"主芯片",
    "params":
       [
         {"k":"CPU品牌","searchable":true,"global":true,"v":"骁龙（Snapdragon)"},
         {"k":"CPU型号","searchable":false,"global":true,"v":"骁龙617（msm8952）"},
         {"k":"CPU核数","searchable":true,"global":true,"v":"八核"},
         {"k":"CPU频率","searchable":true,"global":true,"numerical":true,"unit":"GHz","v":1.5}
       ]
   }],
   { "group":"存储",
     "params":[
       { "k":"内存","searchable":true,"global":false,"numerical":false,"unit":"GB","options":["3GB","6GB"]},
       {"k":"机身存储","searchable":true,"global":false,"numerical":false,"unit":"GB","options":["16GB"]}
     ]
   }],






   {"group":"屏幕","params":[{"k":"主屏幕尺寸（英寸）","searchable":true,"global":true,"numerical":true,"unit":"英寸","v":5.2},{"k":"分辨率","searchable":false,"global":true,"v":"1920*1080(FHD)"}]},{"group":"摄像头","params":[{"k":"前置摄像头","searchable":true,"global":true,"numerical":true,"unit":"万","v":800.0},{"k":"后置摄像头","searchable":true,"global":true,"numerical":true,"unit":"万","v":1300.0}]},{"group":"电池信息","params":[{"k":"电池容量（mAh）","searchable":true,"global":true,"numerical":true,"unit":"mAh","v":3000.0}]}]

 **/
