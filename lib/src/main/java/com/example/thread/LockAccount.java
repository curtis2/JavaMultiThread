package com.example.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */
public class LockAccount {
   private String accountNO;
   private double balance;

    private  final ReentrantLock look=new ReentrantLock();

   public LockAccount(){
   }

   public LockAccount(String accountNO, double balance) {
        this.accountNO = accountNO;
        this.balance = balance;
   }

    public String getAccountNO() {
        return accountNO;
    }

    public void setAccountNO(String accountNO) {
        this.accountNO = accountNO;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode(){
        return  accountNO.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj!=null&&obj.getClass()==LockAccount.class){
            LockAccount account= (LockAccount) obj;
            return account.getAccountNO().equals(accountNO);
        }
        return false;
    }

    public  void  draw(String name,double drawAmount){
         //加锁
          look.lock();
         try {
            if(balance>=drawAmount){
                System.out.println(name+"取钱成功！ 取出="+drawAmount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //修改金额
                balance=balance-drawAmount;
                System.out.println("\t 余额为："+balance);
            }else{
                System.out.println(name+"取钱失败，账号余额不足！");
            }
        }finally {
            //释放锁
            look.unlock();
        }
    }

}
