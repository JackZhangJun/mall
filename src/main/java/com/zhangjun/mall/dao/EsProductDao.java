package com.zhangjun.mall.dao;

import com.zhangjun.mall.nosql.elasticsearch.document.EsProduct;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义Dao
 * @Author zhangjun
 * @Date 2021/5/20
 */
public interface EsProductDao {

    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
