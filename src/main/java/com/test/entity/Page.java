package com.test.entity;

/**
 * 存储页面信息实体类
 * create by 2019-12-21
 */
public class Page {
    //页面内容
    private String content;

    //总播放量
    private String allNumber;

    //每日播放量
    private String dayNumber;

    //评论数
    private String commentNumber;

    //收藏数
    private String collectNumber;

    //赞
    private String supportNumber;

    //踩
    private String againstNumber;

    //电视剧名称
    private String tvName;

    //页面url
    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAllNumber() {
        return allNumber;
    }

    public void setAllNumber(String allNumber) {
        this.allNumber = allNumber;
    }

    public String getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(String dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(String collectNumber) {
        this.collectNumber = collectNumber;
    }

    public String getSupportNumber() {
        return supportNumber;
    }

    public void setSupportNumber(String supportNumber) {
        this.supportNumber = supportNumber;
    }

    public String getAgainstNumber() {
        return againstNumber;
    }

    public void setAgainstNumber(String againstNumber) {
        this.againstNumber = againstNumber;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    //子集数据
    private String episodeNumber;
}
