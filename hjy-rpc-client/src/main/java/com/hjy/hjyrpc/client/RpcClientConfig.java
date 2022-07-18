package com.hjy.hjyrpc.client;

import com.hjy.hjyrpc.Peer;
import com.hjy.hjyrpc.codec.Decoder;
import com.hjy.hjyrpc.codec.Encoder;
import com.hjy.hjyrpc.codec.JSONDecoder;
import com.hjy.hjyrpc.codec.JSONEncoder;
import com.hjy.hjyrpc.transport.HTTPTransportClient;
import com.hjy.hjyrpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/17 22:19
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> tranportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> transportSelector = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1",3000));
}
