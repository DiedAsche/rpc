package com.hjy.hjyrpc.codec;

import junit.framework.TestCase;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/15 21:59
 */
public class JSONDecoderTest extends TestCase {

    public void testDecode() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("hjy");
        bean.setAge(18);
        byte[] bytes = encoder.encode(bean);
        Decoder decoder = new JSONDecoder();
        TestBean bean2 = decoder.decode(bytes,TestBean.class);
        assertEquals(bean.getName(),bean2.getName());
        assertEquals(bean.getAge(),bean2.getAge());
    }
}