package by.it.voytsekhovskiy.calc;

import java.util.Locale;
import java.util.ResourceBundle;

enum Language {
    INSTANCE;

    private final String BASE = "by/it/voitsekhovskiy/calc/resources/language";
    static ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }

    private void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE, locale);
    }

    static String get(String key) {
        return bundle.getString(key);
    }
}
