package com.movie.Controller;

import com.movie.movieDAO.LoginDAO;
import com.movie.movieDTO.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Movie/Login.do")
public class MovieLoginController extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
        //1. 로그인은 정보가 남으면 안되서 post 방식으로 만들고
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDAO loginDao = new LoginDAO();
        String movieId = req.getParameter("movieId");
        LoginDTO userInfo = loginDao.selectLoginMovie(movieId);
        loginDao.dbClose();
        req.setAttribute("userInfo", userInfo);

        req.getRequestDispatcher("/movieMain.jsp").forward(req,resp);
    }
}
