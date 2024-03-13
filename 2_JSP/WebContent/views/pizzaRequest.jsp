<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	span{font-weight:bold}
</style>
</head>
<body>
	
	<%
		String pizza = (String)request.getAttribute("pizza");
		String[] toppings = (String[])request.getAttribute("toppings");
		String[] sides = (String[])request.getAttribute("sides");
		int price = (int)request.getAttribute("price");
	
	%>
	
	
	
	<h2>주문 내역</h2>
	
	<h2>피자는 <span style='color:red'><%= pizza %></span></h2>
	
	
	<% 
	if(toppings != null) { %>
	, 토핑은
	<span style='color:green'>
		<%= String.join(",", toppings) %>
	</span>
	<% } %>
	
	
	<%--
	<% 
	if(toppings == null) {
		out.print("선택하지 않았으며");
	
	} else { 
		for(String topping : toppings){
			out.print("<span id=topping>" + topping + ", </span>");
		}
	}
	%>
	 --%>	
	 
	 
	, 사이드는
	<span style='color:blue'></span>
	<% 
	if(sides == null) {
		out.print("선택하지 않았습니다.");
	
	} else { 
		for(String side : sides){
			out.print("<span id=side>" + side + ", </span>");
		}
	}
	%>
	
	
	<span>주문하셨습니다.</span>
	
	
	
	
		 
		 
	

	
	<h2 style="color:pink">즐거운 식사시간 되세요 ~</h2>











</body>
</html>