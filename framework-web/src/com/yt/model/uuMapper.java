package com.yt.model;

import com.yt.model.uu;

public interface uuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(uu record);

    int insertSelective(uu record);

    uu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(uu record);

    int updateByPrimaryKey(uu record);
}