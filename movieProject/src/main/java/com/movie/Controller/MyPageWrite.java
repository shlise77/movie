package com.movie.Controller;

import com.movie.Util.FileUtils;
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
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        // 저장위치
//        String saveImg = "C:\\smart505\\project\\movie\\movieProject\\src\\main\\webapp\\resources\\images\\";
        String saveImg = "C:\\Users\\lyuli\\Pictures\\Screenshots\\";
        // 사이즈
        int maxSize = 10 * 1024 * 1024;

        MultipartRequest mr = FileUtils.uploadFile(req, saveImg, maxSize);
        String movieId = mr.getParameter("movieId");
        String userNick = mr.getParameter("movieNickName");
        String userIndex = mr.getParameter("movieIndex");
        String[] genre = mr.getParameterValues("genre");
        String fileName = mr.getFilesystemName("file");
        String newFileName = null;


        /// 영화 포스터 이미지 파일 처리 부분//
        ContentDTO contentDto = new ContentDTO();
        if (fileName != null) {
            String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
            String ext = fileName.substring(fileName.lastIndexOf("."));
            newFileName = now + ext;

            File oldFile = new File(saveImg + File.separator + fileName);
            File newFile = new File(saveImg + File.separator + newFileName);
            oldFile.renameTo(newFile);

            contentDto.setContent_img(fileName);
        }
        /////////////////////////////////////////

//        System.out.println("아이디 :" + movieId + "비밀번호 :" +userNick+ "movieIndex:"+userIndex);
//        System.out.println("장르" + genre);

        contentDto.setContent_title(mr.getParameter("title"));
        contentDto.setContent(mr.getParameter("content"));
        contentDto.setContent_img(mr.getParameter("contentImg"));
        contentDto.setGenre(mr.getParameter("genre"));

        MovieContentDAO conTentDao = new MovieContentDAO();

        conTentDao.insertContent(contentDto, movieId, userNick, userIndex, newFileName);
        conTentDao.dbClose();

        resp.sendRedirect("/Movie/MyPage.do?movieId="+movieId);

    }
}
