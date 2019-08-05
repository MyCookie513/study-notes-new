package com.controller;

import com.service.ColumnarService;
import com.service.LoginService;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("data")
public class ColumnnarController {


    @Autowired
    private ColumnarService columnarService;

    @RequestMapping(value = "getLineChart")
    public ModelAndView getColumnChart(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap modelMap) throws Exception {
        // 在业务层获取创建的柱状图（此时柱状图已经创建完成的）
        JFreeChart chart = columnarService.createColumnarTools();
        // 将图形转换为图片传到dateSet.jsp
        String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400,
                null, request.getSession());
        String chartURL = request.getContextPath() + "/chart?filename="
                + fileName;
        modelMap.put("chartColumnURL", chartURL);
        return new ModelAndView("dateSet.jsp", modelMap);
    }





}
