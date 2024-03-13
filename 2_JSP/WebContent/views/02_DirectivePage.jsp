<%@ page import="java.util.ArrayList, java.util.Date" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error500.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>page 지시어</h1>
	
	<% 
		// ArrayList 사용
		// 지시어 부분에 "import="java.util.ArrayList"를 반드시 추가해야 한다.
		ArrayList<String> list = new ArrayList<>();
		list.add("Servlet");
		list.add("JSP");
		
		Date today = new Date();
		
		// 추가하지 않은 클래스 사용시 에러발생함
		//HashMap map = new HashMap();
	%>


	<p>
		리스트의 길이 : <%= list.size() %> <br>
		0번 인덱스의 값 : <%= list.get(0) %> <br>
		현재 날짜 및 시간 : <%= today %>
	</p>

	<%-- 
	<%= list.get(10) %>

	--%>






</body>
</html>