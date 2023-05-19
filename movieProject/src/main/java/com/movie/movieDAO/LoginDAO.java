package com.movie.movieDAO;

import com.movie.movieDTO.LoginDTO;

public class LoginDAO extends JDBCConnect{
    // 생성자
    public LoginDAO(){
        super();
    }

    // 메소드
    public void selectLoginMovie(LoginDTO movieDto){
        System.out.println("db 연결 확인용");
    }
}
