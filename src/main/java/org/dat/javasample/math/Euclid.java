package org.dat.javasample.math;

public class Euclid {
    public static int gcd(int p, int q) {
        for (int temp; q != 0; p = temp) {
            temp = q;
            q = p % q;
        }
        return p;
    }
}