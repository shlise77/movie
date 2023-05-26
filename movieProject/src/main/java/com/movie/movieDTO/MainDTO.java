package com.movie.movieDTO;

public class MainDTO {
    private int like_num;
    private String content_img;
    private String content_title;
    private int content_num;
    private String genre;
    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public String getContent_img() {
        return content_img;
    }

    public void setContent_img(String content_img) {
        this.content_img = content_img;
    }

    public String getContent_title() {
        return content_title;
    }

    public void setContent_title(String content_title) {
        this.content_title = content_title;
    }

    public int getContent_num() {
        return content_num;
    }

    public void setContent_num(int content_num) {
        this.content_num = content_num;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
