package com.jason.API;

import com.jason.pojo.Category;
import com.jason.pojo.Sku;
import com.jason.pojo.SpuBo;
import com.jason.pojo.SpuDetail;
import com.jason.vo.PageResult;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequestMapping
public interface GoodsClient {

    /**
     * 分页查询商品
     * @param page
     * @param rows
     * @param saleable
     * @param key
     * @return
     */
    @GetMapping("/spu/page")
    ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "saleable", defaultValue = "true") Boolean saleable,
            @RequestParam(value = "key", required = false) String key);

    /**
     * 根据spu商品id查询详情
     * @param id
     * @return
     */
    @GetMapping("/spu/detail/{id}")
    ResponseEntity<SpuDetail> querySpuDetailById(@PathVariable("id") Long id);

    /**
     * 根据spu的id查询sku
     * @param id
     * @return
     */
    @GetMapping("sku/list")
    ResponseEntity<List<Sku>> querySkuBySpuId(@RequestParam("id") Long id);


    @GetMapping("category/list")
    public ResponseEntity<List<Category>> queryCategoryBypid(@RequestParam("pid") Long pid);

    @GetMapping("category/listbyids")
    public ResponseEntity<List<String>> queryNameByIds(@RequestParam("pid") List<Long> pid);



}