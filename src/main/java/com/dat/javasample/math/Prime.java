package com.dat.javasample.math;

public class Prime {
    public boolean isPrimeBase(long number) {
        if (number < 2) return false;
        long square_rootValue = (long) Math.sqrt(number);
        for (long i = 2; i <= square_rootValue; i++)
            if (number % i == 0) return false;
        return true;
    }

    public boolean isPrime23(long number) {
        if (number == 2 || number == 3) return true;
        if (number < 2 || number % 2 == 0 || number % 3 == 0) return false;
        long square_rootValue = (long) Math.sqrt(number);
        for (long i = 3; i <= square_rootValue - 2; i += 6)
            if (number % (i + 2) == 0 || number % (i + 4) == 0) return false;
        return true;
    }

    public static boolean isPrime(long number) {
        if (number == 2 || number == 3 || number == 5) return true;
        if (number < 2 || number % 2 == 0 || number % 3 == 0 || number % 5 == 0) return false;
        long square_rootValue = (long) Math.sqrt(number);
        for (long i = 5; i <= square_rootValue - 2; i += 30)
            if (number % (i + 2) == 0
                    || number % (i + 6) == 0
                    || number % (i + 8) == 0
                    || number % (i + 12) == 0
                    || number % (i + 14) == 0
                    || number % (i + 18) == 0
                    || number % (i + 24) == 0
                    || number % (i + 26) == 0) return false;
        return true;
    }

    public static boolean[] tablePrimeEratosthenes(int maximum) {
        if (maximum < 2) return null;
        boolean[] prime = new boolean[maximum + 1];
        for (int i = 2; i <= maximum; i++)
            prime[i] = true;
        int sqrt_n = (int) Math.sqrt(maximum);
        for (int i = 2; i <= maximum; i++)
            if (prime[i])
                if (i <= sqrt_n)
                    for (long j = i * i; j <= maximum; j += i)
                        prime[(int) j] = false;
        return prime;
    }

    public static boolean[] tablePrimeEratosthenesBase(int maximum) {
        if (maximum < 2) return null;
        boolean[] prime = new boolean[maximum + 1];
        for (int i = 2; i <= maximum; i++)
            prime[i] = true;
        for (int i = 2; i <= maximum; i++)
            if (prime[i])
                for (long j = i + i; j <= maximum; j += i)
                    prime[(int) j] = false;
        return prime;
    }
}
