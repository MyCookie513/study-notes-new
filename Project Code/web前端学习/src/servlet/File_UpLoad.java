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
		//获取服务器中文件要保存的地址；
		String path=this.getServletContext().getRealPath("/");
		//获取用户选择上传文件的组件；
		Part p=request.getPart("file0");
		//限制只能上传图片；
		if(p.getContentType().contains("image")) {
			/*下面开始为进行上传*/
			//1.将上传的组件强转为应用组件
			ApplicationPart ap=(ApplicationPart)p;
			//2.获取上传的文件的名字；
			String File_name=ap.getSubmittedFileName();
			//3.对上传的文件名进行截取，将前面的路径删除掉，剩下文件的名字
			int x0=File_name.lastIndexOf("\\");
			File_name=File_name.substring(x0+1,File_name.length());
			//要将文件写入的根路径；
		    String last_File_path=path+"/upload/"+File_name;
		    //将组件中的文件写入路径中；
			p.write(last_File_path);
			response.getWriter().write("文件上传成功");
			
			
		}else {
			
			response.getWriter().write("请选择图片进行上传");
			
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
