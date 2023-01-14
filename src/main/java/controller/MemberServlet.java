package controller;

import model.service.EncDecService;
import model.vo.MemberVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/memberServlet")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 응답할 view의 경로 설정
        String uri = "/WEB-INF/view/memberView.jsp";

        // post 방식의 한글 인코딩 깨짐 해결 위한 설정
        request.setCharacterEncoding("utf-8");

        // view에 전달하기 위한 VO 에 값 설정
        MemberVO mvo = new MemberVO();
        mvo.setName(request.getParameter("name"));
        mvo.setPhoneNum(request.getParameter("phonenumber"));
        mvo.setId(request.getParameter("id"));
            String pwd = request.getParameter("passwd");
        System.out.println("pwd: " + pwd);
        String encPwd = EncDecService.encrypt(pwd);
            System.out.println("encPwd: " + encPwd);
        mvo.setPasswd(encPwd);
        request.setAttribute("membervo", mvo);
        request.getRequestDispatcher(uri).forward(request, response);
    }
}
