package com.movie.Controller;

import com.movie.Util.FileUtils;
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
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Movie/MyEdit.do")
public class MyPageEditController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieId = req.getParameter("movieId");
        String userIndex = req.getParameter("userIndex");
        String contentNum = req.getParameter("contentNum");
        HttpSession session = req.getSession();
        System.out.println("movieId" + movieId + "userIndex" + userIndex);
        session.setAttribute("movieId", movieId);

        MovieContentDAO headlist = new MovieContentDAO();
        LoginDTO userInfo = headlist.selectUserContent(movieId);
        headlist.dbClose();
        req.setAttribute("userInfo", userInfo);

        // 1. 화면 뿌리기
        MovieContentDAO contentDao = new MovieContentDAO();
        ReadJoinDTO readDto = contentDao.readUser(userIndex, contentNum);
        contentDao.dbClose();
        req.setAttribute("readDto", readDto);

        // 2. 수정 하기(update) 완료하기

        // 2. 수정 완료되면

        req.getRequestDispatcher("/mypage/MyEditPage.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 저장위치
        String saveImg = "C:\\smart505\\project\\movie\\movieProject\\src\\main\\webapp\\resources\\images\\";
        // 사이즈
        int maxSize = 10 * 1024 * 1024;

        MultipartRequest mr = FileUtils.uploadFile(req, saveImg, maxSize);
        String movieId = mr.getParameter("movieId");
        String contentTitle = mr.getParameter("contentTitle");
        String content = mr.getParameter("content");
        String genre[] = mr.getParameterValues("genre");
        String userIndex = mr.getParameter("movieIndex");
        String contentNum = mr.getParameter("content_num");

        String fileName = mr.getFilesystemName("file");
        String newFileName = null;

        ContentDTO updateDto = new ContentDTO();
        updateDto.setGenre(mr.getParameter("genre"));


        if (fileName != null) {
            String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
            String ext = fileName.substring(fileName.lastIndexOf("."));
            newFileName = now + ext;

            File oldFile = new File(saveImg + File.separator + fileName);
            File newFile = new File(saveImg + File.separator + newFileName);
            oldFile.renameTo(newFile);

            updateDto.setContent_img(fileName);
        }

//
        MovieContentDAO contentEdit = new MovieContentDAO();
        int result = contentEdit.contentUpdate(updateDto,contentTitle,content, userIndex,contentNum,newFileName);
        contentEdit.dbClose();
        if (result == 1) {
            resp.sendRedirect("/Movie/MyPage.do?movieId="+movieId);
        } else {
            resp.sendRedirect("/Movie/MyPage.do?="+movieId);
        }
    }
}
