package com.hjy.hjyrpc.transport;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/16 16:32
 * 1.启动监听端口
 * 2.等待网络客户端，接受请求
 * 3.关闭监听
 */
public interface TransportServer {
    void init(int port,RequestHandler handler);

    void start();

    void stop();

}
