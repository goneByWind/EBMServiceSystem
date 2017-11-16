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

    @RequiresPermissions("article")
    @RequestMapping(value = "/articlelist")
    public String articleList() {
        return "article-list";
    }

    @RequiresPermissions("picture")
    @RequestMapping(value = "/picturelist")
    public String pictureList() {
        return "picture-list";
    }

    @RequiresPermissions("product")
    @RequestMapping(value = "/productbrand")
    public String productBrand() {
        return "product-brand";
    }

    @RequiresPermissions("product")
    @RequestMapping(value = "/productCategory")
    public String productCategory() {
        return "product-category";
    }

    @RequiresPermissions("product")
    @RequestMapping(value = "/productlist")
    public String productList() {
        return "product-list";
    }

    @RequiresPermissions("feed")
    @RequestMapping(value = "/feedbacklist")
    public String feedbackList() {
        return "feedback-list";
    }

    @RequiresPermissions("member")
    @RequestMapping(value = "/memberlist")
    public String memberList() {
        return "member-list";
    }

    @RequiresPermissions("member")
    @RequestMapping(value = "/memberdel")
    public String memberDel() {
        return "member-del";
    }

    @RequiresPermissions("member")
    @RequestMapping(value = "/memberlevel")
    public String memberLevel() {
        return "member-level";
    }

    @RequiresPermissions("member")
    @RequestMapping(value = "/memberscoreoperation")
    public String memberScoreoperation() {
        return "member-scoreoperation";
    }

    @RequiresPermissions("member")
    @RequestMapping(value = "/memberrecordbrowse")
    public String memberRecordBrowse() {
        return "member-record-browse";
    }

    @RequiresPermissions("member")
    @RequestMapping(value = "/memberrecorddownload")
    public String memberRecordDownload() {
        return "member-record-download";
    }

    @RequiresPermissions("member")
    @RequestMapping(value = "/memberrecordshare")
    public String memberRecordShare() {
        return "member-record-share";
    }

    @RequiresPermissions("authc")
    @RequestMapping(value = "/adminrole")
    public String adminRole() {
        return "admin-role";
    }

    @RequiresPermissions("authc")
    @RequestMapping(value = "/adminpermission")
    public String adminPermission() {
        return "admin-permission";
    }

    @RequiresPermissions("authc")
    @RequestMapping(value = "/adminlist")
    public String adminList() {
        return "admin-list";
    }

    @RequiresPermissions("chart")
    @RequestMapping(value = "/charts1")
    public String charts1() {
        return "charts-1";
    }

    @RequiresPermissions("chart")
    @RequestMapping(value = "/charts2")
    public String charts2() {
        return "charts-2";
    }

    @RequiresPermissions("chart")
    @RequestMapping(value = "/charts3")
    public String charts3() {
        return "charts-3";
    }

    @RequiresPermissions("chart")
    @RequestMapping(value = "/charts4")
    public String charts4() {
        return "charts-4";
    }

    @RequiresPermissions("chart")
    @RequestMapping(value = "/charts5")
    public String charts5() {
        return "charts-5";
    }

    @RequiresPermissions("chart")
    @RequestMapping(value = "/charts6")
    public String charts6() {
        return "charts-6";
    }

    @RequiresPermissions("chart")
    @RequestMapping(value = "/charts7")
    public String charts7() {
        return "charts-7";
    }

    @RequiresPermissions("system")
    @RequestMapping(value = "/systembase")
    public String systemBase() {
        return "system-base";
    }

    @RequiresPermissions("system")
    @RequestMapping(value = "/systemcategory")
    public String systemCategory() {
        return "system-category";
    }

    @RequiresPermissions("system")
    @RequestMapping(value = "/systemdata")
    public String systemData() {
        return "system-data";
    }

    @RequiresPermissions("system")
    @RequestMapping(value = "/systemshielding")
    public String systemShielding() {
        return "system-shielding";
    }

    @RequiresPermissions("system")
    @RequestMapping(value = "/systemlog")
    public String systemLog() {
        return "system-log";
    }

    @RequiresPermissions("article-list")
    @RequestMapping(value = "/articleadd")
    public String articleAdd() {
        return "article-add";
    }

    @RequiresPermissions("picture-list")
    @RequestMapping(value = "/pictureadd")
    public String pictureAdd() {
        return "picture-add";
    }

    @RequiresPermissions("product-list")
    @RequestMapping(value = "/productadd")
    public String productAdd() {
        return "product-add";
    }

    @RequiresPermissions("member-listr")
    @RequestMapping(value = "/memberadd")
    public String memberAdd() {
        return "member-add";
    }
}
