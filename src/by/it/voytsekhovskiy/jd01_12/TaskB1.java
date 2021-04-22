package by.it.voytsekhovskiy.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String line = sc.nextLine();
            if (!line.equals("end")) {
                sb.append(line);
            } else {
                break;
            }
        }
        countWords(sb.toString());
    }


    static void countWords(String txt) {
        Map<String, Integer> result = new HashMap<>();
        Pattern pt = Pattern.compile("[a-zA-Z\']+");
        Matcher matcher = pt.matcher(txt);
        while (matcher.find()) {
            if(result.containsKey(matcher.group())) {
                result.put(matcher.group(), result.get(matcher.group()) + 1);
            } else {
                result.put(matcher.group(), 1);
            }
        }
        System.out.println(result);
    }
}
