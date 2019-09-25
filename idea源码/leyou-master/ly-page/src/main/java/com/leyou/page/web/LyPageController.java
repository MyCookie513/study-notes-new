package com.leyou.page.web;

import com.leyou.page.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @author bystander
 * @date 2018/9/26
 */
@Controller
public class LyPageController {

    @Autowired
    private PageService pageService;


    @GetMapping("item/{id}.html")
    public String toItemPage(@PathVariable("id") Long spuId, Model model) {
        // 加载所需的数据
        Map<String, Object> modelMap = this.pageService.loadModel(spuId);
        // 放入模型
        model.addAllAttributes(modelMap);
        // 判断是否需要生成新的页面
        if(!this.pageService.exists(spuId)){
            this.pageService.syncCreateHtml(spuId);
        }
        return "item";

    }

}
