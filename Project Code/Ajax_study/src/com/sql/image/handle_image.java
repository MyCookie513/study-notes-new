package com.sql.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.ConnDB;
//Ŀǰ���������֣�
//1.��ͼƬ�ļ�ת�����ֽڣ�
//2.���ֽ��ļ��������ݿ��У�
public class handle_image {
	
	//��ͼƬ�ļ�ת���ɻ����е��ֽ����飻
		public byte[] ImageByte(File file) {
			
			try {
				//���ļ���������
				FileInputStream fin=new FileInputStream(file);
				//�����ֽڻ����������ҷ����ļ���С�Ŀռ� ��
				ByteBuffer bytebuffer0=ByteBuffer.allocate((int)file.length());
				//����һ����ת�ֽ����飻
				byte[] array=new byte[1024];
				int length=0;
				while((length=fin.read(array))>0) {
					if(length!=1024) {
						//���ֽڻ�������ȡͼƬ���ʣ�µ��ǲ����ֽڣ�
						bytebuffer0.put(array,0,length);
					}else {
						bytebuffer0.put(array);
					}
					
				}
				fin.close();//�ر��ļ���
				//���ֽ�������ʼ����Ŀռ䣩ת��Ϊ�ֽ�����
				byte[] content=bytebuffer0.array();
				System.out.println("�ļ���С���ֽڣ���"+content.length);
				
				return content;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			
		}
		
		//���ֽ�������뵽���ݿ��У������������ݿ�ı�����ν��id������һ�θ�����������
		public boolean loadImage(String sql,byte[] content,int id,String str) {
			if(sql==null) {
				
				sql="select * from images";
				ConnDB con=new ConnDB();
				try {
					
					//������ִ�в�ѯ��䣻����һ�������
					ResultSet result=con.executeQuery(sql);
					result.updateString("describe", str);
					result.updateInt("id", id);
					result.updateBytes("image", content);
					//ִ�в���
					result.updateRow();
					return true;
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			}
			return false;
			
			
		}
		
		
}
