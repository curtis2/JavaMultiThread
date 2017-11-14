package com.example.thread.createthread;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class SecondThread implements Runnable {
    @Override
    public void run() {
        //线程执行体...
    }

    public static void main(String[] args){
        SecondThread target=new SecondThread();
        //Runnable对象作为Thread的target
        Thread thread=new Thread(target);
        thread.start();
    }

}
