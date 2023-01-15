package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        String op = request.getParameter("op");
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int result = 0 ;
        String uri = "/WEB-INF/view/calcResult.jsp";

        System.out.println("input: " + num1 + " " + op + " " + num2);

        if ("plus".equals(op)) {
            result = num1 + num2;
        } else if ("minus".equals(op)) {
            result = num1 - num2;
        } else if ("multiply".equals(op)) {
            result = num1 * num2;
        } else {
            // 나누기 연산 시, num2가 0인 경우 오류 처리
            if (num2 == 0) {
                request.setAttribute("msg", "나눗셈 연산 시 두 번째 숫자는 0일 수 없습니다!!");
                uri = "/WEB-INF/view/errorResult.jsp";
                request.getRequestDispatcher(uri).forward(request, response);
                return;
            } else {
                // 정상적인 나눗셈인 경우
                result = num1 / num2;
            }
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher(uri).forward(request, response);   // 결과 화면을 응답하는 calcResult.jsp 로 요청을 forward
    }
}
