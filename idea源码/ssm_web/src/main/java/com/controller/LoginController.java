
package com.controller;

import com.dao.BookMapper;
import com.pojo.BookFunEntity;
import com.pojo.User;
import com.service.ColumnarService;
import com.service.FoldLineService;
import com.service.LoginService;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private ColumnarService columnarService;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private FoldLineService foldLineService;
    @Autowired
    private LoginService loginService;

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login.jsp";
    }

    @RequestMapping("login")
    public String login(User user, Model model) {
        String loginname = user.getLoginname();
        String password = user.getPassword();
        Map<String, Object> map = loginService.login(loginname, password);
        if (map.get("status").equals("200")) {
            return "dataSet.jsp";
        } else {
            model.addAttribute("error", map.get("msg"));
            return "login.jsp";
        }
    }



    @RequestMapping(value = "getColumnChart")
    public ModelAndView getColumnChart(HttpServletRequest request,HttpServletResponse response,
                                        ModelMap modelMap) throws Exception {
        // 在业务层获取创建的柱状图（此时柱状图已经创建完成的）
        JFreeChart chart = columnarService.createColumnarTools();
        // 将图形转换为图片传到dateSet.jsp
        String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400,
                null, request.getSession());
        String chartURL = request.getContextPath() + "/chart?filename="
                + fileName;
        modelMap.put("chartColumnURL", chartURL);
        return new ModelAndView("dataSet.jsp", modelMap);

    }
    @RequestMapping(value = "getLineChart")
    public ModelAndView getfoldLine(HttpServletRequest request,
                                              HttpServletResponse response, ModelMap modelMap) throws Exception {
        // 在业务层获取创建的柱状图（此时柱状图已经创建完成的）
        JFreeChart chart = foldLineService.createFoldLineTools();
        // 将图形转换为图片传到dateSet.jsp
        String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400,
                null, request.getSession());
        String chartURL = request.getContextPath() + "/chart?filename="
                + fileName;
        modelMap.put("chartColumnURL", chartURL);
        return new ModelAndView("dataSet.jsp", modelMap);
    }
    @RequestMapping(value = "getbook")
    public ModelAndView getbook(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap modelMap) throws Exception {


        List<BookFunEntity> bookList =bookMapper.selectbook();
        BookFunEntity book=bookList.get(0);
        System.out.println(book.getAvprice());

        modelMap.put("book", book);
        return new ModelAndView("dataSet.jsp", modelMap);
    }
}

