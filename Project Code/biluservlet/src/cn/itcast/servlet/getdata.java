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
	//���ô�����������ķ�����
	//�ͻ��˵���������map��������ʽ���ɵ�request����
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 
	    // ������Ӧ�������� 
	    //������Ӧ�Ļ��������ݵ�����
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
	 
        try (PrintWriter out = response.getWriter()) {

            //��������д������û���������
        	String getdata=null;
            String sql_table = request.getParameter("sql_table").trim();
           
            	
            WifiDataEntity data0=UserDAO.getaa(Integer.parseInt(sql_table));
            	// getdata=UserDAO.getaa(sql_table);
            	
            

           

            //Map�����ڲ��������ݣ�json�������map����������󽫴�response�����л�ȡ��printwriter�������write������
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
