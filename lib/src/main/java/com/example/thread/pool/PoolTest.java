package com.example.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class PoolTest {
    static ExecutorService executorService = Executors.newFixedThreadPool(6);
    public static void main(String args[]) throws Exception{
        //构建一个固定大小的线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


}
