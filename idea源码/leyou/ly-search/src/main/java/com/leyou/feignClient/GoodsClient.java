package com.leyou.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "item-service")
public interface GoodsClient extends com.jason.API.GoodsClient {
}
