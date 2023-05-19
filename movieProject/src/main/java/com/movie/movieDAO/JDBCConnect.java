package com.movie.movieDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

public class JDBCConnect {

    // this. : .이 붙은건 빌드를 불러 올때 쓰는것이고
    // this() : 메소드를 불러 올때 쓰는 것이다. this() 에 매개 변수의 숫자에 따라 다르게 불러 올수 있다.
    // 그리고 this() 가 먼저 먼 생성이 되므로 필드을 쓰더라도 생성자 안에 this() 안에는 포함이 되지 않는다.

    // db 연결시 사용하는 클래스 종류
    // Class.forName() : JDBC 드라이버 로딩
    // Connection con : 데이터에비이스 연결
    // PreparedStatement : SQL문 작성
    // ResultSet : SQL문 실행 및 결과 처리
    // colose()  : db 연결 해제

    // 필드
    protected Connection conn = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;

    // 생성자
    public JDBCConnect(){
        String driVer = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/movie?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
        String dbId = "movietable";
        String dbPw = "root00";

        dbOpen(driVer,dbUrl,dbId,dbPw);
    }

    // 메소드
    private void dbOpen(String driVer, String dbUrl, String dbId, String dbPw) {
        try{
            Class.forName(driVer); // db 로딩
            conn = DriverManager.getConnection(dbUrl,dbId,dbPw); // db 연결
            System.out.println("DB Connect success!!!");
        }
        catch (Exception e){
            System.out.println("DB 연결에 실패 했습니다. ");
            System.out.println("ErrorMessage : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void dbClose(){
        try{
            if(rs != null){rs.close();}
            if(pstmt != null){pstmt.close();}
            if(conn != null){conn.close();}
            System.out.println("DB Not Connect success!!!");
        }
        catch (Exception e){
            System.out.println("DB Connect Faill");
            System.out.println("DB ERROR MESSAGE :: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
