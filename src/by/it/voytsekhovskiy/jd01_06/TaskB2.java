package by.it.voytsekhovskiy.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static StringBuilder step1() {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("\\.{3}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            int start = matcher.start();
            sb.delete(start, start + 3);
        }
        return sb;
    }

    private static String[] step2(StringBuilder text) {
        Pattern pattern = Pattern.compile("[\\.\\?\\!]");
        String[] arr = pattern.split(text);
        return arr;
    }

    private static String[] step3(String[] arrayOfSentence) {
        Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ]");
        for (int i = 0; i < arrayOfSentence.length; i++) {
            StringBuilder sb = new StringBuilder(arrayOfSentence[i]);
            Matcher matcher = pattern.matcher(arrayOfSentence[i]);
            while (matcher.find()) {
                sb.setCharAt(matcher.start(), ' ');
                arrayOfSentence[i] = sb.toString().trim().replaceAll("\\s{2,}", " ");
            }
        }
        return arrayOfSentence;
    }

    private static String[] sort(String[] arr) {
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].length() > arr[i + 1].length()) {
                    String buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
        }
        while (swap);
        return arr;
    }


    public static void main(String[] args) {
        StringBuilder withoutDots = step1();
        String[] arrOfSentence = step2(withoutDots);
        String[] cleanArr1 = step3(arrOfSentence);
        String[] sortArr = sort(cleanArr1);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.println(sortArr[i]);
        }

    }
}