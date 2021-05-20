package com.zhangjun.mall.service;

import com.zhangjun.mall.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * 商品搜索管理Service
 * @Author zhangjun
 * @Date 2021/5/20
 */
public interface EsProductService {

    /**
     * 从数据库中导入所有商品到ES
     * @return
     */
    int importAll();


    /**
     * 根据id删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
}
