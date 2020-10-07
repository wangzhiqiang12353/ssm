/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: YearServiceImpl
 * Author:   PC
 * Date:     2020-09-15 16:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.ytc.mapper.MovieYearMapper;
import com.ytc.model.MovieYear;
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
public class YearServiceImpl implements YearService{
    @Autowired
   private MovieYearMapper movieYearMapper;

    public List<MovieYear> queryYearList() {
        return movieYearMapper.queryYearList();
    }
}