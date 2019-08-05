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
//目前包括两部分：
//1.将图片文件转换成字节；
//2.将字节文件存入数据库中；
public class handle_image {
	
	//将图片文件转换成缓存中的字节数组；
		public byte[] ImageByte(File file) {
			
			try {
				//将文件对象流化
				FileInputStream fin=new FileInputStream(file);
				//创建字节缓冲区，并且分配文件大小的空间 ；
				ByteBuffer bytebuffer0=ByteBuffer.allocate((int)file.length());
				//建立一个中转字节数组；
				byte[] array=new byte[1024];
				int length=0;
				while((length=fin.read(array))>0) {
					if(length!=1024) {
						//在字节缓冲区读取图片最后剩下的那部分字节；
						bytebuffer0.put(array,0,length);
					}else {
						bytebuffer0.put(array);
					}
					
				}
				fin.close();//关闭文件流
				//将字节流（初始分配的空间）转变为字节数组
				byte[] content=bytebuffer0.array();
				System.out.println("文件大小（字节）："+content.length);
				
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
		
		//将字节数组存入到数据库中；所建立的数据库的表有所谓的id，还有一段附属的描述；
		public boolean loadImage(String sql,byte[] content,int id,String str) {
			if(sql==null) {
				
				sql="select * from images";
				ConnDB con=new ConnDB();
				try {
					
					//操作者执行查询语句；返回一个结果集
					ResultSet result=con.executeQuery(sql);
					result.updateString("describe", str);
					result.updateInt("id", id);
					result.updateBytes("image", content);
					//执行操作
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
