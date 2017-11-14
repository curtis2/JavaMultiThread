package com.example.thread.createthread;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */
public class FirstThread  extends Thread{
    @Override
    public void run() {
        super.run();
        //线程执行体...
    }

    public static void main(String[] args){
        FirstThread firstThread=new FirstThread();
        firstThread.start();
    }
}
