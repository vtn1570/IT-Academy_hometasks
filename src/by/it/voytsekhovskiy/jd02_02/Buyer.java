package by.it.voytsekhovskiy.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private double K_SPEED = 1;
    final private Integer num; // номер покупателя
    Boolean pensioner = false;
    private boolean waiting = false;
    private final Object MONITOR;
    private double totalCheck = 0.00;

    public double getTotalCheck() {
        return totalCheck;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Buyer(int num) {
        this.num = num;
        Manager.addGoInBuyer();
        MONITOR = this;
    }

    public Object getMONITOR() {
        return MONITOR;
    }

    public Integer getNum() {
        return num;
    }

    @Override
    public void run() {
        isPensioner();
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.printf("Buyer #%d entering in store\n", num);
    }

    @Override
    public void takeBasket() {
        System.out.printf("Buyer #%d take basket\n", num);
        Util.sleep((int) (Util.getRandom(500, 2000) * K_SPEED));
    }

    @Override
    public void chooseGoods() {
        System.out.printf("Buyer #%d start choose goods\n", num);
        Util.sleep((int) (Util.getRandom(500, 2000) * K_SPEED));
    }

    @Override
    public void putGoodsToBasket() {
        int countGoods = Util.getRandom(1, 4);
        for (int i = 0; i < countGoods; i++) {
            String nameElement = Assortment.getRandomElement();
            Double valueOfElement = Assortment.assortment.get(nameElement);
            totalCheck = totalCheck + valueOfElement;
            System.out.printf("Buyer #%d put %s with price %s\n", num, nameElement, valueOfElement);
            Util.sleep((int) (Util.getRandom(500, 2000) * K_SPEED));
        }
        System.out.printf("Buyer #%d finish choose goods\n", num);
    }

    private void goToQueue() {
        synchronized (MONITOR) {
            System.out.printf("Buyer #%d go to queue\n", num);
            CheckoutQueue.addBuyerInQueue(this);
            waiting = true; // зачем создавать флаг, если у каждого объекта свой монитор
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
        System.out.printf("Buyer #%d go out\n", num);
        Manager.addGoOutBuyer();
    }

    private void isPensioner() {
        if (pensioner) {
            K_SPEED = 1.5;
        }
    }
}
