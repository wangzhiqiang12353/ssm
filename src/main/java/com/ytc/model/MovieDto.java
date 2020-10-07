/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MovieDto
 * Author:   PC
 * Date:     2020-09-15 17:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-15
 * @since 1.0.0
 */
public class MovieDto {

    private Integer typeid;
    private Integer adressid;
    private Integer yearid;
    private String moviename;
    private String startScore;
    private String endScore;
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartScore() {
        return startScore;
    }

    public void setStartScore(String startScore) {
        this.startScore = startScore;
    }

    public String getEndScore() {
        return endScore;
    }

    public void setEndScore(String endScore) {
        this.endScore = endScore;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public Integer getYearid() {
        return yearid;
    }

    public void setYearid(Integer yearid) {
        this.yearid = yearid;
    }

    public Integer getAdressid() {
        return adressid;
    }

    public void setAdressid(Integer adressid) {
        this.adressid = adressid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public MovieDto() {
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "typeid=" + typeid +
                ", adressid=" + adressid +
                ", yearid=" + yearid +
                ", moviename='" + moviename + '\'' +
                ", startScore='" + startScore + '\'' +
                ", endScore='" + endScore + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}