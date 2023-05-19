package com.movie.movieDAO;

import com.movie.movieDTO.LoginDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginDAO extends JDBCConnect{
    // 생성자
    public LoginDAO(){
        super();
    }

    // 메소드
    // 회원가입 메소드
    public int insertLoginMovie(LoginDTO loginDto){
        int result = 0;
        // 회원가입할 sql insert 문 작성
        String sql = "INSERT INTO ";
            sql += "movlogin (movie_id, movie_pw, movie_nick_name) ";
            sql += "VALUES ";
            sql += "(?, ?, ?)";

        // slq 문 등록
        try{
        //prepareStatement
        //- Statement 클래스의 기능 향상
        //- 인자와 관련된 작업이 특화(매개변수)
        //- 코드 안정성 높음. 가독성 높음.
        //- 코드량이 증가 -> 매개변수를 set해줘야하기 때문에..
        //- 텍스트 SQL 호출
            // conn 으로 디비를 연결 하고 insert 쿼리문 을 변경으로 저장한 sql 변수 을
            // stmt 에 저장
            pstmt = conn.prepareStatement(sql);

            // 저장
            pstmt.setString(1, loginDto.getMovieId());
            pstmt.setString(2, loginDto.getMoviePw());
            pstmt.setString(3, loginDto.getMovieNickName());

            result = pstmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println("insert fail");
            System.out.println("Error message : "+ e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    // 회원가입 아이디 중복 체크
    public int movieIdCheck(String userId){
        int resultId = 0;
        LoginDTO loginDto = new LoginDTO();// 저장된 로그인 값을 들고 와야 되기에 객체 생성

        String sql ="SELECT movie_id FROM movlogin WHERE movie_id = ?";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();// 쿼리문 실행

            resultId = rs.getInt(userId);

                while (rs.next()){
                    loginDto.setMovieId(rs.getString("userId"));
                }
        }
        catch (Exception e){
            System.out.println("아이디 값을 select 중 error 가 발생했습니다.");
            System.out.println("Error Message :" + e.getMessage());
            e.printStackTrace();
        }
        return resultId;
    }

    public void selectLoginMovie(LoginDTO movieDto){
        System.out.println("db 연결 확인용");
    }
}
