package by.it.voytsekhovskiy.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    final private Integer num;
    Boolean pensioner = false;
    private double K_SPEED = 1;

    public Buyer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        isPensioner();
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
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
            System.out.printf("Buyer #%d put %s with price %s\n", num, nameElement, valueOfElement);
            Util.sleep((int) (Util.getRandom(500, 2000) * K_SPEED));
        }
        System.out.printf("Buyer #%d finish choose goods\n", num);
    }

    @Override
    public void goOut() {
        System.out.printf("Buyer #%d go out\n", num);
    }

    private void isPensioner() {
        if (pensioner) {
            K_SPEED = 1.5;
        }
    }
}
