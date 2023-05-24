package com.movie.movieDAO;

import com.movie.movieDTO.ContentDTO;
import com.movie.movieDTO.LoginDTO;
import com.movie.movieDTO.ReadJoinDTO;

public class MovieContentDAO extends JDBCConnect{
    //필드

    //생성자
    public MovieContentDAO(){
        super();
    }
    //메서드
    public LoginDTO selectUserContent(String movieId){
        LoginDTO userInfoDto = new LoginDTO();

        // 마이페이지 윗 화면
        String sql ="SELECT ";
                sql += "movie_index, movie_id, movie_pw, movie_nick_name, rank_id, movie_user_img ";
                sql += "From movie_login ";
                sql += "WHERE ";
                sql += "movie_id = ?; ";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movieId);
            rs= pstmt.executeQuery();

            while (rs.next()){
                userInfoDto.setMovieIndex(rs.getInt("movie_index"));
                userInfoDto.setMovieId(rs.getString("movie_id"));
                userInfoDto.setMoviePw(rs.getString("movie_pw"));
                userInfoDto.setMovieNickName(rs.getString("movie_nick_name"));
                userInfoDto.setRankId(rs.getInt("rank_id"));
                userInfoDto.setMovieUserImg(rs.getString("movie_user_img"));
            }
        }
        catch (Exception e){
            System.out.println("메인페이지 기본 화면에서 에러가 발생했습니다.");
            System.out.println("Error Message :" + e.getMessage());
            e.printStackTrace();
        }

        return userInfoDto;
    }

    // 조인문을 쓸것인데 쓸려면 두개의 DTO을 불러 와서
    public int insertContent(ContentDTO contentDto,String movieId, String userNick, String userIndex){
        int result = 0;

        String sql = "INSERT INTO ";
                sql += "movie_content ";
                sql += "(content_title, content, content_img ,content_date, genre, user_nick, user_id, user_index) ";
                sql += "VALUES ";
                sql += "(? ,? , ? , NOW(), ?, ?, ?, ?) ";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,contentDto.getContent_title());
            pstmt.setString(2, contentDto.getContent());
            pstmt.setString(3, contentDto.getContent_img());
            pstmt.setString(4, contentDto.getGenre());
            pstmt.setString(5, userNick);
            pstmt.setString(6, movieId);
            pstmt.setString(7, userIndex);
            result = pstmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println("글 등록중 에러 가 발생했습니다.");
            System.out.println("Error Message :" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    // 읽기 페이지
    public ReadJoinDTO readUser(String indexUser){
        ReadJoinDTO readPage = new ReadJoinDTO();

        String sql = "SELECT ";
                sql +=" B.content_num, A.movie_id, A.movie_nick_name, A.rank_id, A.movie_user_img, B.genre, B.content_title ";
                sql +=" B.content, B.content_img, B.content_date ";
                sql +=" FROM movie_login a ";
                sql +=" JOIN movie_content b ";
                sql +=" ON  b.user_index = ? ";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, indexUser);
            rs = pstmt.executeQuery();

            while(rs.next()){
                readPage.setContent_num(rs.getInt("content_num"));
                readPage.setMovieId(rs.getString("movieId"));
                readPage.setMovieNickName(rs.getString("movieNickName"));
                readPage.setRankId(rs.getInt("rankId"));
                readPage.setMovieUserImg(rs.getString("movieUserImg"));
                readPage.setGenre(rs.getString("genre"));
                readPage.setContent_title(rs.getString("content_title"));
                readPage.setContent(rs.getString("content"));
                readPage.setContent_img(rs.getString("content_img"));
                readPage.setContent_date(rs.getString("content_date"));
            }
        }
        catch (Exception e){
            System.out.println("읽기 전체 조회 부분에 에러가 발생을 했습니다.");
            System.out.println("ErrorMessage:"+e.getMessage());
            e.printStackTrace();
        }
        return readPage;
    }

    public int searchIndex(String movieId){
        int result = 0;
        ContentDTO userIndex = new ContentDTO();

        String sql =  "SELECT DISTINCT user_index FROM movie_content WHERE user_id = ?;";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movieId);
            rs = pstmt.executeQuery();

            while (rs.next()){
//                result = userIndex.setUser_id(rs.getString(movieId));
//                result =  userIndex.setUser_id(rs.getString(movieId));
            }

        }
        catch (Exception e){
            System.out.println("index 번호는 찾는 중 에러가 발생했습니다.");
            System.out.println("ERROR MESSAGE"+e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}
