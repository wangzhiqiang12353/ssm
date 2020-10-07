package com.ytc.mapper;

import com.ytc.model.Adress;

import java.util.List;

public interface AdressMapper {
    int deleteByPrimaryKey(Integer adressid);

    int insert(Adress record);

    int insertSelective(Adress record);

    Adress selectByPrimaryKey(Integer adressid);

    int updateByPrimaryKeySelective(Adress record);

    int updateByPrimaryKey(Adress record);

    /**
     * 查询地区列表
     * @return
     */
    List<Adress> queryAdressList();
}