package com.dat.javasample.math;

import java.util.ArrayList;

public class MyMoney {
    private int amount;
    private final int value;

    public MyMoney(int value, int amount) {
        this.amount = amount;
        this.value = value;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getValue() {
        return value;
    }

    public static long sum(ArrayList<MyMoney> myMonies) {
        long sum = 0;
        for (var m : myMonies) {
            sum += (long) m.getAmount() * m.getValue();
        }
        return sum;
    }

    public static ArrayList<MyMoney> greedy(ArrayList<MyMoney> myMonies, long habit) {
        ArrayList<MyMoney> result = new ArrayList<>();
        myMonies.sort((o1, o2) -> {
            if (o1.getValue() > o2.getValue()) return 1;
            return -1;
        });
        int sum = 0;
        while (!myMonies.isEmpty()) {
            MyMoney best = myMonies.remove(myMonies.size() - 1);
            int amount = 0;
            while (amount < best.getAmount() && sum + best.getValue() <= habit) {
                sum += best.getValue();
                amount++;
            }
            if (amount > 0) {
                best.setAmount(amount);
                result.add(best);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<MyMoney> moneys = new ArrayList<>();
        moneys.add(new MyMoney(1000, 1));
        moneys.add(new MyMoney(2000, 1));
        moneys.add(new MyMoney(5000, 1));
        moneys.add(new MyMoney(10000, 1));
        moneys.add(new MyMoney(200000, 1));
        moneys.add(new MyMoney(500000, 1));
        moneys.add(new MyMoney(20000, 1));
        moneys.add(new MyMoney(50000, 1));
        moneys.add(new MyMoney(100000, 1));
        int habit = 712000;
        var rs = MyMoney.greedy(moneys, habit);
        for (MyMoney r : rs) System.out.println(r.value + " x " + r.amount);
        if (MyMoney.sum(rs) != habit) {
            System.out.println("Không thể thói tiền với các tờ tiền hiện có");
        }
    }
}
