package by.it.voytsekhovskiy.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class CheckoutQueue {
    final static Object monitorQueue = new Object();

    static Deque<Buyer> queueOfBuyers = new LinkedList<>();

    static void addBuyerInQueue(Buyer buyer) {
        synchronized (monitorQueue) {
            Cashier.wakeUpCashier();
            queueOfBuyers.addLast(buyer);
        }
    }

    static Buyer getFirstBuyerInQueue() {
        synchronized (monitorQueue) {
            return queueOfBuyers.pollFirst();
        }
    }
}
