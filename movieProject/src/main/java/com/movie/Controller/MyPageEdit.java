package com.movie.Controller;

import com.movie.movieDAO.JDBCConnect;
import com.movie.movieDAO.MovieContentDAO;
import com.movie.movieDTO.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("Movie/MyEdit.do")
public class MyPageEdit extends JDBCConnect {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
}
