package com.hjy.hjyrpc.codec;

/**
 * 序列化
 * @author hjy
 * @version V1.0
 * @date 2022/7/15 20:09
 */
public interface Encoder {
    byte[] encode(Object obj);
}
