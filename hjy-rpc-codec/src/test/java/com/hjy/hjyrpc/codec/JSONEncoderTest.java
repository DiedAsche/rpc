package com.hjy.hjyrpc.codec;

import junit.framework.TestCase;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/15 21:18
 */
public class JSONEncoderTest extends TestCase {

    public void testEncode() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("hjy");
        bean.setAge(18);
        byte[] bytes = encoder.encode(bean);
        assertNotNull(bytes);
    }
}