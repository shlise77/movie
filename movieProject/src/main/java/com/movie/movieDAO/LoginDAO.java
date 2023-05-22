package com.movie.movieDAO;

import com.movie.movieDTO.LoginDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO extends JDBCConnect {
    // 생성자
    public LoginDAO() {
        super();
    }

    // 메소드
    // 회원가입 메소드
    public int insertLoginMovie(LoginDTO loginDto) {
        int result = 0;
        // 회원가입할 sql insert 문 작성
        String sql = "INSERT INTO ";
        sql += "movlogin (movie_id, movie_pw, movie_nick_name) ";
        sql += "VALUES ";
        sql += "(?, ?, ?)";

        // slq 문 등록
        try {
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
        } catch (Exception e) {
            System.out.println("insert fail");
            System.out.println("Error message : " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    // 회원가입 아이디 중복 체크


    // 로그인 페이지
    public LoginDTO selectLoginMovie(String movieId) {
        //1. userid, 와 userpw 의 메게변수를 받아 온다. 그리고 list 형식으로 만들 것이라고 리스트 형식으로 불러온다
        LoginDTO userInfoDto = new LoginDTO(); // db 의 칼럼값을 가져 오기위에 객체 생성
        // 2. select 문으로 sql문을 짠다.
        String sql = "SELECT ";
        sql += "movie_index, movie_id, movie_pw, movie_nick_name, rank_id ";
        sql += "FROM ";
        sql += "movlogin ";
        sql += "WHERE ";
        sql += "movie_id=?";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,movieId);
            rs= pstmt.executeQuery();

            while (rs.next()){
                userInfoDto.setMovieIndex(rs.getInt("movie_index")); //10
                userInfoDto.setMovieId(rs.getString("movie_id")); // testiser
                userInfoDto.setMoviePw(rs.getString("movie_pw")); // 1234
                userInfoDto.setMovieNickName(rs.getString("movie_nick_name"));// 하나
                userInfoDto.setRankId(rs.getInt("rank_id")); //2
            }

            //  SQL문 확인
            System.out.println("+--------SQL문 확인--------+");
            System.out.println(sql);
            System.out.println("+------------------------+");
            // 디버그용 중단점
            ;
        }
        catch (Exception e){
            System.out.println("Login 실패");
            System.out.println("ErrorMessage"+e.getMessage());
            e.printStackTrace();
        }

        //3. connect dp sql 문을 넣어 삽입하고
        // 3-1 PreparedStatement 에 넣어준다.
        // 3-2
        return userInfoDto;
    }
}
