package com.jason.Enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    BRAND_NOT_FIND(404,"没有相匹配的品牌"),
    DETAIL_NOT_FIND(404,"没有相匹配的spu_Detail"),
    CATEGORY_NOT_FIND(404,"商品类别没有查询到"),
    Sku_NOT_FIND(404,"商品sku没有查询到"),
    SPU_NOT_FIND(404,"商品没有查询到"),
    BAND_SAVE_ERROR(500,"新增品牌失败"),
    UPLOAD_FAILED_ERROR(500,"文件上传失败"),
    INVALID_UPLOAD_FILE_TYPE(400,"无效的文件类型"),
    SPECIFICATION_NOT_FIND(404,"该类下没有参数"),
    SPU_SAVE_ERROR(500,"新增一种SPU商品失败"),
    SPU_DETAILS_SAVE_ERROR(500,"新增一种SPU商品失败"),
    SKU_SAVE_ERROR(500,"新增一款SKU商品失败"),
    STOCK_SAVE_ERROR(500,"新增一种商品的库存失败"),
    PECIFICATION_SAVE_FAILED(500,"商品规格保存失败"),
    ;

    private int code;
    private String msg;
}
