package com.creativepalace.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class AbstractServlet extends HttpServlet {
	/**
	 * @author aungkhant94
	 */
	private static final long serialVersionUID = 1999551859217110407L;
	private String header;
	private String footer;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String bodyFilePath;
	private String headerFilePath;
	private String footerFilePath;
	private Map<String, Object> viewObject;
	private PrintWriter printWriter;
	private Map<String, List<String>> loopStringMap;
	private boolean isInLoopStatus;
	private boolean isInConditionStatus;
	private Boolean conditionValue;
	private String lastAddedKey;
	
	protected void setHeader(String filePath) {
		headerFilePath = filePath;
	}

	private void getHeader() throws Exception {
		this.addViewObject("baseUrl", getBaseUrl(request));
		response.setContentType("text/html");
		String filename = null;
		if (headerFilePath == null) {
			filename = "/header";
		} else {
			filename = "/"+headerFilePath;
		}
		getFileAndWrite(filename);
	}

	private void getFooter() throws Exception {
		String filename = null;
		if (footerFilePath == null) {
			filename = "/footer";
		} else {
			filename = "/"+footerFilePath;
		}
		getFileAndWrite(filename);
	}
	private void getFileAndWrite(String fileName) throws Exception{
		fileName = "/"+fileName+".ak";
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream(fileName);
		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);

			String text;
			while ((text = reader.readLine()) != null) {
				substitudeAndWrite(text);
			}
			reader.close();
			isr.close();
		}
		is.close();
	}
	protected void setBody(String filePath) {
		bodyFilePath = filePath;
	}

	private void getBody() throws Exception{
		String filename;
		if (bodyFilePath != null) {
			 filename= bodyFilePath;
			
		}else{
			filename = getCurrentPath(request);
			
		}
		getFileAndWrite(filename);
	}

	protected String getCssPath(HttpServletRequest request) {
		return getBaseUrl(request) + "/style.css";

	}
	protected String getCurrentPath(HttpServletRequest request){
		String uri = request.getRequestURI();
		uri = uri.replace(request.getContextPath()+"/", "");
		uri = new StringBuilder(uri).reverse().toString();
		if(uri.contains(".")){
		int dotPoint = uri.indexOf(".")+1;
		String regex = uri.substring(0, dotPoint);
		uri = uri.replace(regex, "");
		}
		uri = new StringBuilder(uri).reverse().toString();
		return uri;
	}
	
	protected String getBaseUrl(HttpServletRequest request) {
		String baseUrl;
		if (request.getServerPort() != 80) {
			baseUrl = "http://" + request.getServerName() + ":"
					+ request.getServerPort() + "" + request.getContextPath();
		} else {
			baseUrl = "http://" + request.getServerName() + ""
					+ request.getContextPath();
		}
		return baseUrl;
	}

	private void substitudeAndWrite(String text) throws Exception {
		String listKeyWord = "#akStartLoop{";
		String endKeyWord = "#akEndLoop{";
		String itemKeyWord = "#akLoopItem{";
		
		if (printWriter == null) {
			printWriter = response.getWriter();
		}
		text = substitude(text);
		if(text.contains(listKeyWord) || isInLoopStatus){
			writeForCollection(text);
		}else{
			
			printWriter.println(writeCondition(text));
		}
	}
	
	private String writeCondition(String text){
		String returnText = "";
		String conKey = "#if(";
		String elseKey = "#else";
		String endKey = "#endIf";
		if(text.contains(conKey)){
			isInConditionStatus = true;
			int startPoint = text.indexOf(conKey)+4;
			int endPoint = text.indexOf(")");
			String conValue = text.substring(startPoint, endPoint);
			
			if(conValue.equals("true")){
				this.conditionValue  = true;
			}else if(conValue.equals("false")){
				this.conditionValue = false;
			}else{
				this.conditionValue = null;
				isInConditionStatus = false;
				returnText = text;
				
			}
		}else if(text.contains(elseKey)){
			if(isInConditionStatus && this.conditionValue==false){
				this.conditionValue = true;
			}else{
				this.conditionValue = false;
			}
			
		}else if(text.contains(endKey)){
			
			isInConditionStatus = false;
			this.conditionValue = null;
		}else {
			if(this.isInConditionStatus==true && this.conditionValue==true){
				returnText = text;
			}
			if(!isInConditionStatus && this.conditionValue==null){
				returnText = text;
			}
		}
		
		return returnText;
	}
	private String substitude(String text){
		String keyWord = "#agkt{";
		if (text.contains(keyWord)) {
			int startPoint = text.indexOf(keyWord) + 6;
			int endPoint = text.indexOf("}");
			String key = text.substring(startPoint, endPoint);
			Object obj = viewObject.get(key);
			String regexString = keyWord + key + "}";
			if (obj instanceof String) {
				String value = (String) obj;
				
				text = text.replace(regexString, value);
			}else{
				
				
				text = text.replace(regexString, obj.toString());
			}
		}
		return text;
	}
	
	private void writeForCollection(String text) throws Exception{
		if(loopStringMap == null){
			loopStringMap = new HashMap<String, List<String>>();
		}
		
		String startKeyWord = "#akStartLoop{";
		String endKeyWord = "#akEndLoop{";
		String itemKeyWord = "#akLoopItem{";
		String key=null;
		this.isInLoopStatus = true;
		if(text.contains(startKeyWord)){
			int startPoint = text.indexOf(startKeyWord)+13;
			int endPoint = text.indexOf("}");
			key = text.substring(startPoint, endPoint);
				if(loopStringMap.get(key)==null){
					loopStringMap.put(key, new ArrayList<String>());
				}
				lastAddedKey = key;
			loopStringMap.get(key).add(text);
			
		}else if(text.contains(itemKeyWord)){
			int startPoint = text.indexOf(itemKeyWord)+12;
			int endPoint = text.indexOf("[");
			key = text.substring(startPoint, endPoint);
			lastAddedKey = key;
			loopStringMap.get(key).add(text);
			
		}else if(text.contains(endKeyWord)){
			
			int startPoint = text.indexOf(endKeyWord)+11;
			int endPoint = text.indexOf("}");
			key = text.substring(startPoint, endPoint);
			lastAddedKey = key;
			Object obj = viewObject.get(key);
			if(obj instanceof List<?>){
				List<?> list = (List<?>)obj;
				for(Object o : list){
					for(String str: loopStringMap.get(key)){
						if(str.contains(startKeyWord+key+"}")){
							str = str.replace(startKeyWord+key+"}","");
						}
						if(str.contains(endKeyWord)){
							str = str.replace(endKeyWord+key+"}", "");
						}
						if(str.contains(itemKeyWord)){
							int itemKeyStartPoint  = str.indexOf(itemKeyWord)+13+key.length();
							int itemKeyEndPoint = str.indexOf("]}");
							String itemKey = str.substring(itemKeyStartPoint, itemKeyEndPoint);
							Field field = o.getClass().getDeclaredField(itemKey);

							Class<?> type = boolean.class;
							String prefix = "get";
							if(field.getType().isAssignableFrom(type)){
								prefix = "is";
							}
							String methodNameKey =  itemKey.substring(0, 1).toUpperCase() + itemKey.substring(1);
							
							Method method = o.getClass().getDeclaredMethod(prefix+methodNameKey);
							
							str = str.replace(itemKeyWord+key+"["+itemKey+"]"+"}",method.invoke(o).toString());
							
						}
						printWriter.println(writeCondition(str));
					}
				}
				
			}
			isInLoopStatus = false;
			loopStringMap.remove(key);
		}else{
			loopStringMap.get(lastAddedKey).add(text);
		}
	}
	

	protected void addViewObject(String key, Object object) {
		if (viewObject == null) {
			viewObject = new HashMap<String, Object>();
		}
		viewObject.put(key, object);

	}

	protected void showView(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		this.request = request;
		this.response = response;
		getHeader();
		getBody();
		getFooter();
	}
	
	public abstract void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public abstract void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	
	protected void handleException(HttpServletResponse response,Exception e){
		if(this.response == null){
			this.response = response;
		}
		try {
			if(printWriter==null){
				this.printWriter = this.response.getWriter();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally{
			e.printStackTrace(printWriter);
		}
		
	}
	
	protected void addRedirectAttribute(HttpServletRequest request,Object o){
		HttpSession session = request.getSession();
		session.setAttribute("redirectAttribute", o);
	}
	
	protected Object getRedirectAttribute(HttpServletRequest request){
		HttpSession session = request.getSession();
		return session.getAttribute("redirectAttribute");
	}
	
	
	protected void redirect(HttpServletResponse response,String url) throws Exception{
		this.response = response;
		response.sendRedirect(url);
		//response.encodeRedirectURL("redirect.hello");
	}

	protected HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
}
