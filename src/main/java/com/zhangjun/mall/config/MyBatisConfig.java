package com.zhangjun.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.zhangjun.mall.mbg.mapper")
public class MyBatisConfig {
}
