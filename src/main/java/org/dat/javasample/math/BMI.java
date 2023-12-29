package org.dat.javasample.math;

public record BMI(double height, double weight) {

    public String diagnostic() {
        double number = weight / (height * height);
        System.out.println(number);
        if (number < 18.5) return "Suy dinh dưỡng";
        double number1 = (weight - height) / (height * height);
        if (number1 < 18.5) return "Nguy cơ nhẹ cân ";
        if (number >= 20.3 && number <= 21.9) return "Chỉ số đẹp";
        double number2 = (weight + height) / (height * height);
        if (number < 23)
            if (number2 >= 23) return "Nguy cơ thừa cân";
            else return "Bình thường";
        if (number < 25) return "Tiền béo phì";
        if (number < 30) return "Béo phì độ I";
        if (number < 35)return "Béo phì độ II";
        return "Béo phì độ III";
    }

    public static void main(String[] args) {
        for (int i = 50; i < 80; i++)
            System.out.println(i + " " + (new BMI(1.65, i)).diagnostic());
    }
}
