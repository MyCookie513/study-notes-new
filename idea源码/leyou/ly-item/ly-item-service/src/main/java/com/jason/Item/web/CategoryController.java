package com.jason.Item.web;

import com.jason.Item.service.CategoryService;
import com.jason.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryBypid(@RequestParam("pid") Long pid){

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.queryCategoryListByPid(pid));
    }

    @GetMapping("listbyids")
    public ResponseEntity<List<String>> queryNameByIds(@RequestParam("pid") List<Long> pid){

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.queryNameByIds(pid));
    }

}
