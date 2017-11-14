package com.example.thread;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 * 同步代码块
 *
 * // 测试结果：如果同步代码块锁定后，同步代码外后面的代码也是无法执行的
 *
 */
public class SyncCodeDrawThread extends Thread{

    //取钱的用户
    private Account account;

    //当前线程所希望取的钱
    private double drawAmount;

    public SyncCodeDrawThread(String name, Account account, double drawAmount){
        super(name);
        this.account=account;
        this.drawAmount=drawAmount;
    }

    @Override
    public void run() {
        synchronized (this){
            if(account.getBalance()>=drawAmount){
                System.out.println(getName()+"取钱成功！ 取出="+drawAmount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //修改金额
                account.setBalance(account.getBalance()-drawAmount);
                System.out.println("\t 余额为："+account.getBalance());
            }else{
                System.out.println(getName()+"取钱失败，账号余额不足！");
            }
        }
        System.out.println("测试同步代码块后面的代码能否执行！");
    }



}
