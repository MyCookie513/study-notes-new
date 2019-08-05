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
			this.uploadFile(request, response); // �ϴ��ļ�
		}
	}

	public void uploadFile(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��������ͻظ��ı����ʽ
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("GBK");
		//�������еõ�session����
		HttpSession session = request.getSession();
		// ����ָ���ϴ����ȵ�Session����
		session.setAttribute("progressBar", 0); 
		String error = "";
		int maxSize = 50 * 1024 * 1024; // �����ϴ��ļ���С������
		//DiskFileItemFactory---->servletFileupload----->���н��������ü��϶���---��
		DiskFileItemFactory factory = new DiskFileItemFactory(); // ���ڴ����ļ���Ŀ����һ����������
		ServletFileUpload upload = new ServletFileUpload(factory); // ����һ���µ��ļ��ϴ�����
		try {
			List items = upload.parseRequest(request);// �����ϴ�����
			Iterator itr = items.iterator();// ö�ٷ���
			//�����������еõ�����ϴ��Ķ���
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next(); // ��ȡFileItem����
				if (!item.isFormField()) {// �ж��Ƿ�Ϊ�ļ���
					if (item.getName() != null && !item.getName().equals("")) {// �ж��Ƿ�ѡ�����ļ�
						long upFileSize = item.getSize(); // �ϴ��ļ��Ĵ�С
						String fileName = item.getName(); // ��ȡ�ļ���
						 //System.out.println("�ϴ��ļ��Ĵ�С:" + item.getSize());
						if (upFileSize > maxSize) {
							error = "���ϴ����ļ�̫����ѡ�񲻳���50M���ļ�";
							break;
						}
						// ��ʱ�ļ��ݴ��ڷ��������ڴ���
						File tempFile = new File(fileName);// ������ʱ����
						// String savePath=tempFile.getName();
						// //�����ϴ��ļ��ڿͻ��˵�����·������
						// request.setAttribute("filename", savePath);
						File file = new File(request.getRealPath("/upload"),
								tempFile.getName()); // ��ȡ��Ŀ¼��Ӧ����ʵ����·��

						//���ļ�Item�л��������
						InputStream is = item.getInputStream();
						int buffer = 1024; // ���建�����Ĵ�С
						int length = 0;
						byte[] b = new byte[buffer];
						double percent = 0;
						FileOutputStream fos = new FileOutputStream(file);
						//����һ����������ȡ�ļ�һ�߽��������д���ļ�
						while ((length = is.read(b)) != -1) {
							percent += length / (double) upFileSize * 100D; // �����ϴ��ļ��İٷֱ�
							fos.write(b, 0, length); // ���ļ������д��ȡ������
							//�ڻỰ������һ����������
							session.setAttribute("progressBar", Math
									.round(percent)); // ���ϴ��ٷֱȱ��浽Session��
						}
						fos.close();
						Thread.sleep(1000); // �߳�����1��
					} else {
						error = "û��ѡ���ϴ��ļ���";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			error = "�ϴ��ļ����ִ���" + e.getMessage();
		}
		//�������Ϊ�յĻ�������������������һ�����ݵ����ݣ�Ȼ����ת���������ʾҳ�棻
		
		if (!"".equals(error)) {
			request.setAttribute("error", error);
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
			
		} else {
			request.setAttribute("result", "�ļ��ϴ��ɹ���");
			request.getRequestDispatcher("upFile_deal.jsp").forward(request,
					response);
		}
	}
}
