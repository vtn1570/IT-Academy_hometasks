package by.it.voytsekhovskiy.jd02_02;

public class Manager {
    final static Object monitorGoInBuyers = 0;
    final static Object monitorGoOutBuyers = 0;
    private static Integer countGoInBuyers = 0;
    private static Integer countGoOutBuyers = 0;

    public static void addGoInBuyer() {
        synchronized (Manager.monitorGoInBuyers) {
            countGoInBuyers++;
        }
    }

    public static void addGoOutBuyer() {
        synchronized (Manager.monitorGoOutBuyers) {
            countGoOutBuyers++;
        }
    }

    static boolean isOpenedStore() {
        return countGoInBuyers != Config.PLAN;
    }

    static boolean isClosedStore() {
        return countGoOutBuyers == Config.PLAN;
    }

    public static Integer getCountGoInBuyers() {
        return countGoInBuyers;
    }

    public static Integer getCountGoOutBuyers() {
        return countGoOutBuyers;
    }
}
