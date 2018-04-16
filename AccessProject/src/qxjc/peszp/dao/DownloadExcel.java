package qxjc.peszp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadExcel {
	private static String rightFile = "jpg,bmp,pdf,gif,png,txt,jpeg,flv,swf,csv,rar,zip,xls,doc,ppt,cer,xml,dbf,dmp,tif";
	private static String openFile = "jpg,bmp,pdf,gif,png,txt,jpeg,flv,swf,tif";
	
	public void xiazai(HttpServletResponse response,HttpServletRequest request,String excelNetPath){
	String filePath = request.getServletPath();
	BaseDao bd = new BaseDao();
	
	filePath = excelNetPath;
	
	String fileName = filePath.substring(filePath.lastIndexOf(System
			.getProperty("file.separator")) + 1);
	String extendName = fileName.substring(fileName.lastIndexOf(".") + 1)
			.toLowerCase();
	if ((rightFile.toLowerCase().contains(extendName))
			|| (filePath.toLowerCase().contains("log"))) {
		if (!openFile.toLowerCase().contains(extendName)) {
			response.setContentType("application/" + extendName);
			response.setHeader("Content-disposition",
					"attachment;filename=" + fileName);
		}
//		System.out.println(filePath);
		File my_file = new File(filePath);

         // This should send the file to browser
         OutputStream out;
		try {
			byte[] buffer = new byte[4096];
			int length;
			out = response.getOutputStream();
			FileInputStream in = new FileInputStream(my_file);
			while ((length = in.read(buffer)) > 0){
				out.write(buffer, 0, length);
			}
			in.close();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else {
		try {
			response.sendRedirect("/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
