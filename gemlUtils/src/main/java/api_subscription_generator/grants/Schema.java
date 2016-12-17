package api_subscription_generator.grants;

import settings.Settings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Schema {

    private String schemaJoin;


    public ArrayList<String> get() {
        BufferedReader br = null;
        ArrayList<String> schemas = new ArrayList<>();

        try {
            String sCurrentLine;

            br = new BufferedReader(new FileReader(Settings.inFile));

            while ((sCurrentLine = br.readLine()) != null) {
                schemas.add(sCurrentLine);
            }

            return schemas;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return schemas;
        }

    }

}
