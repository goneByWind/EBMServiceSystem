package com.lanou.picture.mapper;

import com.lanou.picture.bean.TbImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbImage record);

    int insertSelective(TbImage record);

    TbImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbImage record);

    int updateByPrimaryKey(TbImage record);

    /**
     * 查找所有图片
     *
     * @return 图片集合
     */
    List<TbImage> findAllImage();

    List<TbImage> fuzzyFindImage(@Param("startTime") String startTime,
                                 @Param("endTime") String endTime,
                                 @Param("name") String name);
}