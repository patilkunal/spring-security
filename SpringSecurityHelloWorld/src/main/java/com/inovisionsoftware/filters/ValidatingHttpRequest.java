package com.inovisionsoftware.filters;

import java.text.Normalizer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.owasp.esapi.errors.ValidationException;

public class ValidatingHttpRequest extends HttpServletRequestWrapper {
	   
    public ValidatingHttpRequest(HttpServletRequest request) {

        super(request);
    }

    public String getParameter(String name) {

        HttpServletRequest req = (HttpServletRequest) super.getRequest();
        try {
			return validate( name, req.getParameter( name ) );
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    // Danger - you can optionally allow getting the raw parameter
    public String getRawParameter( String name ) {

        HttpServletRequest req = (HttpServletRequest) super.getRequest();
        return req.getParameter( name );
    }

   // ... follow this pattern for getHeader(), getCookie(), etc...  
   // ... specifically don´t forget getParameterValues() as this is used by frameworks like Struts to get the parameter values     
    //... Struts2 uses getParameterMap() to get the parameter values. Below is the sample way how to validate that.

    public Map<String, String[]> getParameterMap() {

        Map<String, String[]> map = super.getParameterMap();
        
        Iterator iterator = map.keySet().iterator();
        
        Map<String, String[]> newMap = new LinkedHashMap<String, String[]>();
        
        while (iterator.hasNext()) {
        
            String key = iterator.next().toString();

            String []values = map.get(key);
            String []newValues = new String[values.length];

            for(int i = 0; i < values.length; i++){
            
                try {
					newValues[i] = validate(key, values[i]);
				} catch (ValidationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Apply validation logic to the value
            }

            newMap.put(key, newValues);
        }
        return newMap;
    }
    
    @Override
    public String[] getParameterValues(String name) {
    	// TODO Auto-generated method stub
    	return super.getParameterValues(name);
    }

    // This is a VERY restrictive pattern alphanumeric < 20 chars
    // It's easy to make this a parameter for the filter and configure in web.xml
    private Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{0,20}$");

    private String validate( String name, String input ) throws ValidationException {

        // important - always canonicalize before validating
        String canonical = canonicalize( input );

        // check to see if input matches whitelist character set
        if ( !pattern.matcher( canonical ).matches() ) {
        
            throw new ValidationException( "Improper format in " + name + " field", "Improper format in " + name + " field");
        }

        // you could html entity encode input, but it's probably better to do this before output
        // canonical = HTMLEntityEncode( canonical );

        return canonical;
    }

    // Simplifies input to its simplest form to make encoding tricks more difficult
    private String canonicalize( String input ) {

        String canonical = Normalizer.normalize( input, Normalizer.Form.NFD);
        return canonical;
    }
    
    //--A.in.the.k 08:57, 19 March 2009 (UTC) for correct implementation see http://www.owasp.org/index.php/How_to_perform_HTML_entity_encoding_in_Java
    // Return HTML Entity code equivalents for any special characters
    public static String HTMLEntityEncode( String input ) {

        StringBuffer sb = new StringBuffer();
        
        for ( int i = 0; i < input.length(); ++i ) {
        
            char ch = input.charAt( i );
            
            if ( ch>='a' && ch<='z' || ch>='A' && ch<='Z' || ch>='0' && ch<='9' ) {
                sb.append( ch );
            } else {
                sb.append( "&#" + (int)ch + ";" );
            }
        }
        return sb.toString();
    }
}
