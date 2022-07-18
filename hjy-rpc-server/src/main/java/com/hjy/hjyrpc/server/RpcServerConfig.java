package com.hjy.hjyrpc.server;


import com.hjy.hjyrpc.codec.Decoder;
import com.hjy.hjyrpc.codec.Encoder;
import com.hjy.hjyrpc.codec.JSONDecoder;
import com.hjy.hjyrpc.codec.JSONEncoder;
import com.hjy.hjyrpc.transport.HTTPTransportServer;
import com.hjy.hjyrpc.transport.TransportServer;
import lombok.Data;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/16 21:37
 * server配置
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;

}
