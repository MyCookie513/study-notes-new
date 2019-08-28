package com.jason.Item.service;


import com.jason.Enums.ExceptionEnum;
import com.jason.Item.mapper.SkuMapper;
import com.jason.exception.lyException;
import com.jason.pojo.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SkuService {


    @Autowired
    public SkuMapper skuMapper;



    public List<Sku> querySkuListBySpu(Long Spuid) {
        Sku sku=new Sku();
        sku.setSpuId(Spuid);
        /*条件查询　；　where  实体类非空字段*/
        List<Sku> result=skuMapper.select(sku);
        /*　在这里抛出异常后　，　　会有AOP异常通知拦截这个异常　处理异常　　*/
        if (CollectionUtils.isEmpty(result))
            throw new lyException(ExceptionEnum.Sku_NOT_FIND);

        return result;
    }
}
