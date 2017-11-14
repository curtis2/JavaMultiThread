package com.example.thread;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 * 同步代码块
 *
 * // 测试结果：如果同步代码块锁定后，同步代码外后面的代码也是无法执行的
 *
 */
public class MethodDrawThread extends Thread{

    //取钱的用户
    private MethodAccount account;

    //当前线程所希望取的钱
    private double drawAmount;

    public MethodDrawThread(String name, MethodAccount account, double drawAmount){
        super(name);
        this.account=account;
        this.drawAmount=drawAmount;
    }

    @Override
    public void run() {
        if(getName().equals("A")){
            account.draw(getName(),drawAmount);
        }else{
            account.adraw();
        }
    }




}
