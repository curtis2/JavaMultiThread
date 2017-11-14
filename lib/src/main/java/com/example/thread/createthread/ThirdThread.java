package com.example.thread.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */
public class ThirdThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        //线程执行体..
        return "A";
    }

    public static void main(String[] args){
        try {
         ThirdThread thirdThread=new ThirdThread();
         FutureTask<String> task=new FutureTask(thirdThread);
         //将构建的FutureTask作为target传入Thread中
         new Thread(task).start();
         //获取线程执行的返回值
         System.out.println(task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
