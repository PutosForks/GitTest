package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class IndianArt {
    public static void main(String[] args) {
        ResourceBundle labels = ResourceBundle.getBundle
                ("IndianArtLabelsBundle");


        String text = null;
        text = labels.getString("total_bookings");
        System.out.println(text);
        text = labels.getString("when");
        System.out.println(text);
        text = labels.getString("price");
        System.out.println(text);
        text = labels.getString("book_now");
        System.out.println(text);
        //ia.setLocaleSpecificData(new Locale("fr"));

        labels = ResourceBundle.getBundle
                ("IndianArtLabelsBundle", new Locale("fr"));


        text = null;
        text = labels.getString("total_bookings");
        System.out.println(text);
        text = labels.getString("when");
        System.out.println(text);
        text = labels.getString("price");
        System.out.println(text);
        text = labels.getString("book_now");
        System.out.println(text);
        //ia.setLocaleSpecificData(new Locale("fr"));
    }

}


