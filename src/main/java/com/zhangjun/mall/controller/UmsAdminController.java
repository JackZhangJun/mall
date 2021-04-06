package com.zhangjun.mall.controller;

import com.zhangjun.mall.common.api.CommonResult;
import com.zhangjun.mall.dto.UmsAdminLoginParam;
import com.zhangjun.mall.mbg.model.UmsAdmin;
import com.zhangjun.mall.mbg.model.UmsPermission;
import com.zhangjun.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "UmsAdminController",description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result)
    {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin ==null)
        {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam,BindingResult result)
    {
        String token = adminService.login(umsAdminLoginParam.getUername(),umsAdminLoginParam.getPassword());
        if (token == null)
        {
            return CommonResult.validateFailed("用户名或密码错误");
        }

        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId)
    {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }

    @ApiOperation("更新指定用户密码")
    @RequestMapping(value = "/updatepassword/{username}",method = RequestMethod.POST)
    public CommonResult updateUmsAdminPassword(@PathVariable("username") String username,@RequestParam String password)
    {
        CommonResult commonResult;
        int count = adminService.updatePassword(username,password);
        if (count ==1)
        {
            commonResult = CommonResult.success("更新密码成功");
        }
        else
        {
            commonResult = CommonResult.failed("更新密码失败");
        }

        return commonResult;

    }
}
