package com.inovisionsoftware.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.EncodingException;
 
public final class RequestWrapper extends HttpServletRequestWrapper {
 
    public RequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }
 
    public String[] getParameterValues(String parameter) {
 
      String[] values = super.getParameterValues(parameter);
      if (values==null)  {
                  return null;
          }
      int count = values.length;
      String[] encodedValues = new String[count];
      for (int i = 0; i < count; i++) {
                 encodedValues[i] = cleanXSS(values[i]);
       }
      return encodedValues;
    }
 
    public String getParameter(String parameter) {
          String value = super.getParameter(parameter);
          if (value == null) {
                 return null;
                  }
          return cleanXSS(value);
    }
 
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null)
            return null;
        return cleanXSS(value);
 
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