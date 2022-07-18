package com.hjy.hjyrpc.client;

import com.hjy.hjyrpc.Peer;
import com.hjy.hjyrpc.transport.TransportClient;

import java.util.List;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/17 21:32
 * 表示选择哪个server去链接
 */
public interface TransportSelector {
    /**
     * 初始化selector
     * @param peers 可以链接的server端点信息
     * @param count client与server建立多少个链接
     * @param clazz client实现
     */
    void init(List<Peer> peers,int count,Class<? extends TransportClient> clazz);
    /**
     * 选择一个transport与server做交互
     * @return 网络client
     */
    TransportClient select();

    /**
     * 释放用完的client
     * @param client
     */
    void release(TransportClient client);

    void close();

}
