package com.hjy.hjyrpc.server;


import com.hjy.hjyrpc.codec.Decoder;
import com.hjy.hjyrpc.codec.Encoder;
import com.hjy.hjyrpc.common.utils.ReflectionUtils;
import com.hjy.hjyrpc.transport.RequestHandler;
import com.hjy.hjyrpc.transport.TransportServer;
import com.hjy.hjyrpc.Request;
import com.hjy.hjyrpc.Response;
import com.hjy.hjyrpc.codec.Decoder;
import com.hjy.hjyrpc.codec.Encoder;
import com.hjy.hjyrpc.common.utils.ReflectionUtils;
import com.hjy.hjyrpc.transport.RequestHandler;
import com.hjy.hjyrpc.transport.TransportServer;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/17 19:55
 */
@Slf4j
public class RPCServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public  RPCServer(){
        this(new RpcServerConfig());
    }
    public RPCServer(RpcServerConfig config) {
        this.config = config;
        //net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(),this.handler);
        //codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());
        //service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();

    }
    public <T> void register(Class<T> interfaceClass,T bean){
        serviceManager.register(interfaceClass,bean);
    }
    public void start() {
        this.net.start();
    }
    public void stop() {
        this.net.stop();
    }
    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream receive, OutputStream toResp) {
            Response resp = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(receive,receive.available());
                Request request = decoder.decode(inBytes,Request.class);
                log.info("get request: {}",request);
                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis, request);
                resp.setData(ret);

            } catch (Exception e) {
                log.warn(e.getMessage(),e);
                resp.setCode(1);
                resp.setMessage("RpcServer get error:"+e.getClass().getName()+":"+e.getMessage());
            }finally {

                try {
                    byte[] outBytes =encoder.encode(resp);
                    toResp.write(outBytes);
                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(),e);
                }
            }
        }
    };

}
