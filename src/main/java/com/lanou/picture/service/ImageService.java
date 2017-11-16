package com.lanou.picture.service;

import com.github.pagehelper.PageInfo;
import com.lanou.picture.bean.TbImage;

import java.util.List;

/**
 * @author zar on 2017/11/14.
 */
public interface ImageService {
    List<TbImage> findAllImage();

    PageInfo<TbImage> getPageInfo(String startTime, String endTime, String name, Integer no, Integer size);
}
