package com.jason.Item.service;


import com.jason.Item.mapper.SpuDetailMapper;
import com.jason.Item.mapper.SpuMapper;
import com.jason.pojo.SpuDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuDetailService {


    @Autowired
    public SpuDetailMapper spuDetailMapper;
    @Autowired
    public SpuMapper Mapper0;


    public SpuDetail querySpuDetailByid(Long id ){

        return spuDetailMapper.selectByPrimaryKey(id);
    }


}
