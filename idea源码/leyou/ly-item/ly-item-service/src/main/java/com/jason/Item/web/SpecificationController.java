package com.jason.Item.web;

import com.jason.Enums.ExceptionEnum;
import com.jason.Item.service.SpecificationService;
import com.jason.exception.lyException;
import com.jason.pojo.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping("{id}")
    public ResponseEntity<String> querySpecificationByCategoryId(@PathVariable("id") Long id){
        Specification spec = this.specificationService.queryById(id);
        if (spec == null) {
            throw new lyException(ExceptionEnum.SPECIFICATION_NOT_FIND);
        }
        return ResponseEntity.ok(spec.getSpecifications());
    }


    @PostMapping
    public ResponseEntity<Void> saveSpecifications(Specification specification) {
        this.specificationService.saveSpecification(specification);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}