package com.jason.Item.service;

import com.jason.Enums.ExceptionEnum;
import com.jason.Item.mapper.SpecificationMapper;
import com.jason.exception.lyException;
import com.jason.pojo.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;

    public Specification queryById(Long id) {
        return this.specificationMapper.selectByPrimaryKey(id);
    }

    public void saveSpecification(Specification specification) {

        int count= this.specificationMapper.insert(specification);
        if (count !=1)
            throw new lyException(ExceptionEnum.SPECIFICATION_NOT_FIND);
    }
}