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
		//�����Java����Servlet�����л��application���������ֵ��
		//1.ת����httpservletrequest����
		HttpServletRequest req=(HttpServletRequest)request;
		//�������еõ��Ự����-----�ӻỰ�����еõ�Servletcontext���� �������Ķ���==application��
		req.getSession().getServletContext().setAttribute("count", count);
		
		//���˺������������
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		//ֻ�г�ʼ��ʱ���ô˺���
		
		String str=fConfig.getInitParameter("count");
		/*Ȼ��count���������ڴ���һֱ�����ۼӣ�*/
		count=Integer.parseInt(str);
		
		
	}

}
