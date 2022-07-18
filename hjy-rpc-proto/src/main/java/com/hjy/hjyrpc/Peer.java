package com.hjy.hjyrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
   * @author hjy
   * 表示网络传输的一个端点
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
