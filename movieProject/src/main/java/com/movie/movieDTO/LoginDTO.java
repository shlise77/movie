package com.movie.movieDTO;

//회원가입
public class LoginDTO {
    private int movieIndex; // 기본키
    private String movieId; // 아이디
    private String moviePw; // 비밀번호
    private String movieNickName; //사용할 닉네임
    private int rankId;// 회원 구분

    public int getMovieIndex() {
        return movieIndex;
    }

    public void setMovieIndex(int movieIndex) {
        this.movieIndex = movieIndex;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMoviePw() {
        return moviePw;
    }

    public void setMoviePw(String moviePw) {
        this.moviePw = moviePw;
    }

    public String getMovieNickName() {
        return movieNickName;
    }

    public void setMovieNickName(String movieNickName) {
        this.movieNickName = movieNickName;
    }

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

}
