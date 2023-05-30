package com.movie.movieDAO;

import com.movie.movieDTO.MainDTO;

import java.util.ArrayList;
import java.util.List;

public class MainDAO extends JDBCConnect{

    // 생성자
    public MainDAO(){
        super();
    }

    public List<MainDTO> mainCarousel(){
        List<MainDTO> mainCarouselList = new ArrayList<>();

        String sql = "SELECT ";
        sql+="like_num, content_img, content_title, content_num, genre ";
        sql+="FROM ";
        sql+="movie_content ";
        sql+="WHERE like_num BETWEEN 1 AND 50 ";
        sql+="ORDER BY ";
        sql+="like_num ";
        sql+="DESC ";

        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                MainDTO mainListDto = new MainDTO();
                mainListDto.setLike_num(rs.getInt("like_num"));
                mainListDto.setContent_img(rs.getString("content_img"));
                mainListDto.setContent_title(rs.getString("content_title"));
                mainListDto.setContent_num(rs.getInt("content_num"));
                mainListDto.setGenre(rs.getString("genre"));
                mainCarouselList.add(mainListDto);
            }
        }
        catch (Exception e){
            System.out.println("메인 화면 슬라이드 부분 에서 에러가 발생했습니다.");
            System.out.println("ERROR MESSAGE \t"+e.getMessage());
            e.printStackTrace();
        }

        return mainCarouselList;
    }

}
