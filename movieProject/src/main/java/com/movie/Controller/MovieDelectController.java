package com.movie.Controller;

import com.movie.movieDAO.MovieContentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Movie/Delete.do")
public class MovieDelectController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contentNum = req.getParameter("content_num");
        String userIndex = req.getParameter("user_index");
        String movieId = req.getParameter("movie_id");

        System.out.println("contentNum::"+contentNum+"\tuserIndex::"+userIndex+"\tmovie_id"+movieId);

        MovieContentDAO dalDao = new MovieContentDAO();

        int result = dalDao.contentDelete(contentNum,userIndex);
        dalDao.dbClose();

        if(result == 1){
            resp.sendRedirect("/Movie/MyPage.do?="+movieId);
        }
        else{
        }

    }

}
