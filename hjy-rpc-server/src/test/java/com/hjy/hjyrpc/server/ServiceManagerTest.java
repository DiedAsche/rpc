package com.hjy.hjyrpc.server;

import com.hjy.hjyrpc.Request;
import com.hjy.hjyrpc.ServiceDescriptor;
import com.hjy.hjyrpc.common.utils.ReflectionUtils;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/17 19:22
 */
public class ServiceManagerTest  {
    ServiceManager sm;
    @Before
    public void init(){
        sm = new ServiceManager();
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }
    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }
    @Test
    public void testLookup() {
        Method method= ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class,method);
        Request request = new Request();
        request.setService(sdp);
        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);

    }
}