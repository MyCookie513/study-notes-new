package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mysql.ConnDB;

import javaBean.commodity;



/**
 * Servlet implementation class FindServlet
 */
public class Page_query extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ǰҳ��
		int currPage = 1;
		// �жϴ���ҳ���Ƿ���Ч
		if(request.getParameter("page") != null){
			// �Ե�ǰҳ�븳ֵ
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		ConnDB conndb=new ConnDB();
		
      
	    // �����ݿ��л�ȡͼ����Ϣ����
		List<commodity> list = conndb.select_info("shangpin",(currPage-1)*commodity.PAGE_SIZE,commodity.PAGE_SIZE);
		
		request.setAttribute("list", list);
		// ��ҳ��
		int pages ;
		// ��ѯ�ܼ�¼��
		int count = conndb.query_count("shangpin");
		
		// ������ҳ��
		if(count % commodity.PAGE_SIZE == 0){
			// ����ҳ����ֵ
			pages = count / commodity.PAGE_SIZE;
		}else{
			// ����ҳ����ֵ
			pages = count / commodity.PAGE_SIZE + 1;
		}
		
		// ʵ����StringBuffer
		StringBuffer sb = new StringBuffer();
		// ͨ��ѭ��������ҳ��
		for(int i=1; i <= pages; i++){
			// �ж��Ƿ�Ϊ��ǰҳ
			if(i == currPage){
				// ������ҳ��
				sb.append("��" + i + "��");
			}else{
				// ������ҳ��
				sb.append("<a href='Page_query?page=" + i + "'>" + i + "</a>");
			}
			// ������ҳ��
			sb.append("��");
		}
		// ����ҳ�����ַ������õ�request֮��
		request.setAttribute("bar", sb.toString());
		conndb.close();
		// ת����product_list.jspҳ��
		request.getRequestDispatcher("book_list.jsp").forward(request, response);
	}

}
