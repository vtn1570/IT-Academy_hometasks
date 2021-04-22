package by.it.voytsekhovskiy.jd02_03;

public class Context {
    private final QueueBuyer queueBuyer;
    private final Manager manager;

    public Context(QueueBuyer queueBuyer, Manager manager) {
        this.queueBuyer = queueBuyer;
        this.manager = manager;
    }

    public QueueBuyer getQueueBuyers() {
        return queueBuyer;
    }

    public Manager getManager() {
        return manager;
    }
}
