package com.ytc.model;

public class Movie {
    private Integer movieid;

    private String moviename;

    private String movieshow;

   // private Integer movietype;
    private MovieType movieType;

   // private Integer movieadress;
    private Adress adress;

    //private Integer movieyear;
    private MovieYear movieYear;

    private String moviescore;

    //private Integer moviefile;
    private  MovieFile movieFile;

    private String movietime;

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getMovieshow() {
        return movieshow;
    }

    public void setMovieshow(String movieshow) {
        this.movieshow = movieshow;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public MovieYear getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(MovieYear movieYear) {
        this.movieYear = movieYear;
    }

    public String getMoviescore() {
        return moviescore;
    }

    public void setMoviescore(String moviescore) {
        this.moviescore = moviescore;
    }

    public MovieFile getMovieFile() {
        return movieFile;
    }

    public void setMovieFile(MovieFile movieFile) {
        this.movieFile = movieFile;
    }

    public String getMovietime() {
        return movietime;
    }

    public void setMovietime(String movietime) {
        this.movietime = movietime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieid=" + movieid +
                ", moviename='" + moviename + '\'' +
                ", movieshow='" + movieshow + '\'' +
                ", movieType=" + movieType +
                ", adress=" + adress +
                ", movieYear=" + movieYear +
                ", moviescore='" + moviescore + '\'' +
                ", movieFile=" + movieFile +
                ", movietime='" + movietime + '\'' +
                '}';
    }

    public Movie() {
    }
}