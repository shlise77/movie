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
        String movieId = req.getParameter("movieId");
        HttpSession session = req.getSession();
        session.setAttribute("movieId",movieId);

        // 조인된 화면 뿌리기
        MovieContentDAO contentDao = new MovieContentDAO();



        req.getRequestDispatcher("/mypage/MyReadPage.jsp").forward(req,resp);

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{}
}
