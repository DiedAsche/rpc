package com.hjy.hjyrpc.example;

import com.hjy.hjyrpc.server.RPCServer;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/18 14:37
 */
public class Server {
    public static void main(String[] args) {
        RPCServer server = new RPCServer();
        // Rpcserver server = new Rpcserver();
        server.register(CalcService.class,new CalcServiceImpl());
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
