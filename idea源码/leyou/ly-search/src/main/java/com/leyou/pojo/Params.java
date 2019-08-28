package com.leyou.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Params {
    private String k;
    private String v;
    private boolean searchable;
    private boolean global;
    private boolean numerical;
    private String unit;
    private List<String> options;
}
