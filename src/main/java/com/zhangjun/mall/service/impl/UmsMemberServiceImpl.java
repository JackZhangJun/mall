package com.zhangjun.mall.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.zhangjun.mall.common.api.CommonResult;
import com.zhangjun.mall.service.RedisService;
import com.zhangjun.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;


    @Override
    public CommonResult generateAuthCode(String telephone) {
        UUID uuid = UUID.randomUUID();

        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,uuid.toString());

        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);

        return CommonResult.success(uuid.toString(),"获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode))
        {
            return CommonResult.failed("请输入验证码");
        }

        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE+telephone);

        boolean result = authCode.equals(realAuthCode);
        if (result)
        {
            return CommonResult.success(null,"验证码教研成功");
        }
        else
        {
            return CommonResult.failed("验证码不正确");
        }
    }
}
