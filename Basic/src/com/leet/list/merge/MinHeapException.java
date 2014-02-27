package com.leet.list.merge;

/**
 * 堆异常
 * 
 * @since jdk1.5及其以上
 * @author 毛正吉
 * @version 1.0
 * @date 2010.05.24
 */
public class MinHeapException extends Exception {
    public MinHeapException() {
        super("MinHeapException");
    }

    public MinHeapException(String exMsg) {
        super(exMsg);
    }
}