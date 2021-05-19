package com.zhangjun.mall.nosql.elasticsearch.document;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 *
 * @Author zhangjun
 * @Date 2021/5/19
 */
@Document(indexName = "pms",indexStoreType = "product",shards = 1,replicas = 0)
public class EsProduct implements Serializable {
    private static final long serialVersionUID = -1L;
}
