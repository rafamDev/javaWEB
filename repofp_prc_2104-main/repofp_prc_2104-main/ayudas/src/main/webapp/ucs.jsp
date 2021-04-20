<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="./assets/xestions.css">
<title>AXUDAS</title>
</head>
<body>

<jsp:include page="/cabecera.jsp"><jsp:param name="seccion" value="UCSbbb!vvvv" /></jsp:include>
<jsp:include page="/menu.jsp"><jsp:param name="seccion" value="ucs" /></jsp:include>
<h1>VISTA UCSSSSdddd33!!</h1>

<div class="panleft"> IIII jsp panel izquierda</div>
<div class="box">
<div class="panDat">

<% 
if(null != request.getAttribute("err_msg")){
%>
<h3><%=request.getAttribute("err_msg")%> </h3>

<% } else { %>


	<table>
		<thead>
			<tr>
				<th>UCS</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${datos}">
				<tr>
					<td>${item}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tfoot>
	</table>

<% } %>

</div>
<div class="panright"> DDDD jsp panel derecha</div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>