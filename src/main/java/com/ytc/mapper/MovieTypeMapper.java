package com.ytc.mapper;

import com.ytc.model.MovieType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieTypeMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(MovieType record);

    int insertSelective(MovieType record);

    MovieType selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(MovieType record);

    int updateByPrimaryKey(MovieType record);

    /**
     * 查询类型列表
     * @return
     */
    List<MovieType> queryTypeList();

    /**
     * 查询总条数
     * @return
     * @param movieType
     */
    long queryTypeCount(@Param("movieType")MovieType movieType);

    /**
     * 查询列表
     * @param start
     * @param pageSize
     * @param movieType
     * @return
     */
    List<MovieType> queryTypeLists(@Param("start") int start, @Param("pageSize") int pageSize, @Param("movieType")MovieType movieType);
}