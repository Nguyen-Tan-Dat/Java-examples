package org.dat.javasample.socket;

import org.dat.javasample.math.Prime;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

class Week1_Exercise5 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            System.out.println("Bài 1");
            if (input.contains("-")) System.out.println("Đầu vào không hợp lệ");
            else System.out.println("S=" + Week1.sum1toN(new BigInteger(input)));
            long n = Long.parseLong(input);
            System.out.println("Bài 2");
            if (n < 3) System.out.println("n phải thỏa n>=3");
            else System.out.println(Week1.sumDivisorN(n));
            System.out.println("Bài 3");
            if (n < 3) System.out.println("n phải thỏa n>=3");
            else System.out.println(Week1.sumPrimeToN((int) n));
            System.out.println("Bài 4");
            if (n < 1) System.out.println("n phải là số nguyên dương");
            else System.out.println(Week1.primeFactorization(n));
        } catch (Exception e) {
            System.out.println("Đầu vào không hợp lệ");
        }
    }
}

public class Week1 {


    public static BigInteger sum1toN(BigInteger n) {
        return n.multiply(n.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
    }

    public static BigInteger sumDivisorN(long n) {
        long square_rootN = (long) Math.sqrt(n);
        BigInteger sum = new BigInteger("0");
        for (long i = 1; i < square_rootN; i++)
            if (n % i == 0) sum = sum.add(BigInteger.valueOf(i).add(BigInteger.valueOf(n / i)));
        if (n % square_rootN == 0) return sum.add(BigInteger.valueOf(square_rootN));
        return sum;
    }

    public static long sumPrimeToN(int n) {
        boolean[] prime = Prime.tablePrimeEratosthenes(n);
        long sum = 0;
        for (int i = 2; i <= n; i++)
            if (Objects.requireNonNull(prime)[i]) sum += i;
        return sum;
    }

    public static String primeFactorization(long n) {
        StringBuilder result = new StringBuilder();
        byte index = 0;
        for (; n % 2 == 0; n /= 2)
            index++;
        if (index > 0) result.append(2 + "^").append(index).append("x");
        for (index = 0; n % 3 == 0; n /= 3)
            index++;
        if (index > 0) result.append(3 + "^").append(index).append("x");
        for (int i = 3; i <= Math.sqrt(n) - 2; i = i + 6)
            for (int j = i + 2; j < i + 5; j += 2) {
                for (index = 0; n % j == 0; n = n / j)
                    index++;
                if (index > 0) result.append(j).append("^").append(index).append("x");
            }
        if (n > 2) return result.toString() + n + "^" + "1";
        else return result.substring(0, result.length() - 1);
    }

    public static String primeFactors(long n) {
        StringBuilder result = new StringBuilder();
        byte index = 0;
        for (; n % 2 == 0; n /= 2)
            index++;
        if (index > 0) result.append(2 + "^").append(index).append("x");
        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            for (index = 0; n % i == 0; n = n / i)
                index++;
            if (index > 0) result.append(i).append("^").append(index).append("x");
        }
        if (n > 2) return result.toString() + n + "^" + "1";
        else return result.substring(0, result.length() - 1);
    }
}
