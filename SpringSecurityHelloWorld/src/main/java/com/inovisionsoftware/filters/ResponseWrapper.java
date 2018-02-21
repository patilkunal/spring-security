package com.inovisionsoftware.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.EncodingException;

public class ResponseWrapper extends HttpServletResponseWrapper{

	public ResponseWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ServletResponse getResponse() {
		ServletResponse response = super.getResponse();
		try {
			PrintWriter out = response.getWriter();
			System.out.println(" response details is "+out.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return super.getResponse();
	}
	
	
	
	
	private String cleanXSS(String value) {

		//StringEscapeUtils.escapeHtml4(value);
		System.out.println("value1 in filter is " + value);
		String safe = ESAPI.encoder().encodeForHTML(value);
		safe = ESAPI.encoder().encodeForHTMLAttribute(safe);
		safe = ESAPI.encoder().encodeForJavaScript(safe);
		safe = ESAPI.encoder().encodeForCSS(value);
		 try {
			safe = ESAPI.encoder().encodeForURL(safe);
		} catch (EncodingException e) {
			e.printStackTrace();
		}
		
		// You'll need to remove the spaces from the html entities below
		/*
		 * value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		 * value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;"
		 * ); value = value.replaceAll("'", "& #39;"); value =
		 * value.replaceAll("eval\\((.*)\\)", ""); value =
		 * value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
		 * "\"\""); value = value.replaceAll("script", "");
		 */
		System.out.println("value2 in filter is " + safe);
		return safe;
	}

}
