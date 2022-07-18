package com.hjy.hjyrpc.example;

import com.hjy.hjyrpc.client.RpcClient;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/18 14:37
 */
public class Client {
    public static void main(String[] args) {
        RpcClient rpcClient = new RpcClient();
        CalcService service = rpcClient.getProxy(CalcService.class);
        //CalcInterface proxy = rpcClient.getProxy(CalcInterface.class);
        int add = service.add(1, 2);
        int minus = service.minus(2, 1);
        System.out.println("add="+ add + ", minus=" + minus);
    }
}
