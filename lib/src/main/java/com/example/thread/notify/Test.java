package com.example.thread.notify;


public class Test {

    public static void main(String args[]) throws Exception {
            Account account=new Account("123456",0);
            DrawThread a = new DrawThread("取钱者", account, 800);
            a.start();
            new DepositThread("存款者A",account,800).start();
            new DepositThread("存款者B",account,800).start();
            new DepositThread("存款者C",account,800).start();
    }


}
