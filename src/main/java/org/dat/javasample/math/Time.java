package org.dat.javasample.math;

import java.util.Scanner;

public class Time {
    private byte hour, minute, second;

    public Time(byte hour, byte minute, byte second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public byte getHour() {
        return hour;
    }

    public void setHour(byte hour) {
        this.hour = hour;
    }

    public byte getMinute() {
        return minute;
    }

    public void setMinute(byte minute) {
        this.minute = minute;
    }

    public byte getSecond() {
        return second;
    }

    public void setSecond(byte second) {
        this.second = second;
    }

    public void add(Time time) {
        this.second += time.getSecond();
        if (this.second > 59) {
            this.second = (byte) (this.second % 60);
            this.minute++;
        }
        this.minute += time.getMinute();
        if (this.minute > 59) {
            this.minute = (byte) (this.minute % 60);
            this.hour++;
        }
        this.hour += time.getHour();
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public static void main(String[] args) {
        Time time = new Time((byte) 0, (byte) 0, (byte) 0);
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter time(example 00:00:00) or Exit enter space");
            String input = scan.nextLine();
            if (input.equals(" ")) break;
            String[] data = input.split(":");
            if (data.length == 3) {
                time.add(new Time(Byte.parseByte(data[0]), Byte.parseByte(data[1]), Byte.parseByte(data[2])));
                System.out.println(time);
            }
        }
    }
}
