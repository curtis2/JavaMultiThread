package com.example.thread;

public class MethodTest {

    public static void main(String args[]) throws Exception {
//        for (int i = 0; i <1000 ; i++) {
            MethodAccount account=new MethodAccount("123456",1000);
            new MethodDrawThread("A",account,800).start();
            Thread.sleep(1000);
            new MethodDrawThread("B",account,800).start();
//        }
    }


}
