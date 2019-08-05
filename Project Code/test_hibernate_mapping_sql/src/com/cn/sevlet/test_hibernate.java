package com.cn.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cn.hibernate_Init.*;

/**
 * 修改时查询一个员工信息
 */
public class test_hibernate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		Session session = null;
		try {
			
				request.setAttribute("2", "读取失败");
				  
				
		session = HibernateInitialize.getSession();
		Transaction transation = session.beginTransaction();      
		test_hibernate product = new test_hibernate();//实例化对象
		session.load(product, new Integer("1"));
		
		
		request.setAttribute("1", product);
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			HibernateInitialize.closeSession();//关闭session
		}
		
//		//跳转到修改页面
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index1.jsp");
		rd.forward(request, response);
	}

}
