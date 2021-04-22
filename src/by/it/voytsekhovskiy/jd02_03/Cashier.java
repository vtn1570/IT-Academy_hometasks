package by.it.voytsekhovskiy.jd02_03;

public class Cashier implements Runnable {
    Integer num;
    static int cashierInWork = 0;
    private static final Object CASHIER_MONITOR = new Object();
    private final Context context;

    Cashier(Integer num, Context context) {
        this.num = num;
        this.context = context;
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

        if (!context.getManager().isClosedStore()) {
            System.out.printf("\tCashier #%d start work\n", num);
        }

        while (!context.getManager().isClosedStore()) {
            Buyer firstBuyerInQueue = context.getQueueBuyers().getFirstBuyerInQueue();
            if (firstBuyerInQueue != null) {
                synchronized (firstBuyerInQueue.getMONITOR()) {
                    int buyerNum = firstBuyerInQueue.getNumBuyer();
                    System.out.printf("\tCashier #%d started service the buyer #%d\n", num, buyerNum);
                    Integer timeout = Util.getRandom(2500, 5000);
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
            if (QueueBuyer.queueOfBuyers.size() % 5 == 0
                    && QueueBuyer.queueOfBuyers.size() / 5 >= cashierInWork) {
                cashierInWork++;
                getCashierMonitor().notify();
            }
        }
    }

    static void wakeUpAllCashier() {
        synchronized (getCashierMonitor()) {
            getCashierMonitor().notifyAll();
        }
    }
}
