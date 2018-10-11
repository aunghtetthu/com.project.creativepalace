package com.creativepalace.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ControllerUtility {
	private String rootPath = System.getProperty("catalina.home");
	
	public String uploadFile(final Logger LOGGER, final String destination, final Part filePart, HttpServletRequest request) throws IOException {
//		final String path = rootPath + File.separator + destination + File.separator;
		final String path = request.getServletContext().getRealPath(File.separator) + destination + File.separator;
		final String fileName = getFileName(LOGGER, filePart);
		OutputStream out = null;
		InputStream fileContent = null;
		try {
//			out = new FileOutputStream(new File(path + File.pathSeparator + fileName));
			out = new FileOutputStream(new File(path + fileName));
			fileContent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = fileContent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", new Object[] { fileName, path });
		} catch (FileNotFoundException fne) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
					new Object[]{fne.getMessage()});
			fne.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			if (fileContent != null) {
				fileContent.close();
			}
		}
		return fileName;
	}
	
	private String getFileName(final Logger LOGGER, final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		String fileName = null;
		LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			} 
		}
		return fileName;
	}

//	public String fileUpload(String path, HttpServletRequest request) {
//		String fileName = null;
//
//		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
//		File fileDir = new File(rootPath + File.separator + path);
//		fileFactory.setRepository(fileDir);
//
//		ServletFileUpload upload = new ServletFileUpload(fileFactory);
//		try {
//			List fileItems = upload.parseRequest(request);
//			Iterator fileItemIterator = fileItems.iterator();
//			while (fileItemIterator.hasNext()) {
//				FileItem fileItem = (FileItem) fileItemIterator.next();
//				
//				File file = new File(rootPath + File.separator + path + File.separator + fileItem.getName());
//				fileItem.write(file);
//				fileName = fileItem.getName();
//			}
//		} catch (FileUploadException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return fileName;
//	}

	public void showAlertMessage(AbstractServlet obj, boolean success, String message, String locationAssign) {
		obj.addViewObject("success", success);
		obj.addViewObject("successMessage", message);
		obj.addViewObject("locationAssign", locationAssign);
	}
	
	public String fileLocation(String filePart, String folder, HttpServletRequest request) {
//		File file = new File(rootPath + File.separator + folder + File.separator + filePart);
		String baseUrl;
		if (request.getServerPort() != 80) {			
			baseUrl = "http://" + request.getServerName() + ":"
					+ request.getServerPort() + "" + request.getContextPath();
		} else {
			baseUrl = "http://" + request.getServerName() + ""
					+ request.getContextPath();
		}
		return baseUrl + File.separator + folder + File.separator + filePart;
	}
	
//	public boolean checkSession(HttpSession session, String sessionAttribute) {
//		if(session.getAttribute(sessionAttribute) != null) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	public String checkList(List list) {
		String listCount = "0";
		if(list == null) {
			listCount = "0";
		} else {
			listCount = Integer.toString(list.size());
		}
		return listCount;
	}
}
