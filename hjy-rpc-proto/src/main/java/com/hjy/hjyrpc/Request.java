package com.hjy.hjyrpc;

import lombok.Data;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/15 16:59
 * 表示一个rpc请求
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;

}
