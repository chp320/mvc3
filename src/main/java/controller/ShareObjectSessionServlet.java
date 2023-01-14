package controller;

import model.vo.CountVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * [세션이 유지되는 동안 클라이언트별 객체 공유 예제]
 * 목적: 웹 클라이언트로부터 요청된 Servlet 을 일정 시간동안 유지하려는 목적
 * 방법:
 *     1) 모델 객체를 통해 수행된 결과를 VO 객체로 생성
 *     2) String, Integer 등 데이터 객체 혹은 배열 생성
 * 메모: 클라이언트별로 서버에 하나씩 만들어지는 HttpSession 객체에 공유할 객체를 보관한다. (세션 유지되는 동안 사용 가능)
 * 메모: Servlet 에서는 HttpSession 객체에 setAttribute() 메서드로 데이터 저장
 * 메모: JSP 에서는 session 이라는 내장 객체 변수를 사용해서 HttpSession 객체의 getAttribute() 메서드로 추출하거나 JSP의 표준 액션태그, EL표현식으로 추출한다.
 */
@WebServlet("/sessionshare")
public class ShareObjectSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); // HttpSession 객체를 추출하거나 생성 -> 이를 통해 한 번 생성 후, 계속해서 사용 가능함! (request scope의 경우, 요청 시마다 새로 생성되기 때문에 재사용 불가!)
        if (session.getAttribute("sessionobj") == null) {
            session.setAttribute("sessionobj", new CountVO());
        }

        CountVO vo = (CountVO) session.getAttribute("sessionobj");
        vo.setNumber(10);
        request.getRequestDispatcher("/WEB-INF/view/sessionView.jsp").forward(request, response);
    }
}
