package web.Servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import web.Servlet.Service.AcountService;

/**
 * Servlet implementation class transter
 */
@WebServlet("/transter")
public class transter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public transter() {
       
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		//获取方式一：通过ServletContext获取webapplicationContext容器
		ApplicationContext applicationContext=
				(ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		//获取方式二：
		//ApplicationContext application=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		AcountService acountservice=(AcountService) applicationContext.getBean("AcountServiceID");
		acountservice.transfer_acount("jason","cookie", 100);
		response.getWriter().append("Served at: ").append(URLDecoder.decode(request.getContextPath(), "utf-8"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
