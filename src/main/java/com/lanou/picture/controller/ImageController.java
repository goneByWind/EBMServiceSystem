package com.lanou.picture.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.picture.service.ImageService;
import com.lanou.utils.AjaxResult;
import com.lanou.picture.bean.TbImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zar on 2017/11/14.
 */
@Controller
public class ImageController {
    @Resource
    private ImageService imageService;

    @ResponseBody
    @RequestMapping(value = "/allimage")
    public AjaxResult findAllImage() {
        List<TbImage> allImage = imageService.findAllImage();
        return new AjaxResult(allImage, 0, null);
    }

    @ResponseBody
    @RequestMapping(value = "/findImagePageInfo", method = RequestMethod.POST)
    public AjaxResult findPageInfo(@RequestParam("startTime") String startTime,
                                   @RequestParam("endTime") String endTime,
                                   @RequestParam("name") String name,
                                   @RequestParam("no") Integer no,
                                   @RequestParam("size") Integer size) {
        if (startTime == null || startTime.trim().isEmpty()) {
            startTime = null;
        }
        if (endTime == null || endTime.trim().isEmpty()) {
            Date now = new Date();
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            endTime = f.format(now);
        }
        if (name == null || name.trim().isEmpty()) {
            name = null;
        }
        PageInfo<TbImage> pageInfo = imageService.getPageInfo(startTime, endTime, name, no, size);
        return new AjaxResult(pageInfo, 0, null);
    }
}
