package com.movie.movieDAO;

import com.movie.movieDTO.ContentDTO;
import com.movie.movieDTO.LoginDTO;
import com.movie.movieDTO.ReadJoinDTO;

import java.util.ArrayList;
import java.util.List;

public class MovieContentDAO extends JDBCConnect {
    //필드

    //생성자
    public MovieContentDAO() {
        super();
    }

    //메서드
    // List 뿌리기
    public List<ContentDTO> listContent() {
        List<ContentDTO> contentDtoList = new ArrayList<>();

        String sql = "SELECT ";
        sql += "content_num, content_title, content, content_img, content_date, genre, user_nick, user_id, user_index ";
        sql += " FROM ";
        sql += "movie_content ";
        sql += "ORDER BY content_num DESC ";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                ContentDTO contentDto = new ContentDTO();
                contentDto.setContent_num(rs.getInt("content_num"));
                contentDto.setContent_title(rs.getString("content_title"));
                contentDto.setContent(rs.getString("content"));
                contentDto.setContent_img(rs.getString("content_img"));
                contentDto.setContent_date(rs.getString("content_date"));
                contentDto.setGenre(rs.getString("genre"));
                contentDto.setUser_nick(rs.getString("user_nick"));
                contentDto.setUser_id(rs.getString("user_id"));
                contentDto.setUser_index(rs.getInt("user_index"));

                contentDtoList.add(contentDto);
            }

        } catch (Exception e) {
            System.out.println("list 화면에서 에러가 발생했습니다.");
            System.out.println("Error Message : " + e.getMessage());
            e.printStackTrace();
        }


        return contentDtoList;
    }


    public LoginDTO selectUserContent(String movieId) {
        LoginDTO userInfoDto = new LoginDTO();

        // 마이페이지 윗 화면
        String sql = "SELECT ";
        sql += "movie_index, movie_id, movie_pw, movie_nick_name, rank_id, movie_user_img ";
        sql += "From movie_login ";
        sql += "WHERE ";
        sql += "movie_id = ?; ";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movieId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                userInfoDto.setMovieIndex(rs.getInt("movie_index"));
                userInfoDto.setMovieId(rs.getString("movie_id"));
                userInfoDto.setMoviePw(rs.getString("movie_pw"));
                userInfoDto.setMovieNickName(rs.getString("movie_nick_name"));
                userInfoDto.setRankId(rs.getInt("rank_id"));
                userInfoDto.setMovieUserImg(rs.getString("movie_user_img"));
            }
        } catch (Exception e) {
            System.out.println("메인페이지 기본 화면에서 에러가 발생했습니다.");
            System.out.println("Error Message :" + e.getMessage());
            e.printStackTrace();
        }

        return userInfoDto;
    }

    // 조인문을 쓸것인데 쓸려면 두개의 DTO을 불러 와서
    public int insertContent(ContentDTO contentDto, String movieId, String userNick, String userIndex, String fileName) {
        int result = 0;

        String sql = "INSERT INTO ";
        sql += "movie_content ";
        sql += "(content_title, content, content_img ,content_date, genre, user_nick, user_id, user_index) ";
        sql += "VALUES ";
        sql += "(? ,? , ? , NOW(), ?, ?, ?, ?) ";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, contentDto.getContent_title());
            pstmt.setString(2, contentDto.getContent());
            pstmt.setString(3, fileName);
            pstmt.setString(4, contentDto.getGenre());
            pstmt.setString(5, userNick);
            pstmt.setString(6, movieId);
            pstmt.setString(7, userIndex);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("글 등록중 에러 가 발생했습니다.");
            System.out.println("Error Message :" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    // 읽기 페이지
    public ReadJoinDTO readUser(String indexUser, String contentNum){
        ReadJoinDTO readPage = new ReadJoinDTO();

        String sql = "SELECT ";
                sql +=" B.content_num AS 'content_num', A.movie_id AS 'movie_id', A.movie_nick_name AS 'movie_nick_name', A.rank_id AS 'rank_id', A.movie_user_img AS 'movie_user_img', ";
                sql +=" B.genre AS 'genre', B.content_title AS 'content_title', B.content AS 'content', B.content_img AS 'content_img', ";
                sql +=" B.content_date AS 'content_date', B.user_index AS 'user_index', B.like_num AS 'like_num' ";
                sql +=" FROM movie_login A ";
                sql +=" JOIN movie_content B ";
                sql +=" ON  user_index = ? ";
                sql +=" AND B.content_num = ? ";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, indexUser);
            pstmt.setString(2, contentNum);
            rs = pstmt.executeQuery();

            while(rs.next()){
                readPage.setContent_num(rs.getInt("content_num"));
                readPage.setMovie_id(rs.getString("movie_id"));
                readPage.setMovie_nick_name(rs.getString("movie_nick_name"));
                readPage.setRank_id(rs.getInt("rank_id"));
                readPage.setMovie_user_img(rs.getString("movie_user_img"));
                readPage.setGenre(rs.getString("genre"));
                readPage.setContent_title(rs.getString("content_title"));
                readPage.setContent(rs.getString("content"));
                readPage.setContent_img(rs.getString("content_img"));
                readPage.setContent_date(rs.getString("content_date"));
                readPage.setUser_index(rs.getInt("user_index"));
                readPage.setLike_num(rs.getInt("like_num"));
            }
        }
        catch (Exception e){
            System.out.println("읽기 전체 조회 부분에 에러가 발생을 했습니다.");
            System.out.println("ErrorMessage:"+e.getMessage());
            e.printStackTrace();
        }
        return readPage;
    }

    // 업데이트
    public int contentUpdate (ContentDTO updateDto, String contentTitle, String content, String userIndex, String contentNum, String newFileName){
        int result = 0;

        String sql = "UPDATE ";
        sql +="movie_content ";
        sql +="SET ";
        sql +="content_title = ?, content = ?, genre = ?, content_img = ? ";
        sql +="WHERE user_index = ? AND content_num = ?";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, contentTitle);
            pstmt.setString(2, content);
            pstmt.setString(3, updateDto.getGenre());
            pstmt.setString(4, newFileName);
            pstmt.setString(5, userIndex);
            pstmt.setString(6, contentNum);

            result = pstmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println("수정 페이지에서 오류가 발생했습니다.");
            System.out.println("ERROR MESSAGE :"+ e.getMessage());
            e.printStackTrace();
        }

     return result;
    }

    public int contentDelete(String content_num, String user_index){
        int result = 0;
        String sql = "DELETE FROM movie_content ";
        sql += "WHERE content_num = ? AND user_index = ? ";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,content_num);
            pstmt.setString(2,user_index);

            result = pstmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println("삭제 부분에서 에러가 발생했습니다.");
            System.out.println("ERROR MESSAGE : "+ e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    public int likeNumUp(String likeNum, String contentNum){
        int result = 0;

        String sql = " UPDATE movie_content ";
        sql +=" SET ";
        sql +="like_num = ? + 1 ";
        sql +=" WHERE content_num = ? ";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, likeNum);
            pstmt.setString(2, contentNum);
            result = pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("좋아요 업데이트 sql 부분에서 에러가 발생했습니다.");
            System.out.println("ERROR MESSAGE :" + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }
}
