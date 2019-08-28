package com.jason.Item.web;

import com.jason.Item.service.SkuService;
import com.jason.pojo.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class SkuControl {

    @Autowired
    public SkuService skuService;

    /**
     * 根据spu的id查询sku
     * @param id
     * @return
     */
    @GetMapping("sku/list")
    ResponseEntity<List<Sku>> querySkuBySpuId(@RequestParam("id") Long id){
        return ResponseEntity.ok(skuService.querySkuListBySpu(id));
    }

}
