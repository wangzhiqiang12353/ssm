/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Test
 * Author:   PC
 * Date:     2020-09-17 19:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.test;

import com.ytc.mapper.MovieFileMapper;
import com.ytc.mapper.MovieMapper;
import com.ytc.model.Movie;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author PC
 * @create 2020-09-17
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-common.xml"})
public class Test {
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieFileMapper movieFileMapper;

    @org.junit.Test
    public void test1() {
        Movie movie = movieMapper.queryMovieById(1);
        System.out.println(movie);
        Integer fileid = movie.getMovieFile().getFileid();
    }
}