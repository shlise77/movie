package com.movie.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Movie/MyPage.do")
public class MyPageController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //id 값 가져오기
        String movieId = req.getParameter("movieId");
        // 확인해보기
        System.out.println("movieId::"+movieId); // 확인 끝
        HttpSession session = req.getSession();
        session.setAttribute("movieId",movieId);
        req.getRequestDispatcher("/mypage/MyPage.jsp").forward(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{}
}
