package com.movie.movieDTO;

//회원가입
public class LoginDTO {
    private int movieIndex; // 기본키
    private String movieId; // 아이디
    private String moviePw; // 비밀번호
    private String movieNickName; //사용할 닉네임
    private String rankId;// 회원 구분

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

    public String getRankId() {
        return rankId;
    }

    public void setRankId(String rankId) {
        this.rankId = rankId;
    }
}
