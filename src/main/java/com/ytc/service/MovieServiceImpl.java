/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MovieServiceImpl
 * Author:   PC
 * Date:     2020-09-14 19:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.ytc.mapper.MovieFileMapper;
import com.ytc.mapper.MovieMapper;
import com.ytc.model.Movie;
import com.ytc.model.MovieDto;
import com.ytc.model.MovieFile;
import com.ytc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-14
 * @since 1.0.0
 */
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieFileMapper movieFileMapper;

    public PageUtil<Movie> queryMovieList(PageUtil<Movie> page, MovieDto movieDto) {
        //查询总条数
        long count =movieMapper.queryMovieCount(movieDto);
        page= new PageUtil<Movie>(page.getCpage(),count,page.getPageSize());

       List<Movie> list= movieMapper.queryMovieList(page.getStart(),page.getPageSize(),movieDto);
       page.setList(list);
        return page;
    }

    @Override
    public void addMovie(Movie movie) {
        if(movie.getMovieFile().getFileid()==null){
            MovieFile movieFile =new MovieFile();
            movieFile.setFilepath(movie.getMovieFile().getFilepath());
            movieFileMapper.addMovieFile(movieFile);
            movie.setMovieFile(movieFile);
      }
        movieMapper.addMovie(movie);
    }

    @Override
    public Movie queryMovieById(Integer movieid) {

        return movieMapper.queryMovieById(movieid);
    }

    @Override
    public void updateMovie(Movie movie) {
        MovieFile movieFile=new MovieFile();
        movieFile.setFilepath(movie.getMovieFile().getFilepath());
        movieFile.setFileid(movie.getMovieFile().getFileid());
        movieFileMapper.updateMovieFile(movieFile);
        movieMapper.updateMovie(movie);
    }

    @Override
    public void deleteMovie(Integer movieid) {
        Movie movie = movieMapper.queryMovieById(movieid);
        Integer fileid = movie.getMovieFile().getFileid();
        System.out.println(fileid);
        movieMapper.deleteMovie(movieid);
        movieFileMapper.deleteMovieFile(fileid);
    }

    @Override
    public void delsMovie(String ids) {
        String[] idss=ids.split(",");
        List<Integer> list=new ArrayList<Integer>();
        List<Integer> listFile=new ArrayList<Integer>();
        for (int i=0;i<idss.length;i++){
            Movie movie = movieMapper.queryMovieById(Integer.parseInt(idss[i].trim()));
            Integer fileid = movie.getMovieFile().getFileid();
            listFile.add(fileid);
            list.add(Integer.parseInt(idss[i].trim()));
        }
        movieFileMapper.delsMovieFile(listFile);
        movieMapper.delsMovie(list);
    }

}