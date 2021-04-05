package com.zhangjun.mall.service;

import com.zhangjun.mall.mbg.model.UmsAdmin;
import com.zhangjun.mall.mbg.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     * @param umsAdmin
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdmin);

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);


}
