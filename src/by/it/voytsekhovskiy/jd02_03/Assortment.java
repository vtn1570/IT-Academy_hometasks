package by.it.voytsekhovskiy.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assortment {
    public static Map<String, Double> assortment = new HashMap<>() {
        {
            this.put("Milk", 2.99);
            this.put("Bread", 3.99);
            this.put("Sugar", 1.99);
            this.put("Strawberries", 4.99);
        }
    };

    static String getRandomElement() {
        List<String> keys = new ArrayList<>(assortment.keySet());
        Integer random = Util.getRandom(assortment.size() - 1);
        return keys.get(random);
    }
}
