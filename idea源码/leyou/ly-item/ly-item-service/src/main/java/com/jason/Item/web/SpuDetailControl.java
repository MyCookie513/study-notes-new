package com.jason.Item.web;


import com.jason.Enums.ExceptionEnum;
import com.jason.Item.service.SpuDetailService;
import com.jason.exception.lyException;
import com.jason.pojo.SpuDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SpuDetailControl {

    @Autowired
    public SpuDetailService spuDetailService;

    @GetMapping("/spu/detail/{id}")
   public ResponseEntity<SpuDetail> querySpuDetailById(@PathVariable("id")Long id ){
        SpuDetail spuDetail=spuDetailService.querySpuDetailByid(id);
        if (spuDetail==null){
            throw new lyException(ExceptionEnum.DETAIL_NOT_FIND);
        }

        return ResponseEntity.ok(spuDetail);

    }

}
