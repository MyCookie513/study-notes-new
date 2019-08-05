package com.koali.web;

import com.koali.dao.dataMapper;
import com.koali.model.*;
import com.koali.service.LoginService;
import com.koali.service.NewStudentInfoService;
import com.koali.service.User_signServaice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Elric on 2017/7/6.
 */
@Controller
public class EchartsController {
    @Autowired
    private NewStudentInfoService newStudentInfoService;

    @Autowired
    private User_signServaice user_signServaice;
    @Autowired
    private dataMapper dataMapper0;
    @RequestMapping(value = "/hello")
    @ResponseBody
    public List<NewStudent> page() {
        List<NewStudent> newStudents = newStudentInfoService.getAllStudent();
        System.out.println(newStudents.size());
        return newStudents;
    }

    @RequestMapping(value = "/getScore")
    @ResponseBody
    public List<Integer> getScore() {
        List<NewStudent> newStudents = newStudentInfoService.getAllStudent();
        List<Integer> scores = null;
        for (NewStudent newStudent : newStudents) {
            scores.add(newStudent.getScore());
        }
        return scores;
    }

//    @RequestMapping(value = "/getEcharts")
//    @ResponseBody
//    public String getEcharts(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//
//        try {
//            httpServletResponse.setContentType("text/html;charset=utf-8");
//            PrintWriter printWriter = httpServletResponse.getWriter();
//            JSONArray jsonArray = new JSONArray();
//            List<NewStudent> students = newStudentInfoService.getAllStudent();
//            for (NewStudent student : students) {
//                System.out.println(student);
//                jsonArray.put(student);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//       }
//       return "Test";
//    }

    @RequestMapping(value = "/myeCharts")
    public String myeCharts() {
        return "zhexian";
    }

    @RequestMapping(value = "/mywelcome")
    public String mywelcome() {
        return "main_show/welcome";
    }
    @RequestMapping(value = "/getPieCharts")
    public String getPieCharts() {
        return "myecharts";
    }

    @RequestMapping(value = "/getzhexian")
    public String getZhexian() {
        return "zhexian";
    }

    @RequestMapping(value = "/getZhu")
    public String getZhu() {
        return "Hello";
    }


    @RequestMapping(value = "/search_data")
    public String getSearch_data() {
        return "main_show/google";
    }

    @RequestMapping(value = "/getData")
    @ResponseBody
    public List<sorceResult> getData() {
        List<NewStudent> students = newStudentInfoService.getAllStudent();
        List<sorceResult> results = new ArrayList<sorceResult>();
        for (NewStudent newStudent : students) {
            //把学生的成绩和姓名封装到一个result
            sorceResult result = new sorceResult(newStudent.getScore(), newStudent.getName());
            results.add(result);
        }
        return results;
    }



    @Autowired
    private LoginService loginService;

    @RequestMapping("toLogin")
    public String toLogin() {
        return "Login";
    }

    @RequestMapping("login")
    public String login(User user, HttpSession session, Model model) {
        String loginname = user.getLoginname();
        String password = user.getPassword();
        Map<String, Object> map = loginService.login(loginname, password);
        if (map.get("status").equals("200")) {

            User user0=(User) map.get("user");
            session.setAttribute("user",user0);
            return "main_content";
        } else {
            model.addAttribute("error", map.get("msg"));
            return "Login";
        }
    }


    @RequestMapping(value = "getUser")
    public ModelAndView getColumnChart(HttpServletRequest request, HttpServletResponse response,
                                       ModelMap modelMap, HttpSession session) throws Exception {

       User user= (User) session.getAttribute("user");

        modelMap.put("user", user);
        return new ModelAndView("main_show/DataTest", modelMap);

    }


    @RequestMapping(value = "getDataList")
    public ModelAndView getuser(HttpServletRequest request, HttpServletResponse response,
                                       ModelMap modelMap ) throws Exception {

       List<user_sign> list=user_signServaice.getallUser_sign();

        modelMap.put("list", list);
        return new ModelAndView("main_show/user_list", modelMap);

    }

    @RequestMapping(value = "getlishidata")
    public ModelAndView getlishidata(String time,HttpServletRequest request, HttpServletResponse response,
                                ModelMap modelMap ) throws Exception {

        List<data> list=dataMapper0.selectbytime("%"+time+"%");

        modelMap.put("list", list);
        return new ModelAndView("main_show/data_list", modelMap);

    }

    @RequestMapping(value = "gettype1_qiti")
    public ModelAndView gettype1_qiti( String  type,HttpServletRequest request, HttpServletResponse response,
                                ModelMap modelMap , HttpSession session) throws Exception {

        List<data> list=dataMapper0.selectbytype(Integer.parseInt(type));
        session.setAttribute("type",type);
        modelMap.put("result", list);
        return new ModelAndView("tu/qiti", modelMap);

    }

    @RequestMapping(value = "getByTypeAndlei")
    public ModelAndView getByTypeAndlei(String type,String canshu,HttpServletRequest request, HttpServletResponse response,
                                        ModelMap modelMap, HttpSession session) throws Exception {
        System.out.println(type+"//"+canshu);
        List<data> list=dataMapper0.selectbytype(Integer.parseInt(type));

        modelMap.put("result", list);


        session.setAttribute("leibie",canshu);
        session.setAttribute("type",type);
        return new ModelAndView("tu/putong", modelMap);

    }
    @RequestMapping(value = "gettype1_data")
    @ResponseBody
    public  List<data> gettype1_data(String type) {

        List<data> result=dataMapper0.selectbytype(Integer.parseInt(type));


        return result;

    }

}