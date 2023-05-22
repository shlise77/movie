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
        //2. id 값과 pw 을 받아서 select dao 에 전송을 하고
        String movieId = req.getParameter("movieId");
        LoginDTO userInfo = loginDao.selectLoginMovie(movieId);
        // 2-1 db 는 바로 닫아주어야 한다. 안그러면 데이터 누수가 발생할수 있다.
        loginDao.dbClose();
        //3. 전송 받은 값 list형식으로 받아서 jstl 형식으로 jsp 에 뿌려주고 이게
        //   곧 마이 페이지의 닉네임 값과 rank 값을 보여줘야됨
        req.setAttribute("userInfo", userInfo);

        //session
        HttpSession session = req.getSession();
        session.invalidate();

        req.getRequestDispatcher("/movieMain.jsp").forward(req,resp);
    }
}
