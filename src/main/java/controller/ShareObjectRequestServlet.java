package controller;

import model.vo.CountVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/requestshare")
public class ShareObjectRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CountVO vo = new CountVO();
        vo.setNumber(10);
        request.setAttribute("requestobj", vo);
        request.getRequestDispatcher("/WEB-INF/view/requestView.jsp").forward(request, response);
    }
}
