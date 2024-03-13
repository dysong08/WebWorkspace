<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- HTML 주석 : 개발자 도구 탭에 노츨 -->
	<%-- JSP 주석  : 개발자 도구 탭에 노출 X --%>

jSP 페이지에서 JAVA 코드를 기술할 수 있게 해주는 기능 

	<h1>스클립팅 원소</h1>
	
	<%
		// 스클립틀릿 : 이 안에 일반적인 자바코드를 작성(변수 선언 및 초기화, 제어문 등..)
		int sum = 0;
		for(int i = 1; i<=10; i++){
			sum += i;
		}
		System.out.println("덧셈 결과 : " + sum);
	%>
	
	<p>
		// 결과값을 화면에 출력한다면?  <br>
		스클립틀릿 : <% out.println(sum); %> <br>
		표현식(출력식) : <%= sum %> <br>
	</p>

	<%
		// 배열 사용
		String[] names = {"김말똥", "홍길동", "이순신", "김갑생"};
	
	%>

	<h5>배열의 길이 : <%= names.length %></h5>

	<%= names %> <br>
	<%= String.join(", ", names) %>
	
	
	<h4>반복문을 통해 html요소를 반복적으로 화면에 출력 가능</h4>
	
	<ul>
		<% for(int i = 0; i < names.length; i++) { %>
			<li><%= names[i] %></li>
			
		<% } %>
	</ul>
	
	











</body>
</html>