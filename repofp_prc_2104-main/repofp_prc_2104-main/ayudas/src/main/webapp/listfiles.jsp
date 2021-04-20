<%@page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.io.File"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="LocalStrings" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Un exemplo - Lista Ficheiros</title>
</head>
<body>

	<h1>Un exemplo - Lista Ficheiros</h1>
	
	
<br/>
<c:out value="Esta mensaxe 'pintase' con un tag jstl"/>
<br/>

O ContextPath é: <%=request.getContextPath()%>

<br/>&nbsp;
<br/>&nbsp;


<%
// un fragmento de código java
final String ROOT_FILE_PATH="D:\\listaFicherosFpDual";
%>


<h3>Pintamos unha taboa cos ficheiros en: <%=ROOT_FILE_PATH%> </h3>
	
	<hr/>

	<form>

		<select id="language" name="language" onchange="submit()">
			<option value="ar" ${language == 'ar' ? 'selected' : ''}>Árabe</option>
			<option value="ar_DZ" ${language == 'ar_DZ' ? 'selected' : ''}>Árabe Argelia</option>
			<option value="gl" ${language == 'gl' ? 'selected' : ''}>Galego</option>
			<option value="en" ${language == 'en' ? 'selected' : ''}>Inglés</option>
			<option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>			
		</select>&nbsp;&nbsp;&nbsp; <b ${(language == 'ar') ?'dir="rtl" align="right" lang="ar"':''}><fmt:message key="keyMsgInternacionalizado" /></b><!-- dir="rtl" lang="ar" -->

	</form>



	<br />&nbsp;
	<br />&nbsp;


	<table>
		<thead>
			<tr>
				<th>Files</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${lFiles}">
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



</body>
</html>