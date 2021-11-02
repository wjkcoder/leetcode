package cn.phorcys.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/28 下午5:44
 */
class Bank {
    Map<Integer, Long> accountMap = new ConcurrentHashMap<>();

    public Bank(long[] balance) {
        for (int i = 0; i < balance.length; i++) {
            accountMap.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!accountMap.containsKey(account1) || !accountMap.containsKey(account2)) return false;
        if(account1==account2)return true;
        Long m1 = accountMap.get(account1);
        if (accountMap.get(account1) < money) return false;
        accountMap.put(account1, m1 - money);
        Long m2 = accountMap.get(account2);
        accountMap.put(account2, m2 + money);
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!accountMap.containsKey(account)) return false;
        if(money==0)return true;
        if (money < 0) return false;
        Long m = accountMap.get(account);
        accountMap.put(account, m + money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!accountMap.containsKey(account)) return false;
        if(money==0)return true;
        Long m = accountMap.get(account);
        if (m < money) return false;
        accountMap.put(account, m - money);
        return true;
    }

    public static void main(String[] args) {
        long[] arr = new long[1];
        arr[0] = 0;
        Bank bank = new Bank(arr);
        boolean deposit1 = bank.deposit(1, 1000000000000L);
        boolean transfer = bank.transfer(1, 1, 1000000000000L);
        boolean withdraw = bank.withdraw(1, 1000000000000L);
        boolean deposit = bank.deposit(1, 0);
        boolean transfer1 = bank.transfer(1, 1, 0);
        boolean withdraw1 = bank.withdraw(1, 0);
    }
}
