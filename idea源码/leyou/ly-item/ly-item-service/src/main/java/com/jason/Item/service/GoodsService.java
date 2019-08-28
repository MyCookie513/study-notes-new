package com.jason.Item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jason.Enums.ExceptionEnum;
import com.jason.Item.mapper.*;
import com.jason.exception.lyException;
import com.jason.pojo.*;
import com.jason.vo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class GoodsService {
    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SpuDetailMapper spuDetailMapper;
    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private StockMapper stockMapper;
    /**
     * 条件性质的查询商品： 同时分页查询： mybatis拦截四大组件 ；修改sql语句
     * 规格参数；
     * 同时查询出商品的品牌和类别
     *
     * @param page
     * @param rows
     * @param saleable
     * @param key
     * @return
     */
    @Transactional
    public PageResult<SpuBo> querySpuByPageAndSort(Integer page, Integer rows, Boolean saleable, String key) {
        // 1、查询SPU
        // 分页,最多允许查100条
        PageHelper.startPage(page, Math.min(rows, 100));
        // 创建查询条件
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();

        // 是否过滤上下架
        if (saleable != null) {
            criteria.orEqualTo("saleable", saleable);
        }

        // 是否模糊查询
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("title", "%" + key + "%");
        }

        //根据title和是否上下架来进行条件查询
        Page<Spu> pageInfo = (Page<Spu>) this.spuMapper.selectByExample(example);



        //getResult():得到查询到的结果
        //stream 转换成---》 list    :  collect(Collection.toList())
        List<SpuBo> list = pageInfo.getResult().stream().map(spu -> {
            // 把spu变为 spuBo
            SpuBo spuBo = new SpuBo();
            // 属性拷贝
            BeanUtils.copyProperties(spu, spuBo);
            // 3、查询spu的商品分类名称,要查三级分类，返回类别的数组字符串
            List<String> names =
                    this.categoryService.queryNameByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));
            // 将分类名称拼接后存入
            spuBo.setCname(StringUtils.join(names, "/"));

            // 4、查询spu的品牌名称
            Brand brand = this.brandMapper.selectByPrimaryKey(spu.getBrandId());
            spuBo.setBname(brand.getName());
            return spuBo;

        }).collect(Collectors.toList());

        return new PageResult<>(pageInfo.getTotal(), list);
    }

    @Transactional
    public void save(SpuBo spuBo) {


        // 保存spu
        spuBo.setSaleable(true);
        spuBo.setValid(true);
        spuBo.setCreateTime(new Date());
        spuBo.setLastUpdateTime(spuBo.getCreateTime());
        int count=this.spuMapper.insert(spuBo);
        if (count !=1)
            throw new lyException(ExceptionEnum.SPU_SAVE_ERROR);
        // 保存spu详情 --
        spuBo.getSpuDetail().setSpuId(spuBo.getId());
        this.spuDetailMapper.insert(spuBo.getSpuDetail());
        if (count !=1)
            throw new lyException(ExceptionEnum.SPU_DETAILS_SAVE_ERROR);
        // 保存sku和库存信息
        saveSkuAndStock(spuBo.getSkus(), spuBo.getId());


    }

    @Transactional
     void saveSkuAndStock(List<Sku> skus, Long spuId) {

        for (Sku sku : skus) {
            if (!sku.getEnable()) {
                continue;
            }
            // 保存sku
            sku.setSpuId(spuId);
            // 初始化时间
            sku.setCreateTime(new Date());
            sku.setLastUpdateTime(sku.getCreateTime());
           int count=this.skuMapper.insert(sku);
            if (count !=1)
                throw new lyException(ExceptionEnum.SKU_SAVE_ERROR);
            // 保存库存信息
            Stock stock = new Stock();
            stock.setSkuId(sku.getId());
            stock.setStock(sku.getStock());
            int count0=this.stockMapper.insert(stock);
            if (count0 !=1)
                throw new lyException(ExceptionEnum.STOCK_SAVE_ERROR);
        }
    }
}
