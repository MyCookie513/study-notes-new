package com.jason.Item.service;

import com.jason.Enums.ExceptionEnum;
import com.jason.Item.mapper.CategoryMapper;
import com.jason.exception.lyException;
import com.jason.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid) {
        Category category=new Category();
        category.setParentId(pid);
        /*条件查询　；　where  实体类非空字段*/
        List<Category> result=categoryMapper.select(category);
        /*　在这里抛出异常后　，　　会有AOP异常通知拦截这个异常　处理异常　　*/
        if (CollectionUtils.isEmpty(result))
                throw new lyException(ExceptionEnum.CATEGORY_NOT_FIND);

        return result;
    }



    public List<String> queryNameByIds(List<Long> ids) {
        List<String> names=this.categoryMapper.selectByIdList(ids).stream().map(Category::getName).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(names))
            throw new lyException(ExceptionEnum.CATEGORY_NOT_FIND);
        return names;
    }
}
