package by.it.voytsekhovskiy.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private final AtomicInteger countGoInBuyers = new AtomicInteger(0);
    private final AtomicInteger countGoOutBuyers = new AtomicInteger(0);

    public void addGoInBuyer() {
            countGoInBuyers.getAndIncrement();
    }

    public void addGoOutBuyer() {
            countGoOutBuyers.getAndIncrement();
    }

    boolean isOpenedStore() {
        return countGoInBuyers.get() != Config.PLAN;
    }

    boolean isClosedStore() {
        return countGoOutBuyers.get() == Config.PLAN;
    }

}
