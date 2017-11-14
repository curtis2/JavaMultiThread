package com.example.thread.notify;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class Account {
    private String accountNO;
    private double balance;
    //标识用户是否已有存款的旗标
    private boolean flag=false;

    public Account(){
    }

    public Account(String accountNO, double balance) {
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

    @Override
    public int hashCode(){
        return  accountNO.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj!=null&&obj.getClass()==Account.class){
            Account account= (Account) obj;
            return account.getAccountNO().equals(accountNO);
        }
        return false;
    }

    public synchronized void draw(double drawAmount){
        System.out.println(Thread.currentThread().getName()+"-draw");
        try {
            //如果flag为假，表明账号中还没有人存钱进去，取钱方法阻塞
            if(!flag){
               //释放锁
                System.out.println(Thread.currentThread().getName()+"-wait");
                wait();
                System.out.println(Thread.currentThread().getName()+"after-wait");
            }else{
               //执行取钱操作
                System.out.println(Thread.currentThread().getName()+"取钱："+drawAmount);
                balance-=drawAmount;
                System.out.println("账号余额为："+balance);
                //将标识账号是否已有存款的旗标设为false
                flag=false;
                //唤起其他线程
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //同步方法，锁的是this对象。 同一时间只有一个线程可以进入这个方法
    public synchronized void deposit(double depositAmount){
        System.out.println(Thread.currentThread().getName()+"-deposit");
        try {
            //如果flag为真，表明账号中已有人存钱进去，存钱方法阻塞
            if(flag){
                System.out.println(Thread.currentThread().getName()+"-wait");
                wait();
            }else{
                //执行存钱操作
                System.out.println(Thread.currentThread().getName()+"存款："+depositAmount);
                balance+=depositAmount;
                System.out.println("账号余额为："+balance);
                //将标识账号是否已有存款的旗标设为false
                flag=true;
                //唤起其他线程
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



}
