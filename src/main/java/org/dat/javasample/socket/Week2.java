package org.dat.javasample.socket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.StringTokenizer;

class Week2_Exercise1 {
    public static String calculate(String input) {
        try {
            input="0+"+input;
            StringTokenizer data = new StringTokenizer(input.replaceAll("\\s", ""), "+-*/", true);
            BigDecimal result = new BigDecimal(data.nextToken());
            String calculation = data.nextToken();
            BigDecimal nextValue = new BigDecimal(data.nextToken());
            while (data.hasMoreTokens()) {
                String calculationNext = data.nextToken();
                if (calculationNext.equals("+") || calculationNext.equals("-")) {
                    if (calculation.equals("+")) result = result.add(nextValue);
                    else result = result.subtract(nextValue);
                    calculation = calculationNext;
                    nextValue = new BigDecimal(data.nextToken());
                } else if (calculationNext.equals("*"))
                    nextValue = nextValue.multiply(new BigDecimal(data.nextToken()));
                else {
                    BigDecimal temp = new BigDecimal(data.nextToken());
                    try {
                        nextValue = nextValue.divide(temp);
                    } catch (ArithmeticException e) {
                        nextValue = nextValue.divide(temp, 1000, RoundingMode.UP);
                    }
                }
            }
            if (calculation.equals("+")) return result.add(nextValue).toString();
            if (calculation.equals("-")) return result.subtract(nextValue).toString();
        } catch (NumberFormatException ignored) {}
        return "Syntax error";
    }

    public static void main(String[] args) {
        String input = "100000000000000000000000000000000000000000/3/3/3/3/3";
        System.out.println(calculate(input));
        System.out.println(calculate("12/3*4/16"));
    }
}

class Week2_Exercise2 {
    public static void main(String[] args) {
        String input = " Dai hoc sai gon la mot trong nhung truong dai hoc lau doi nhat sai gon";
        HashMap<String, String> result = new HashMap<>();
        StringTokenizer st = new StringTokenizer(input, " ");
        while (st.hasMoreTokens()) {
            String i = st.nextToken();
            if (result.get(i.toLowerCase()) == null) {
                result.put(i.toLowerCase(), i);
                System.out.print(" " + i);
            }
        }
    }
}

class Week2_Exercise3 {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.translateWord("Good"));
        System.out.println(dictionary.translateWord("Tốt"));
        System.out.println(dictionary.translateWord("Hello"));
    }
}
