package controller;

import model.vo.CountVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * [서버가 수행되는 동안 모든 클라이언트에 의해 공유되는 객체 예제]
 * 목적: 웹 클라이언트로부터 요청된 Servlet 을 "서버가 종료될 때까지" 유지하려는 목적, 모든 클라이언트로부터 공유하려는 목적
 * 방법:
 *     1) 모델 객체를 통해 수행된 결과를 VO 객체로 생성
 *     2) String, Integer 등 데이터 객체 혹은 배열 생성
 *
 * 메모: 서버에 등록되는 컨텍스트(웹 어플리케이션)당 하나 씩 만들어지는 ServletContext 객체에 공유 객체를 보관해서 서버 종료 시까지 해당 객체를 사용 가능! + 이 공유 객체는 "모든 클라이언트"에 공유!
 * 메모: Servlet 에서는 ServletContext 객체에 setAttribute() 메서드로 데이터 저장
 * 메모: JSP 에서는 application 이라는 내장 객체 변수를 사용해서 ServletContext 객체의 getAttribute() 메서드로 추출하거나 JSP의 표준 액션태그, EL표현식으로 추출한다.
 */
@WebServlet("/applicationshare")
public class ShareObjectApplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tomcat 이 구동되거나 리로드될 때 생성된 ServletContext 객체를 추출
        ServletContext context = getServletContext();
        if (context.getAttribute("applicationobj") == null) {
            context.setAttribute("applicationobj", new CountVO());
        }

        CountVO vo = (CountVO) context.getAttribute("applicationobj");
        vo.setNumber(10);
        request.getRequestDispatcher("/WEB-INF/view/applicationView.jsp").forward(request, response);
    }
}
