package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class getdata extends HttpServlet {
	//内置处理两种请求的方法；
	//客户端的请求是以map容器的形式生成的request对象；
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 
	    // 设置响应内容类型 
	    //设置响应的回馈的数据的类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
	 
        try (PrintWriter out = response.getWriter()) {

            //获得请求中传来的用户名和密码
        	String getdata=null;
            String sql_table = request.getParameter("sql_table").trim();
           
            	
            WifiDataEntity data0=UserDAO.getaa(Integer.parseInt(sql_table));
            	// getdata=UserDAO.getaa(sql_table);
            	
            

           

            //Map容器内部放置数据；json对象放置map容器对象；最后将从response对像中获取的printwriter对象进行write操作；
            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();
            params.put("Result", "success");
            params.put("addtime", data0.getAddtime());
            params.put("alco_allowance", data0.getAlco_allowance());
            params.put("system_state", data0.getSystem_state());
            params.put("unsafe_types", data0.getUnsafe_types());
            
            jsonObject.put("params", params);
            out.write(jsonObject.toString());
        }
	 
 }
 

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
	
	
	

}
