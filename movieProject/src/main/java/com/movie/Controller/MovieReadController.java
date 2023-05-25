package com.movie.Controller;

import com.movie.movieDAO.LoginDAO;
import com.movie.movieDAO.MovieContentDAO;
import com.movie.movieDTO.ContentDTO;
import com.movie.movieDTO.LoginDTO;
import com.movie.movieDTO.ReadJoinDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Movie/Read.do")
public class MovieReadController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 기본
        String movieId = req.getParameter("movieId");
        String userIndex = req.getParameter("userIndex");
        String contentNum = req.getParameter("contentNum");
        HttpSession session = req.getSession();
        System.out.println("movieId"+movieId+"userIndex"+userIndex);
        session.setAttribute("movieId",movieId);

        MovieContentDAO headlist = new MovieContentDAO();
        LoginDTO userInfo = headlist.selectUserContent(movieId);
        headlist.dbClose();
        req.setAttribute("userInfo",userInfo);
        // 여기까지가 기본
        
        // 조인된 화면 뿌리기
        MovieContentDAO contentDao = new MovieContentDAO();
        ReadJoinDTO readDto = contentDao.readUser(userIndex,contentNum);
        contentDao.dbClose();
        req.setAttribute("readDto",readDto);


        req.getRequestDispatcher("/mypage/MyReadPage.jsp").forward(req,resp);

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{}
}
