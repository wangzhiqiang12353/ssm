package com.ytc.mapper;

import com.ytc.model.Movie;
import com.ytc.model.MovieDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieMapper {
    int deleteByPrimaryKey(Integer movieid);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(Integer movieid);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    /**
     * 查询总条数
     * @return
     * @param movieDto
     */
    long queryMovieCount(@Param("dto") MovieDto movieDto);

    List<Movie> queryMovieList(@Param("start") int start, @Param("pageSize") int pageSize,@Param("dto") MovieDto movieDto);

    /**
     * 新增电影
     * @param movie
     */
    void addMovie(@Param("m")Movie movie);

    /**
     * 修改1 将要修改的数据展示到页面
     * @param movieid
     * @return
     */
    Movie queryMovieById(@Param("movieid") Integer movieid);

    /**
     * 修改2 将修改的值保存到数据库
     * @param movie
     */
    void updateMovie(@Param("movie") Movie movie);

    /**
     * 删除电影
     * @param movieid
     */
    void deleteMovie(Integer movieid);

    /**
     * 批量删除电影
     * @param list
     */
    void delsMovie(List<Integer> list);
}