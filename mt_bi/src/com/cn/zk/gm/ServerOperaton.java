package com.cn.zk.gm;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.cn.zk.gm.bean.Servlet;

public class ServerOperaton {
	
	
	public String conncetionServlet(Servlet servlet){
		try {
			Socket socket = new Socket(servlet.host, servlet.port);
			//验证是否连接上
			if(socket.isConnected()){
				InputStream in = socket.getInputStream();
				PrintWriter w = new PrintWriter(socket.getOutputStream());
				
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return "error";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}

		
		
		return "";
	}
	
}
