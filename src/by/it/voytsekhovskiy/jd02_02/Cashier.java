package by.it.voytsekhovskiy.jd02_02;

public class Cashier implements Runnable {
    Integer num;
    static int cashierInWork = 0;
    private final static Object CASHIER_MONITOR = new Object();

    Cashier(Integer num) {
        this.num = num;
    }

    public static Object getCashierMonitor() {
        return CASHIER_MONITOR;
    }

    @Override
    public void run() {
        synchronized (CASHIER_MONITOR) {
            try {
                CASHIER_MONITOR.wait(); // все кассиры спят
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!Manager.isClosedStore()) {
            System.out.printf("\tCashier #%d start work\n", num);
        }

        while (!Manager.isClosedStore()) {
            Buyer firstBuyerInQueue = CheckoutQueue.getFirstBuyerInQueue();
            if (firstBuyerInQueue != null) {
                synchronized (firstBuyerInQueue.getMONITOR()) {
                    int buyerNum = firstBuyerInQueue.getNum();
                    System.out.printf("\tCashier #%d started service the buyer #%d\n", num, buyerNum);
                    Integer timeout = Util.getRandom(2000, 5000);
                    Util.sleep(timeout);
                    System.out.printf("\tCashier #%d finished service the buyer #%d\n", num, buyerNum);
                    System.out.printf("\t\t Total amount of buyer's check #%d : %.2f$\n",
                            buyerNum, firstBuyerInQueue.getTotalCheck());
                    firstBuyerInQueue.setWaiting(false);
                    firstBuyerInQueue.notify(); // не всегда просыпается покупатель!
                }
            } else {
                Util.sleep(1);
            }
        }

        System.out.printf("\tCashier #%d end work\n", num);
    }

    static void wakeUpCashier() {
        synchronized (getCashierMonitor()) {
            if (CheckoutQueue.queueOfBuyers.size() % 5 == 0
                    && CheckoutQueue.queueOfBuyers.size() / 5 >= cashierInWork) {
                cashierInWork++;
                getCashierMonitor().notify();
            }
        }
    }

    public static void wakeUpAllCashier() {
        synchronized (Cashier.getCashierMonitor()) {
            getCashierMonitor().notifyAll();
        }
    }
}
