<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String userName = request.getParameter("name");
// request -> implicit request object
// session -> implicit session object 
// application -> implicit context object
// pageContext -> this attribute exists only in JSP(Can be used to set the scope of an attribute to session, context or request scope)
if (userName != null) {
	session.setAttribute("sessionUserName", userName);
	//application.setAttribute("contextUserName", userName);
	pageContext.setAttribute("pageContextUserName", userName);
	pageContext.setAttribute("contextUserName", userName, PageContext.APPLICATION_SCOPE);
}

%>

<br>
Username in request object is: <%=userName %>
<br>
Username in session object is: <%=session.getAttribute("sessionUserName") %>
<br>
Username in context object is: <%=application.getAttribute("contextUserName") %> 
<br>
Username in page context object is: <%=pageContext.getAttribute("pageContextUserName") %>

</body>
</html>