package com.movie.Controller;

import com.movie.movieDAO.MainDAO;
import com.movie.movieDTO.MainDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Movie/Main.do")
public class MovieMainController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MainDAO mainDaoList = new MainDAO();
        List<MainDTO> mainList = mainDaoList.mainCarousel();
        mainDaoList.dbClose();
        req.setAttribute("mainList",mainList);

        req.getRequestDispatcher("/movieMain.jsp").forward(req,resp);

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}

}
