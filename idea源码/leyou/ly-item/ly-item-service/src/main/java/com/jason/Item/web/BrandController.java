package com.jason.Item.web;

import com.jason.Enums.ExceptionEnum;
import com.jason.Item.service.BrandService;
import com.jason.exception.lyException;
import com.jason.pojo.Brand;
import com.jason.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>>  queryBrandByage(
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows,
            @RequestParam(value = "sortBy",required = false)String sort,
            @RequestParam(value = "desc",defaultValue = "false")boolean desc ,
            @RequestParam(value = "key",required = false)String key
    ){

        PageResult<Brand> pageResult= brandService.queryBrandbyage(page,rows,sort,desc,key);
        return ResponseEntity.ok(pageResult);
    }

    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        this.brandService.saveBrand(brand, cids);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("cid/{cid}")
    public ResponseEntity<List<Brand>> queryBrandByCategory(@PathVariable("cid") Long cid) {
        List<Brand> list = this.brandService.queryBrandByCategory(cid);
        if(list == null){
            throw new lyException(ExceptionEnum.BRAND_NOT_FIND);
        }
        return ResponseEntity.ok(list);
    }
}
