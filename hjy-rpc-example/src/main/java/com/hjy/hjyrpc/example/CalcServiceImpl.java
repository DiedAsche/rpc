package com.hjy.hjyrpc.example;

/**
 * @author hjy
 * @version V1.0
 * @date 2022/7/18 14:39
 */
public class CalcServiceImpl implements CalcService{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }
}
