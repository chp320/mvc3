package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/eduServlet")
public class EduServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST 방식의 경우 query 문자열을 추출하기 전, 한글 깨짐 문제 해결을 위함. 무조건 제일 먼저 설정해야함.
        request.setCharacterEncoding("utf-8");
        int scoreAvg = Integer.parseInt(request.getParameter("scoreavg"));
        String uri = "";

        // 점수에 따른 view 설정
        if (scoreAvg >= 90) {
            uri = "/WEB-INF/view/gradeA.jsp";
        } else if (scoreAvg >= 80) {
            uri = "/WEB-INF/view/gradeB.jsp";
        } else if (scoreAvg >= 70) {
            uri = "/WEB-INF/view/gradeC.jsp";
        } else {
            uri = "/WEB-INF/view/gradeD.jsp";
        }

        // view 이동
        request.getRequestDispatcher(uri).forward(request, response);
    }
}
