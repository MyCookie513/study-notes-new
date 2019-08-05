package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

/**
 * Servlet implementation class File_UpLoad
 */
@WebServlet("/File_UpLoad")
@MultipartConfig()
public class File_UpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public File_UpLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//��ȡ���������ļ�Ҫ����ĵ�ַ��
		String path=this.getServletContext().getRealPath("/");
		//��ȡ�û�ѡ���ϴ��ļ��������
		Part p=request.getPart("file0");
		//����ֻ���ϴ�ͼƬ��
		if(p.getContentType().contains("image")) {
			/*���濪ʼΪ�����ϴ�*/
			//1.���ϴ������ǿתΪӦ�����
			ApplicationPart ap=(ApplicationPart)p;
			//2.��ȡ�ϴ����ļ������֣�
			String File_name=ap.getSubmittedFileName();
			//3.���ϴ����ļ������н�ȡ����ǰ���·��ɾ������ʣ���ļ�������
			int x0=File_name.lastIndexOf("\\");
			File_name=File_name.substring(x0+1,File_name.length());
			//Ҫ���ļ�д��ĸ�·����
		    String last_File_path=path+"/upload/"+File_name;
		    //������е��ļ�д��·���У�
			p.write(last_File_path);
			response.getWriter().write("�ļ��ϴ��ɹ�");
			
			
		}else {
			
			response.getWriter().write("��ѡ��ͼƬ�����ϴ�");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
