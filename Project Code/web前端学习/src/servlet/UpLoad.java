package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 
 * @author administrator
 */
public class UpLoad extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("uploadFile".equals(action)) {
			this.uploadFile(request, response); // 上传文件
		}
	}

	public void uploadFile(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//设置请求和回复的编码格式
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("GBK");
		//从请求中得到session变量
		HttpSession session = request.getSession();
		// 定义指定上传进度的Session变量
		session.setAttribute("progressBar", 0); 
		String error = "";
		int maxSize = 50 * 1024 * 1024; // 单个上传文件大小的上限
		//DiskFileItemFactory---->servletFileupload----->进行解析请求获得集合对象，---》
		DiskFileItemFactory factory = new DiskFileItemFactory(); // 基于磁盘文件项目创建一个工厂对象
		ServletFileUpload upload = new ServletFileUpload(factory); // 创建一个新的文件上传对象
		try {
			List items = upload.parseRequest(request);// 解析上传请求
			Iterator itr = items.iterator();// 枚举方法
			//可能在请求中得到多个上传的对象；
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next(); // 获取FileItem对象
				if (!item.isFormField()) {// 判断是否为文件域
					if (item.getName() != null && !item.getName().equals("")) {// 判断是否选择了文件
						long upFileSize = item.getSize(); // 上传文件的大小
						String fileName = item.getName(); // 获取文件名
						 //System.out.println("上传文件的大小:" + item.getSize());
						if (upFileSize > maxSize) {
							error = "您上传的文件太大，请选择不超过50M的文件";
							break;
						}
						// 此时文件暂存在服务器的内存中
						File tempFile = new File(fileName);// 构造临时对象
						// String savePath=tempFile.getName();
						// //返回上传文件在客户端的完整路径名称
						// request.setAttribute("filename", savePath);
						File file = new File(request.getRealPath("/upload"),
								tempFile.getName()); // 获取根目录对应的真实物理路径

						//从文件Item中获得输入流
						InputStream is = item.getInputStream();
						int buffer = 1024; // 定义缓冲区的大小
						int length = 0;
						byte[] b = new byte[buffer];
						double percent = 0;
						FileOutputStream fos = new FileOutputStream(file);
						//进行一边输入流读取文件一边进行输出流写入文件
						while ((length = is.read(b)) != -1) {
							percent += length / (double) upFileSize * 100D; // 计算上传文件的百分比
							fos.write(b, 0, length); // 向文件输出流写读取的数据
							//在会话中设置一个共享属性
							session.setAttribute("progressBar", Math
									.round(percent)); // 将上传百分比保存到Session中
						}
						fos.close();
						Thread.sleep(1000); // 线程休眠1秒
					} else {
						error = "没有选择上传文件！";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			error = "上传文件出现错误：" + e.getMessage();
		}
		//如果错误不为空的话，进行在请求中设置一个传递的数据，然后跳转到错误的显示页面；
		
		if (!"".equals(error)) {
			request.setAttribute("error", error);
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
			
		} else {
			request.setAttribute("result", "文件上传成功！");
			request.getRequestDispatcher("upFile_deal.jsp").forward(request,
					response);
		}
	}
}
