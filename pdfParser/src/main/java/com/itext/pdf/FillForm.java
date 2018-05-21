package com.itext.pdf;

import com.itext.xml.XMLToMap;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Simple filling out form example.
 */
public class FillForm {

    public static final String SRC = "src/main/resources/pdf/moneta_OA_zivnoleasing_08_2017.pdf";
    public static final String XML = "src/main/resources/xml/zivnoleasing.xml";
    public static final String DEST = "results/moneta_OA_zivnoleasing_08_2017_filled.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new FillForm().manipulatePdf(SRC, DEST);
    }


    public Map<String, String> getXmlToMap(String uri) {
        XMLToMap xmlToMap = new XMLToMap();
        Map<String, String> map = null;
        try {
            map = xmlToMap.convertToMap(XML);
//            Set<String> keys = map.keySet();
//            for (String key : keys) {
//                System.out.println("Key [" + key + "] value [" + map.get(key) + "]");
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void setField(Map<String, PdfFormField> fields, String key, String value) {
        if (fields.containsKey(key)) fields.get(key).setValue(value);
    }


    public void manipulatePdf(String src, String dest) throws IOException {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfReader(src), new PdfWriter(dest));
        PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);


        Map<String, String> map = getXmlToMap(XML);
        Map<String, PdfFormField> fields = form.getFormFields();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            setField(fields, key, map.get(key));
        }
        pdf.close();

    }
}
