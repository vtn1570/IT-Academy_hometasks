package by.it.voytsekhovskiy.jd02_03;

import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private double K_SPEED = 1;
    final private Integer numBuyer;
    Boolean pensioner = false;
    private boolean waiting = false;
    private final Object MONITOR;
    private double totalCheck = 0.00;
    private final Context context;
    private static final Semaphore semaphore = new Semaphore(20);

    public double getTotalCheck() {
        return totalCheck;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Buyer(int num, Context context) {
        this.context = context;
        this.numBuyer = num;
        context.getManager().addGoInBuyer();
        MONITOR = this;
    }

    public Object getMONITOR() {
        return MONITOR;
    }

    public Integer getNumBuyer() {
        return numBuyer;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            isPensioner();
            enterToMarket();
            takeBasket();
            chooseGoods();
            putGoodsToBasket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.printf("Buyer #%d entering in store\n", numBuyer);
    }

    @Override
    public void takeBasket() {
        System.out.printf("Buyer #%d take basket\n", numBuyer);
        Util.sleep((int) (Util.getRandom(500, 2000) * K_SPEED));
    }

    @Override
    public void chooseGoods() {
        System.out.printf("Buyer #%d start choose goods\n", numBuyer);
        Util.sleep((int) (Util.getRandom(500, 2000) * K_SPEED));
    }

    @Override
    public void putGoodsToBasket() {
        int countGoods = Util.getRandom(1, 4);
        for (int i = 0; i < countGoods; i++) {
            String nameElement = Assortment.getRandomElement();
            Double valueOfElement = Assortment.assortment.get(nameElement);
            totalCheck = totalCheck + valueOfElement;
            System.out.printf("Buyer #%d put %s with price %s\n", numBuyer, nameElement, valueOfElement);
            Util.sleep((int) (Util.getRandom(500, 2000) * K_SPEED));
        }
        System.out.printf("Buyer #%d finish choose goods\n", numBuyer);
    }

    @Override
    public void goToQueue() {
        synchronized (MONITOR) {
            System.out.printf("Buyer #%d go to queue\n", numBuyer);
            context.getQueueBuyers().addBuyerInQueue(this);
            waiting = true;
            while (waiting) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.printf("Buyer #%d go out\n", numBuyer);
        context.getManager().addGoOutBuyer();
    }

    @Override
    public void isPensioner() {
        if (pensioner) {
            K_SPEED = 1.5;
        }
    }
}
