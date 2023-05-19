package com.movie.Controller;

import com.movie.movieDAO.LoginDAO;
import com.movie.movieDTO.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Movie/LoginCheck.do")
public class MainMovieController extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 이곳은 로그인 확인 페이지
        LoginDTO movieDto = new LoginDTO();
        LoginDAO loginDao = new LoginDAO();
        loginDao.selectLoginMovie(movieDto);
        loginDao.dbClose();
    }
}
