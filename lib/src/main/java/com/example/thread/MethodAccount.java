package com.example.thread;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */
public class MethodAccount {
   private String accountNO;
   private double balance;

   public MethodAccount(){
   }

   public MethodAccount(String accountNO, double balance) {
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
        if(obj!=null&&obj.getClass()==MethodAccount.class){
            MethodAccount account= (MethodAccount) obj;
            return account.getAccountNO().equals(accountNO);
        }
        return false;
    }

    /**
     * 锁如果没有被释放，那其他地方就不能调用这个锁锁定的代码
     */
    public synchronized  void  draw(String name,double drawAmount){
            if(balance>=drawAmount){
                System.out.println(name+"取钱成功！ 取出="+drawAmount);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //修改金额
                balance=balance-drawAmount;
                System.out.println("\t 余额为："+balance);
            }else{
                System.out.println(name+"取钱失败，账号余额不足！");
            }
    }

    public  void adraw(){
      /*  try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("----adraw-----");
    }


}
