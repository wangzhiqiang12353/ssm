package com.ytc.mapper;

import com.ytc.model.MovieFile;

import java.util.List;

public interface MovieFileMapper {
    int deleteByPrimaryKey(Integer fileid);

    int insert(MovieFile record);

    int insertSelective(MovieFile record);

    MovieFile selectByPrimaryKey(Integer fileid);

    int updateByPrimaryKeySelective(MovieFile record);

    int updateByPrimaryKey(MovieFile record);

    /**
     * 新增图片路径到表中
     * @param movieFile
     */
    void addMovieFile(MovieFile movieFile);

    /**
     * 修改图片路径到表中
     * @param movieFile
     */
    void updateMovieFile(MovieFile movieFile);

    /**
     * 删除图片
     * @param fileid
     */
    void deleteMovieFile(Integer fileid);

    /**
     * 批量删除
     * @param listFile
     */
    void delsMovieFile(List<Integer> listFile);


}