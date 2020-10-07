package com.ytc.mapper;

import com.ytc.model.MovieYear;

import java.util.List;

public interface MovieYearMapper {
    int deleteByPrimaryKey(Integer yearid);

    int insert(MovieYear record);

    int insertSelective(MovieYear record);

    MovieYear selectByPrimaryKey(Integer yearid);

    int updateByPrimaryKeySelective(MovieYear record);

    int updateByPrimaryKey(MovieYear record);

    /**
     * 查询年代列表
     * @return
     */
    List<MovieYear> queryYearList();
}