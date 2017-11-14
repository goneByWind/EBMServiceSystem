package com.lanou.base.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zar on 2017/11/9.
 */
@Controller
public class BaseController {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequiresPermissions({"user:add"})
    @RequestMapping(value = "/articlelist")
    public String articleList() {
        return "article-list";
    }

    @RequestMapping(value = "/picturelist")
    public String pictureList() {
        return "picture-list";
    }

    @RequestMapping(value = "/productbrand")
    public String productBrand() {
        return "product-brand";
    }

    @RequestMapping(value = "/productCategory")
    public String productCategory() {
        return "product-category";
    }

    @RequestMapping(value = "/productlist")
    public String productList() {
        return "product-list";
    }

    @RequestMapping(value = "/feedbacklist")
    public String feedbackList() {
        return "feedback-list";
    }

    @RequestMapping(value = "/memberlist")
    public String memberList() {
        return "member-list";
    }

    @RequestMapping(value = "/memberdel")
    public String memberDel() {
        return "member-del";
    }

    @RequestMapping(value = "/memberlevel")
    public String memberLevel() {
        return "member-level";
    }

    @RequestMapping(value = "/memberscoreoperation")
    public String memberScoreoperation() {
        return "member-scoreoperation";
    }

    @RequestMapping(value = "/memberrecordbrowse")
    public String memberRecordBrowse() {
        return "member-record-browse";
    }

    @RequestMapping(value = "/memberrecorddownload")
    public String memberRecordDownload() {
        return "member-record-download";
    }

    @RequestMapping(value = "/memberrecordshare")
    public String memberRecordShare() {
        return "member-record-share";
    }

    @RequestMapping(value = "/adminrole")
    public String adminRole() {
        return "admin-role";
    }

    @RequestMapping(value = "/adminpermission")
    public String adminPermission() {
        return "admin-permission";
    }

    @RequestMapping(value = "/adminlist")
    public String adminList() {
        return "admin-list";
    }

    @RequestMapping(value = "/charts1")
    public String charts1() {
        return "charts-1";
    }

    @RequestMapping(value = "/charts2")
    public String charts2() {
        return "charts-2";
    }

    @RequestMapping(value = "/charts3")
    public String charts3() {
        return "charts-3";
    }

    @RequestMapping(value = "/charts4")
    public String charts4() {
        return "charts-4";
    }

    @RequestMapping(value = "/charts5")
    public String charts5() {
        return "charts-5";
    }

    @RequestMapping(value = "/charts6")
    public String charts6() {
        return "charts-6";
    }

    @RequestMapping(value = "/charts7")
    public String charts7() {
        return "charts-7";
    }

    @RequestMapping(value = "/systembase")
    public String systemBase() {
        return "system-base";
    }

    @RequestMapping(value = "/systemcategory")
    public String systemCategory() {
        return "system-category";
    }

    @RequestMapping(value = "/systemdata")
    public String systemData() {
        return "system-data";
    }

    @RequestMapping(value = "/systemshielding")
    public String systemShielding() {
        return "system-shielding";
    }

    @RequestMapping(value = "/systemlog")
    public String systemLog() {
        return "system-log";
    }

    @RequestMapping(value = "/articleadd")
    public String articleAdd() {
        return "article-add";
    }
    @RequestMapping(value = "/pictureadd")
    public String pictureAdd() {
        return "picture-add";
    }
    @RequestMapping(value = "/productadd")
    public String productAdd() {
        return "product-add";
    }
    @RequestMapping(value = "/memberadd")
    public String memberAdd() {
        return "member-add";
    }
}
