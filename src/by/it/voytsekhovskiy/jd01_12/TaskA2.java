package by.it.voytsekhovskiy.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> resultSet = new HashSet<>(a);
        resultSet.addAll(b);
        return resultSet;
    }
    static Set<Integer> getCross(Set<Integer>a, Set<Integer> b) {
        HashSet<Integer> resultSet = new HashSet<>(a);
        resultSet.retainAll(b);
        return resultSet;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 7, 22};
        Integer[] b = {8, 4, 6, 2, 21, 7, 12, 7, 9, 9};
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(a));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(b));
        System.out.println(hashSet);
        TaskA2.getCross(hashSet, treeSet);
        System.out.println(hashSet);
    }
}
