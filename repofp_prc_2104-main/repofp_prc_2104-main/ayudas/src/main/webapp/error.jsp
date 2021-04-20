<%@ page language="java" isErrorPage="true" errorPage="/errorhandler" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>

<h1>ERROR PAGE</h1>
<br/>
<br/>
<h3>
errr_msg: <%=null != request.getAttribute("err_msg") ? request.getAttribute("err_msg"):"" %>
</h3>

<h3>
exception: <%=null != exception ? exception.getLocalizedMessage():""%>
</h3>


<%

Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
String servletName = (String) request.getAttribute("jakarta.servlet.error.servlet_name");
Throwable throwable = (Throwable) request.getAttribute("jakarta.servlet.error.exception");
String requestUri = (String) request.getAttribute("jakarta.servlet.error.request_uri");

%>

<h3>
statusCode: <%=null != statusCode ? statusCode :"" %>
</h3>

<h3>
servletName: <%=null != servletName ? servletName:"" %>
</h3>

<h3>
requestUri: <%=null !=  requestUri ?  requestUri:"" %>
</h3>



</body>
</html>