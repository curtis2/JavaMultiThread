package com.example.thread.notify;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */
public class DrawThread extends Thread{

    //取钱的用户
    private Account account;

    //当前线程所希望取的钱
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount){
        super(name);
        this.account=account;
        this.drawAmount=drawAmount;
    }


    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            account.draw(drawAmount);
        }

    }


}
