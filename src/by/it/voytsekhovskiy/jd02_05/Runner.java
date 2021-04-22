package by.it.voytsekhovskiy.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String language, country;
        for (; ; ) {
            String s = sc.nextLine();
            if (!s.equals("end")) {
                switch (s) {
                    case "be":
                        language = "be";
                        country = "BY";
                        break;
                    case "ru":
                        language = "ru";
                        country = "RU";
                        break;
                    case "en":
                        language = "en";
                        country = "EN";
                        break;
                    default:
                        language = Locale.getDefault().getLanguage();
                        country = Locale.getDefault().getCountry();
                }
                String date = CurrentDate.getCurrentDate(language, country);
                Language lang = Language.INSTANCE; // ?
                lang.setLocale(new Locale(language, country));
                System.out.println(lang.get(Messages.WELCOME));
                System.out.println(lang.get(Messages.QUESTION));
                System.out.println(date);
            } else {
                break;
            }
        }
    }
}
