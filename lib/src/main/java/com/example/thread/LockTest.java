package com.example.thread;

public class LockTest {

    public static void main(String args[]) throws Exception {
//        for (int i = 0; i <1000 ; i++) {
            LockAccount account=new LockAccount("123456",1000);
            new LockDrawThread("A",account,800).start();
            new LockDrawThread("B",account,800).start();
//        }
    }


}
