package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Post방식 요청의 경우 값을 뽑기 전에 UTF-8방식으로 인코딩을 변경해줘야 함.
				// Post의 기본 인코딩 설정은 ISO-8859-1
				request.setCharacterEncoding("UTF-8");
				
				String name = request.getParameter("name"); 	// "홍길동", ""
				String gender = request.getParameter("gender");	// "M" / "F" / NULL
				int age = Integer.parseInt(request.getParameter("age"));	// 값이 null이면 에러발생함
				// 무조건 문자열 형태로만 전달되기 때문에 형변환 해줘야 함.			null을 int로 형변환할 수 없기때문
				
				String city = request.getParameter("city");
				double height = Double.parseDouble(request.getParameter("height"));
				
				// 체크박스처럼 여러개의 정보를 동일한 키값으로 전달받는 경우 반드시 배열형태로 받아야 한다.
				String[] foods = request.getParameterValues("food");	
				
				/*
					요청처리 : Service - DAO - SQL문 실행
					
					위의 요청처리를 다 했다는 가정하에 사용자가 보게될 응답페이지 출력
					
					- 순수 Servlet : Java코드 내에 html코드를 작성
					- JSP(Java Server Page) : html내에 Java코드를 쓸 수 있는 기술
					
					응답페이지 만드는 과정을 JSP에게 위임(forward)
					단, 응답화면에서 필요로 하는 데이터들을 꾸미기 위해 JSP에게 필요한 데이터를 넘겨줘야 함.
					=> request에 attribute영역에 담아서 보내준다.
						(attribute는 Object이기 때문에 모든 자료형을 받아준다)
				*/
				
				// request.setAttribute("키"(String), "밸류"(Object));
				request.setAttribute("name", name);
				request.setAttribute("gender", gender);
				request.setAttribute("age", age);
				request.setAttribute("city", city);
				request.setAttribute("height", height);
				request.setAttribute("foods", foods);
				
				// 위임시 필요한 객체
				// 1) 응답하고자 하는 뷰를 선택하면서 RequestDispatcher객체 생성
				RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
				
				// 2) 포워딩
				view.forward(request, response);
	}

}
