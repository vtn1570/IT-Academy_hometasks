package by.it.voytsekhovskiy.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static void main(String[] args) {
        List<Thread> buyers = new ArrayList<>(240);
        int numBuyer = 0;

        System.out.println("Store opened");

        for (int i = 1; i <= Config.CASHIER; i++) {
            Thread cashier = new Thread(new Cashier(i));
            cashier.start();
        }

        while (Manager.isOpenedStore()) {
            int random = Util.getRandom(2);
            for (int j = 0; j < random && Manager.isOpenedStore(); j++) {
                Buyer buyer = new Buyer((++numBuyer));
                if (numBuyer % 4 == 0) {
                    buyer.pensioner = true;
                }
                buyer.start();
                buyers.add(buyer);
            }
            Util.sleep(1000);
        }
        for (Thread buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Cashier.wakeUpAllCashier();
        Util.sleep(1000);
        System.out.println("Store closed");
    }
}
