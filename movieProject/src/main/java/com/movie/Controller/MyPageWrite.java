package com.movie.Controller;

import com.movie.movieDAO.MovieContentDAO;
import com.movie.movieDTO.ContentDTO;
import com.movie.movieDTO.LoginDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Movie/Write.do")
public class MyPageWrite extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String movieId = req.getParameter("movieId");
        //      세션 부분       //
        HttpSession session = req.getSession();
        session.setAttribute("movieId",movieId);
        //      회원 정보 부분 //
        MovieContentDAO contentDao = new MovieContentDAO();
        LoginDTO userInfo = contentDao.selectUserContent(movieId);
        contentDao.dbClose();
        req.setAttribute("userInfo",userInfo);

        req.getRequestDispatcher("/mypage/MyWritePage.jsp").forward(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String saveImg = "C:\\smart505\\img";
        int maxSize = 10 * 1024 * 1024;

        MultipartRequest mr = new MultipartRequest(req, saveImg, maxSize, "UTF-8", new DefaultFileRenamePolicy());
        String movieId = mr.getParameter("movieId");
        String userNick = mr.getParameter("movieNickName");
        String userIndex = mr.getParameter("movieIndex");
        String[] genre = mr.getParameterValues("genre");

        System.out.println("아이디 :" + movieId + "비밀번호 :" +userNick+ "movieIndex:"+userIndex);
        System.out.println("장르" + genre);
        ContentDTO contentDto = new ContentDTO();

        contentDto.setContent_title(mr.getParameter("title"));
        contentDto.setContent(mr.getParameter("content"));
        contentDto.setContent_img(mr.getParameter("contentImg"));
        contentDto.setGenre(mr.getParameter("genre"));

        MovieContentDAO conTentDao = new MovieContentDAO();

        conTentDao.insertContent(contentDto, movieId, userNick, userIndex);
        conTentDao.dbClose();

        resp.sendRedirect("/mypage/MyPage.jsp");

    }
}
