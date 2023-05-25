package com.movie.Controller;

import com.movie.movieDAO.LoginDAO;
import com.movie.movieDAO.MovieContentDAO;
import com.movie.movieDTO.ContentDTO;
import com.movie.movieDTO.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Movie/MyPage.do")
public class MyPageController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String movieId = req.getParameter("movieId");
        HttpSession session = req.getSession();
        session.setAttribute("movieId",movieId);

        MovieContentDAO contentDao = new MovieContentDAO();
        LoginDTO userInfo = contentDao.selectUserContent(movieId);
        contentDao.dbClose();
        req.setAttribute("userInfo",userInfo);

        // 리스트 구현
        MovieContentDAO contentListDao = new MovieContentDAO();
        List<ContentDTO> contentList = contentListDao.listContent();
        contentListDao.dbClose();
        req.setAttribute("contentList",contentList);


        req.getRequestDispatcher("/mypage/MyPage.jsp").forward(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    }
}
