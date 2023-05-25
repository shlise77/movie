package com.movie.movieDTO;

public class ContentDTO {
    private int content_num;
    private String content_title;
    private String content;
    private String content_img;
    private String content_date;
    private String genre;
    private int like_num;
    private String user_nick;
    private String user_id;
    private int user_index;

    public int getUser_index() {
        return user_index;
    }

    public void setUser_index(int user_index) {
        this.user_index = user_index;
    }



    public int getContent_num() {
        return content_num;
    }

    public void setContent_num(int content_num) {
        this.content_num = content_num;
    }

    public String getContent_title() {
        return content_title;
    }

    public void setContent_title(String content_title) {
        this.content_title = content_title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_img() {
        return content_img;
    }

    public void setContent_img(String content_img) {
        this.content_img = content_img;
    }

    public String getContent_date() {
        return content_date;
    }

    public void setContent_date(String content_date) {
        this.content_date = content_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
