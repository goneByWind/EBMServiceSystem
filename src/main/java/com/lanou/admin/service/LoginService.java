package com.lanou.admin.service;

import com.lanou.admin.bean.SysUser;
import org.springframework.stereotype.Service;

/**
 * @author zar on 2017/11/9.
 */
public interface LoginService {
    SysUser getUser(String username);
}
