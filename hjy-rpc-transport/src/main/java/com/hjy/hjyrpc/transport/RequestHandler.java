package com.hjy.hjyrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/16 16:40
 * 网络请求处理的handler
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream toResp);
}
