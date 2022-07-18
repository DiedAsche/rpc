package com.hjy.hjyrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json的反序列化
 * @author hjy
 * @version V1.0
 * @date 2022/7/15 21:14
 */
public class JSONDecoder implements Decoder{
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }
}
