package by.it.voytsekhovskiy.jd02_06;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Logger logger = Logger.getLogger();
                logger.log("Test");
            }).start();
        }
    }
}
