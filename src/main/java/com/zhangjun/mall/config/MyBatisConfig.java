package com.zhangjun.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.zhangjun.mall.mbg.mapper","com.zhangjun.mall.dao"})
public class MyBatisConfig {
}
