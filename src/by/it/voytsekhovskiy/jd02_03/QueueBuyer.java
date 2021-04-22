package by.it.voytsekhovskiy.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyer {
     static BlockingDeque<Buyer> queueOfBuyers = new LinkedBlockingDeque<>(30);

     void addBuyerInQueue(Buyer buyer) {
            Cashier.wakeUpCashier();
        try {
            queueOfBuyers.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     Buyer getFirstBuyerInQueue() {
            return queueOfBuyers.pollFirst();
    }
}
