<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>include 지시어</h1>
	
	<h2>01_ScriptingElement.jsp 파일 추가하기(include) </h2>
	
	<%@ include file="01_ScriptingElement.jsp" %>
	
	포함한 JSP상에 존재하는 변수를 가져다 쓸 수 있음 <br>
	1부터 10까지의 총 합계는 ? <%= sum %>
	
	
	<%-- 
	
	<% int sum = 0; %> 
	
	이미 01_ScriptingElement.jsp에서 sum을 썻기때문에 요류발생한다.
	--%>
	
	
	<h2>오늘날짜</h2>
	<%@ include file = "datePrint.jsp" %>
	
	
	
	
	
	
	
	
</body>
</html>