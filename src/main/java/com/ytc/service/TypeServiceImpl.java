/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TypeServiceImpl
 * Author:   PC
 * Date:     2020-09-15 15:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.ytc.mapper.MovieTypeMapper;
import com.ytc.model.MovieType;
import com.ytc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-15
 * @since 1.0.0
 */
@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private MovieTypeMapper movieTypeMapper;

    public List<MovieType> queryTypeList() {

        return movieTypeMapper.queryTypeList();
    }


    @Override
    public PageUtil<MovieType> queryTypeLists(PageUtil<MovieType> page, MovieType movieType) {
        long count =movieTypeMapper.queryTypeCount(movieType);
        page=new PageUtil<MovieType>(page.getCpage(),count,page.getPageSize());
        List<MovieType> list=movieTypeMapper.queryTypeLists(page.getStart(),page.getPageSize(),movieType);
        page.setList(list);

        return page;
    }
}