package by.it.voytsekhovskiy.jd02_01;


import java.util.concurrent.ThreadLocalRandom;

public class Util {

    static Integer getRandom(int min, int max) {
        return ThreadLocalRandom
                .current()
                .nextInt((max-min)+1) + min;
    }

    static Integer getRandom(int max) {
        return ThreadLocalRandom
                .current()
                .nextInt(max+1);
    }
    static void sleep(Integer timeout) {
        try {
            Thread.sleep(timeout / Config.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
