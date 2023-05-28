package com.movie.movieDAO;

import com.movie.Util.SHA256Util;
import com.movie.movieDTO.LoginDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO extends JDBCConnect {
    // 생성자
    public LoginDAO() {
        super();
    }

    // 메소드
    // 회원가입 메소드
    public int insertLoginMovie(LoginDTO loginDto){
        int result = 0;
        // 회원가입할 sql insert 문 작성
        String sql = "INSERT INTO ";
            sql += "movie_login (movie_id, movie_pw, movie_nick_name) ";
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
        sql += "movie_login ";
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

        }
        catch (Exception e){
            System.out.println("Login 실패");
            System.out.println("ErrorMessage"+e.getMessage());
            e.printStackTrace();
        }
        return userInfoDto;
    }

    public int hashPassWord(String userPw, String movieId) {
        int result = 0;

        LoginDTO passWorldChange = new LoginDTO();

        System.out.println("up 부분");

        String sql = "UPDATE movie_login  SET movie_pw = ? WHERE movie_id= ? ";

        int indexGet = passWorldChange.getMovieIndex();
        System.out.println("인트"+indexGet);


        try {
            String newPassWord = SHA256Util.getEncrypt(userPw,movieId);
            System.out.println("newpassword:"+newPassWord);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,newPassWord);
            pstmt.setString(2,movieId);
            result = pstmt.executeUpdate();


        } catch (Exception e) {
            System.out.println("비밀번호 변경 부분에서 에러가 발생했습니다.");
            System.out.println("ERROR MESSAGE : " +e.getMessage());
            e.printStackTrace();
        }


        return result;
    }
}
