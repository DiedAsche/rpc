package com.hjy.hjyrpc.codec;

/**
 * 反序列化
 * @author hjy
 * @version V1.0
 * @date 2022/7/15 20:12
 */
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}
