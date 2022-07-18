package com.hjy.hjyrpc.codec;


import com.alibaba.fastjson.JSON;

/**
 * 基于json的序列化实现
 * @author hjy
 * @version V1.0
 * @date 2022/7/15 20:21
 */
public class JSONEncoder implements Encoder{
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
