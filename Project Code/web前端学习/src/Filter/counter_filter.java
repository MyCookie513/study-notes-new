package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class counter_filter
 */

public class counter_filter implements Filter {

	private int count=0;
    /**
     * Default constructor. 
     */
    public counter_filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		count++;
		//如何在Java代码Servlet请求中获得application作用域相关值？
		//1.转换成httpservletrequest对象；
		HttpServletRequest req=(HttpServletRequest)request;
		//从请求中得到会话对象-----从会话对象中得到Servletcontext对象 （上下文对象==application）
		req.getSession().getServletContext().setAttribute("count", count);
		
		//过滤后继续发送请求
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		//只有初始化时调用此函数
		
		String str=fConfig.getInitParameter("count");
		/*然后count变量放入内存中一直进行累加；*/
		count=Integer.parseInt(str);
		
		
	}

}
