package by.it.voytsekhovskiy.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 1; a <= 2 ; a+= 0.2) {
            double y = 0;
            for (double x = 1; x <= 6 ; x++) {
                y += Math.pow(7, a) - Math.cos(x);
            }
            System.out.printf("При a=%3.2f y = %10.8f\n", a, y);
        }
    }

    private static void step2() {
        for (double x = -5.5; x < 2 ; x=x+0.5) {
            double a = 0;
            if(x/2 > -2 && x/2 <= -1) {
                a = Math.log10(Math.sin(x*x) + 2.74);
                System.out.printf("При x/2=%5.2f a = %-10f\n", x/2, a);
            } else if (x/2 > -1 && x/2 < 0.2) {
                a = Math.log10(Math.cos(x*x) + 2.74);
                System.out.printf("При x/2=%5.2f a = %-10f\n", x/2,a);
            } else if (x/2 == 0.2) {
                a = Math.log10(Math.cos(x*x)/Math.sin(x*x) + 2.74);
                System.out.printf("При x/2=%5.2f a = %-10.8f\n", x/2,a);
            } else {
                System.out.printf("При x/2=%5.2f вычисления не определены\n", x/2);
            }
        }
    }
}
