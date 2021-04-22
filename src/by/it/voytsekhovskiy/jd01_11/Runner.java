package by.it.voytsekhovskiy.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;

public class Runner {
    public static void main(String[] args) {
        SetC<String> hash = new SetC<>();
        hash.add("one");
        hash.add("two");
        hash.add(null);

        SetC<String> hash2 = new SetC<>();
        hash2.add("one");
        hash2.add("two2");
        hash2.add(null);
        System.out.println(hash.removeAll(hash2));
        hash.clear();
        System.out.println(hash);
//
//        HashSet<String> hash3 = new HashSet<>();


//        List<String> list = new ArrayList<>();
//        list.add("one");
//        list.add(null);
//        System.out.println(hash.addAll(list));
//        System.out.println(hash);
    }
}
