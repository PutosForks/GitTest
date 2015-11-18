package localization;

import java.util.Locale;

public class DefaultLocale {
    public static void main(String[] args) {
       Locale myLocale =  Locale.getDefault();
        System.out.println(myLocale.getCountry());
        System.out.println(myLocale.getDisplayCountry());
        System.out.println(myLocale.getLanguage());
        System.out.println(myLocale.getDisplayLanguage());


        Locale.setDefault(new Locale("cz"));
        Locale myLocale2 =  Locale.getDefault();

        System.out.println(myLocale2.getCountry());
        System.out.println(myLocale2.getDisplayCountry());
        System.out.println(myLocale2.getLanguage());     // cz
        System.out.println(myLocale2.getDisplayLanguage());   // cz

    }
}
