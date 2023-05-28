package com.movie.Controller;

import com.movie.movieDAO.LoginDAO;
import com.movie.movieDTO.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Movie/SignUp.do")
public class MovieSignUpController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        req.getRequestDispatcher("/movieSignup.jsp").forward(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 1. 값 들고 오는지 확인
        String movieId = req.getParameter("movieId");
        String userNickName = req.getParameter("userNickName");
        String userPw = req.getParameter("userPw");

        // 2. dao 값을 쏘고
        // getAttribute, getParameter 차이점 공부해보기
        LoginDTO loginDto = new LoginDTO(); // 객체를 생성
        loginDto.setMovieId(req.getParameter("movieId"));
        loginDto.setMoviePw(req.getParameter("userPw"));
        loginDto.setMovieNickName(req.getParameter("userNickName"));

//        //2-1 insert 을 하기 위해 dao 객체 불러 오기
        LoginDAO loginDao = new LoginDAO(); // 객체 생성
        loginDao.insertLoginMovie(loginDto);
        int result = loginDao.hashPassWord(userPw,movieId);
        loginDao.dbClose();

        if(result == 1){
            System.out.println("해쉬적용이 완료 되었습니다.");
            // 4. 값이 정상적으로 완료가 되면 메인 화면으로 이동(저장이 완료 되었다는 것과 함께 다시 로그인 해달라 라는 메시지 출력)
            resp.sendRedirect("/Movie/Main.do");
        }
    }
}
