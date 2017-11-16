package com.lanou.picture.mapper;

import com.lanou.picture.bean.TbImageAlbum;

public interface TbImageAlbumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbImageAlbum record);

    int insertSelective(TbImageAlbum record);

    TbImageAlbum selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbImageAlbum record);

    int updateByPrimaryKey(TbImageAlbum record);
}