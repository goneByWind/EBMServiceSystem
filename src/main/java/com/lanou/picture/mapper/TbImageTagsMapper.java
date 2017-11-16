package com.lanou.picture.mapper;

import com.lanou.picture.bean.TbImageTags;

public interface TbImageTagsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbImageTags record);

    int insertSelective(TbImageTags record);

    TbImageTags selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbImageTags record);

    int updateByPrimaryKey(TbImageTags record);
}