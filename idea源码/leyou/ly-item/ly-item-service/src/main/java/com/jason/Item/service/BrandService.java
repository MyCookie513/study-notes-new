package com.jason.Item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.Enums.ExceptionEnum;
import com.jason.Item.mapper.BrandMapper;
import com.jason.exception.lyException;
import com.jason.pojo.Brand;
import com.jason.vo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.LinkedList;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;


    public PageResult<Brand> queryBrandbyage(Integer page, Integer rows, String sort, boolean desc, String key) {

        //分页
        PageHelper.startPage(page,rows);
        //过滤
        Example example=new Example(Brand.class);
        if (StringUtils.isNotBlank(key))
          example.createCriteria().orLike("name","%"+key+"%").orEqualTo("letter",key.toUpperCase());
        //排序
        if (StringUtils.isNotBlank(sort)){
            example.setOrderByClause(sort+(desc?" DESC":" ASC"));
        }

        //查询

        List<Brand> list=brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list))
            throw new lyException(ExceptionEnum.BRAND_NOT_FIND);
        //在分页查询中已经查询出总页数了
        PageInfo<Brand> pageInfo=new PageInfo<>(list);

        return new  PageResult<>( pageInfo.getTotal(),pageInfo.getList());

    }

    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        brand.setId(null);
        // 新增品牌信息
       int count= this.brandMapper.insertSelective(brand);
       if (count !=1)
           throw new lyException(ExceptionEnum.BAND_SAVE_ERROR);
        // 新增品牌和分类中间表
        for (Long cid : cids) {
           int result= this.brandMapper.insertCategoryBrand(cid, brand.getId());
           if (result!=1)
               throw new lyException(ExceptionEnum.BAND_SAVE_ERROR);
        }
    }


    public List<Brand> queryBrandByCategory(Long cid) {
        return this.brandMapper.queryByCategoryId(cid);
    }
}
