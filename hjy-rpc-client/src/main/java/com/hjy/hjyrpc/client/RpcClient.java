package com.hjy.hjyrpc.client;

import com.hjy.hjyrpc.codec.Decoder;
import com.hjy.hjyrpc.codec.Encoder;
import com.hjy.hjyrpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/18 10:41
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;
    public RpcClient(){
        this(new RpcClientConfig());
    }
    public RpcClient(RpcClientConfig config){
        this.config = config;
        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getTransportSelector());

        this.selector.init(this.config.getServers(),this.config.getConnectCount(),this.config.getTranportClass());

    }

    public <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz,encoder,decoder,selector));
    }
}
