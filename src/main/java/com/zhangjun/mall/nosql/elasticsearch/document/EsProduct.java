package com.zhangjun.mall.nosql.elasticsearch.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @Author zhangjun
 * @Date 2021/5/18 下午11:34
 * @Version 1.0
 */
@Document(indexName = "pms",indexStoreType = "product",shards = 1,replicas = 0)
public class EsProduct implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private Long id;
    @Field(type = FieldType.Keyword)
    private String productSn;

    private Long brandId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
