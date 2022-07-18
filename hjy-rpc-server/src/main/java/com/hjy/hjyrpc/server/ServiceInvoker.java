package com.hjy.hjyrpc.server;

import com.hjy.hjyrpc.Request;
import com.hjy.hjyrpc.common.utils.ReflectionUtils;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/17 19:51
 * 调用具体服务
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service,
                         Request request){
        return ReflectionUtils.invoke(service.getTarget(),
                                      service.getMethod(),
                                      request.getParameters()
        );
    }
}
