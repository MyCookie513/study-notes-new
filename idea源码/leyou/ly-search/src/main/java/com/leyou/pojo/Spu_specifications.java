package com.leyou.pojo;


import lombok.Data;

import java.util.List;

/**
 * 带value值的规格参数
 */
@Data
public class Spu_specifications {

    private String group;
    private List<Params> params;

}
