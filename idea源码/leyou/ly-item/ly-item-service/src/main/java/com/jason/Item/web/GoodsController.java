package com.jason.Item.web;

import com.jason.Enums.ExceptionEnum;
import com.jason.Item.service.GoodsService;
import com.jason.exception.lyException;
import com.jason.pojo.SpuBo;
import com.jason.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 分页查询SPU
     * @param page
     * @param rows
     * @param key
     * @return
     */
    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "saleable") boolean saleable,
            @RequestParam(value = "key", required = false) String key) {
        // 分页查询spu信息
        PageResult<SpuBo> result = this.goodsService.querySpuByPageAndSort(page, rows,saleable, key);
        if (result == null || result.getItems().size() == 0) {
            throw new lyException(ExceptionEnum.SPU_NOT_FIND);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping("goods")
    public ResponseEntity<Void> saveGoods(@RequestBody SpuBo spuBo) {

            this.goodsService.save(spuBo);
            return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
