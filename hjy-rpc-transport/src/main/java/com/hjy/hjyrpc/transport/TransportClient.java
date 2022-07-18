package com.hjy.hjyrpc.transport;

import com.hjy.hjyrpc.Peer;

import java.io.InputStream;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/16 16:06
 * 1.创建链接
 * 2.发送数据，并等待响应
 * 3.关闭链接
 */
public interface TransportClient {
    void connect(Peer peer);
    InputStream write(InputStream data);
    void close();
}
