package by.it.voytsekhovskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static final String votes = "уеэоаыяиюёУЕЫАОЭЯИЮЁ";
    private static boolean consonantsAndVowels(String word) {
        return votes.indexOf(word.charAt(0)) < 0 && votes.indexOf(word.charAt(word.length()-1)) >= 0;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);

        while(matcher.find()) {
            String word = matcher.group();
            if(consonantsAndVowels(word)) {
                System.out.println(word);
            }
        }
    }
}
