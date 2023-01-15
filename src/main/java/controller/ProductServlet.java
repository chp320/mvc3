package controller;

import model.vo.ProductVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * [ Session scope 기반의 객체 공유 (쇼핑카드 예제) ]
 * - HttpSession 객체를 통해서 서버 내 세션이 유지되는 동안 데이터를 공유할 수 있다.
 */
@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HttpSession 객체 생성
        HttpSession session = request.getSession();

        // parameter로 전달된 값 추출
        String pid = request.getParameter("pid");
        if (session.getAttribute("countnum") == null) {
            session.setAttribute("countnum", new ProductVO());
        }

        ProductVO pvo = (ProductVO) session.getAttribute("countnum");

        if ("p001".equals(pid)) {
            pvo.setApple(1);
        } else if ("p002".equals(pid)) {
            pvo.setBanana(1);
        } else if ("p003".equals(pid)) {
            pvo.setHallabong(1);
        } else {
            // 장바구니 비우기인 경우로.. 세션 내 객체 삭제
            session.removeAttribute("countnum");
        }

        // 화면 처리할 productView.jsp 로 forward
        request.getRequestDispatcher("/WEB-INF/view/productView.jsp").forward(request, response);
    }
}
