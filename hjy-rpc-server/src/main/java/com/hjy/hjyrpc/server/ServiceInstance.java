package com.hjy.hjyrpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/17 17:06
 * 表示一个具体的服务
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;
}
