package com.hjy.hjyrpc;

import lombok.Data;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/15 17:04
 * 表示rpc的返回
 */
@Data
public class Response {
    /**
     * 服务返回编码 0-成功，非0-失败
     */
    private int code= 0 ;
    /**
     * 具体错误信息
     */
    private String message = "ok";
    /**
     * 返回的数据
     */
    private Object data;
}
