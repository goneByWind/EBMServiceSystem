package com.lanou.picture.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.picture.bean.TbImage;
import com.lanou.picture.mapper.TbImageMapper;
import com.lanou.picture.service.ImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zar on 2017/11/14.
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    private TbImageMapper tbImageMapper;

    @Override
    public List<TbImage> findAllImage() {
        return tbImageMapper.findAllImage();
    }

    @Override
    public PageInfo<TbImage> getPageInfo(String startTime, String endTime, String name, Integer no, Integer size) {
        return pageInfo(startTime, endTime, name, no, size);
    }

    private PageInfo<TbImage> pageInfo(String startTime, String endTime, String name, Integer no, Integer size) {
        no = no == null ? 1 : no;
        size = size == null ? 5 : size;
        PageHelper.startPage(no, size);
        List<TbImage> tbImages = tbImageMapper.fuzzyFindImage(startTime, endTime, name);
        PageInfo<TbImage> pageInfo = new PageInfo<>(tbImages);
        return pageInfo;
    }
}
