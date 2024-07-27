<%@ page import="utils.StringUtlis" %>

<%

	String userSession = (String) session.getAttribute(StringUtlis.USERNAME);
	String cookieUsername = null;
	String cookieSessionID = null;
	
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie:cookies){
			if(cookie.getName().equals(StringUtlis.USER)) cookieUsername = cookie.getValue();
		
			if(cookie.getName().equals(StringUtlis.JSESSIONID)) cookieSessionID = cookie.getValue();
		
		}
	}
%>