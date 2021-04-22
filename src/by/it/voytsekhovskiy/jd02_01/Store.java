package by.it.voytsekhovskiy.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static void main(String[] args) {
        List<Thread> buyers = new ArrayList<>(240);
        shopWork(buyers);
        for (Thread buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void shopWork(List<Thread> buyers) {
        int numBuyer = 0;
        System.out.println("Store opened");
        for (int i = 0; i < Config.WORK_TIME; i++) {
            int random = Util.getRandom(2);
            for (int j = 0; j < random; j++) {
                Buyer buyer = new Buyer((++numBuyer));
                if (numBuyer % 4 == 0) {
                    buyer.pensioner = true;
                }
                buyer.start();
                buyers.add(buyer);
                Util.sleep(1000); // почему сбивается порядок вывода
            }
        }
        System.out.println("Store closed");
    }
}
