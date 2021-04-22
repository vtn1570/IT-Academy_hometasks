package by.it.voytsekhovskiy.jd01_10;

public class Bean {
    @Param(a = 2, b = 5)
    double sum(int a, int b) {
        return (double) a + b;
    }

    @Param(a = 2, b = 5)
    double max(int a, int b) {
        return (double) Math.max(a, b);
    }

    @Param(a = 2, b = 5)
    static double min(int a, int b) {
        return (double) Math.min(a, b);
    }

    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
