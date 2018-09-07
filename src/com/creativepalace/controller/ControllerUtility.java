package com.creativepalace.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.Part;

public class ControllerUtility {
	public String uploadFile(final Logger LOGGER, final String path, final Part filePart) throws IOException {
		final String fileName = getFileName(LOGGER, filePart);

		String returnFile = null;
		OutputStream out = null;
		InputStream fileContent = null;
		try {
			out = new FileOutputStream(new File(path + File.pathSeparator + fileName));
			fileContent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = fileContent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", new Object[] { fileName, path });
			returnFile = fileName;
		} catch (FileNotFoundException fne) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
					new Object[]{fne.getMessage()});
			fne.printStackTrace();
			returnFile = null;
		} finally {
			if (out != null) {
				out.close();
			}
			if (fileContent != null) {
				fileContent.close();
			}
		}
		return returnFile;
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
}
