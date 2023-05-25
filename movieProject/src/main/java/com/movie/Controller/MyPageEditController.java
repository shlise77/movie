package com.movie.Controller;

import com.movie.movieDAO.MovieContentDAO;
import com.movie.movieDTO.ContentDTO;
import com.movie.movieDTO.LoginDTO;
import com.movie.movieDTO.ReadJoinDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Movie/MyEdit.do")
public class MyPageEditController extends HttpServlet {
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

        // 1. 화면 뿌리기
        MovieContentDAO contentDao = new MovieContentDAO();
        ReadJoinDTO readDto = contentDao.readUser(userIndex,contentNum);
        contentDao.dbClose();
        req.setAttribute("readDto",readDto);

        // 2. 수정 하기(update) 완료하기

        // 2. 수정 완료되면

        req.getRequestDispatcher("/mypage/MyEditPage.jsp").forward(req,resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String movieId = req.getParameter("movieId");

        ContentDTO updateDto = new ContentDTO();
        updateDto.setContent_title(req.getParameter("contentTitle"));
        updateDto.setContent(req.getParameter("content"));
        updateDto.setGenre(req.getParameter("genre"));
        updateDto.setUser_index(Integer.parseInt(req.getParameter("movieIndex")));
        updateDto.setContent_num(Integer.parseInt(req.getParameter("content_num")));

        MovieContentDAO updateContentDao = new MovieContentDAO();
        int result = updateContentDao.contentUpdate(updateDto);
        updateContentDao.dbClose();
        if(result == 1){
            resp.sendRedirect("/Movie/MyPage.do?movieId="+movieId);
        }
        else{
            resp.sendRedirect("/Movie/MyPage.do?="+movieId);
        }
    }
}
