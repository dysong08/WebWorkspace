package pizza;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pizzaPostServlet
 */
@WebServlet("/pizzaOrder.do")
public class pizzaPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pizzaPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		
		String pizza = request.getParameter("pizza");
		String[] toppings = request.getParameterValues("topping");
		String[] sides = request.getParameterValues("side");
		
		
		request.setAttribute("pizza", pizza);
		request.setAttribute("toppings", toppings);
		request.setAttribute("sides", sides);
		
		
		// 가격계산 (보틍의 흐름 : DB에 SQL문 실행한 후 메뉴가격의 합산을 반환)
		
		int price = 0;
		switch(pizza) {
		
		case "치즈피자" : price += 5000; break;
		case "콤비네이션피자" : price += 6000; break;
		case "포테이토피자" : price += 7000; break;
		case "고구마피자" : price += 7000; break;
		case "불고기피자" : price += 8000; break;
		
		}
		
		
		
		if(toppings != null ){
			
			for(String topping : toppings){
				
				switch(topping) {
				case "고구마무스" : price += 1000; break;
				case "콘크림무스" : price += 1500; break;
				case "파인애플토핑" : price += 2000; break;
				case "치즈토핑" : price += 2000; break;
				case "치즈크러스트" : price += 2000; break;
				case "치즈바이트" : price += 3000; break;
				}
			}
		}
		
		
		if(sides != null) {
			
			for(String topping : toppings){
				
				switch(topping) {
				case "오븐구이통닭" : price += 9000; break;
				case "치킨스틱&윙" : price += 4900; break;
				case "치즈오븐스파케티" : price += 4000; break;
				case "새우링&웨지감자" : price += 3500; break;
				case "갈릭포테이토" : price += 3000; break;
				case "콜라" : price += 1500; break;
				case "사이다" : price += 1500; break;
				case "갈릭소스" : price += 500; break;
				case "피클" : price += 300; break;
				case "핫소스" : price += 100; break;
				case "파마산 치즈가루" : price += 100; break;
				}
			}
		}
		
		
		request.setAttribute("price", price);
		
		
		// 응답할 뷰 선택
		request.getRequestDispatcher("views/pizzaRequest.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
