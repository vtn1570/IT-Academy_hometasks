package by.it.voytsekhovskiy.jd01_01;

import java.util.Locale;
import java.util.Scanner;

class TaskC3 {

    public static double getWeight(int a) {
        double divisionMars = 3.86 / 9.81;
        double res = divisionMars * a;
        return Double.valueOf(String.format(Locale.ROOT, "%.2f", res));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weightEarth = sc.nextInt();
        double i = getWeight(weightEarth);
        System.out.println(i);
    }
}
