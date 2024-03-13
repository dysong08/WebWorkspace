package com.kh.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test1.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("잘 실행 되나 ..?");
		/*
		 * Get방식으로 요청했으면 현재 doGet가 호출됨
		 *
		 * 첫번째 매개변수인 HttpServletRequest request에는 요청시 클라이언트가 전달한 내용들이 담긴다.
		 * (입력한 값, 전송방식, 요청한 사용자의 ip, 쿠키정보, session등등..)
		 *
		 * 우선, 요청을 처리하기 위해 요청시 전달된 값들을 뽑는다
		 * request의 parameter영역 안에 존재 -> 데이터들은 key value 세트로 담겨있다.
		 *
		 * 따라서 request의 parameter 영역으로부터 전달된 데이터를 뽑는 메소드를 사용할건데
		 * - request.getParameter("키값") : String => 무조건 문자열 자료형으로 반환
		 * - request.getParameterValues("키값") : String[] => 무조건 문자열 배열형태로 반환
		 */
		
		String name = request.getParameter("name"); // "민경민" , ""
		String gender = request.getParameter("gender"); // "M" / "F" 선택안한 경우 NULL
		int age = Integer.parseInt(request.getParameter("age")); // 무조건 문자열 형태로만
		// 전달되기 때문에 형변환 해줘야함.
		
		String city = request.getParameter("city");
		double height = Double.parseDouble(request.getParameter("height"));
		
		// 체크박스처럼 여러개의 정보를 동일한 키값으로 전달받는 경우
		// 반드시 배열형태로 받아야한다.
		String[] foods = request.getParameterValues("food");// 체크박스를 하나도 선택하지 않는다면 null값 반환
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		
		if(foods == null) {
			System.out.println("foods : 없음");
		} else {
			System.out.println("foods : " + String.join(",", foods));
		}
		/*
		 * db와 상호작용후 결과값을 토대로 사용자가 보게될 화면을 꾸며준다.(일반적인 흐름)
		 *
		 * 사용자가 보게될 응답페이지 만들기
		 *
		 *
		 */
	
	// * response객체를 통해 사용자에게 html(응답화면)을 전달
	
	// 1) 출력할 내용은 문서형태의 html파일이고, 문자셋은 utf-8 임을 지정
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) 응답하고자 하는 사용자와의 스트림을 생성
		PrintWriter out =response.getWriter();
		
		// 3) 생성된 스트림을 통해 html구문을 출력
		out.println("<html>");
			out.println("<head>");
				out.println("<style>");
					out.println("h2{color:red}");
					out.println("#name{color:orange}");
					out.println("#age{color:yellow}");
					out.println("#city{color:green}");
					out.println("#height{color:blue}");
					out.println("#gender{color:navy}");					
				out.println("</style>");		
			out.println("</head>");
			out.println("<body>");
				out.println("<h2>개인정보 응답 화면</h2>");
				out.println("<span id='name'>"+name+"</span>님은");
				out.printf("<span id='age'> %d </span> 살이며", age);
				out.printf("<span id='city'> %s </span>에 사는", city);
				out.printf("<span id='height'> %.1f </span>cm 이고", height);
				out.print("성별은 ");
				if(gender == null) {
					out.print("선택을 안했습니다. <br>");
				}else {
					out.printf("<span id='gender'>%s</span> 입니다.", gender.equals("M") ? "남자" : "여자"   );
				}
				
				out.print("<br>좋아하는 음식은 ");
				
				if(foods == null) {
					out.print("없습니다.");
				}else {
					out.print("<ul>");
					
					for(String food : foods) {
						out.printf("<li>%s</li>", food);
					}
					out.print("</ul>");
				}
			out.println("</body>");
		out.println("</html>");

	/*
	 * 장점: java 코드 내에서 작성을 하기 때문에 자바에서 활용가능한 다양한 api를 사용하여 html 코드를 만들 수 있다.
	 *
	 * 단점: 복잡하고, 혹시라도 html페이지를 수정하고자 할때 java코드 내에서 수정이 이루어지기 때문에
	 * 		수정된 내용을 다시 반영하고자 한다면 서버를 재실행해야한다.
	 *
	 */
	
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}