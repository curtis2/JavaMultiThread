package com.example.thread;

public class SyncCodeTest {

    public static void main(String args[]) throws Exception {
//        for (int i = 0; i <1000 ; i++) {
            Account account=new Account("123456",1000);
            new SyncCodeDrawThread("A",account,800).start();
            new SyncCodeDrawThread("B",account,800).start();
//        }
    }


}
