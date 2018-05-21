package com.itext.pdf;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfButtonFormField;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Simple filling out form example.
 */
public class FillForm {

    public static final String SRC = "src/main/resources/pdf/moneta_OA_zivnoleasing_08_2017.pdf";
    public static final String DEST = "results/moneta_OA_zivnoleasing_08_2017_filled.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new FillForm().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfReader(src), new PdfWriter(dest));
        l
        PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
        Map<String, PdfFormField> fields = form.getFormFields();
        fields.get("COMPANY_NAME").setValue("Malik Petr");
        fields.get("ICO").setValue("078978745").setJustification(PdfFormField.ALIGN_CENTER);
        fields.get("DIC").setValue("5879875");
        fields.get("VAT_PAYER_1").setValue("Off");
        fields.get("EMP_CNT").setValue("3");
        fields.get("DN").setValue("30.11.1980");

        PdfButtonFormField checkField = (PdfButtonFormField) fields.get("Radio1");

        String[] values = checkField.getAppearanceStates();
        for (String value : values) {
            System.out.println(value);
        }

        checkField.setValue("Gamma");
        fields.get("FF").setValue("OL");

        System.out.println(fields.containsKey("NE1"));
        System.out.println(fields.containsKey("NE8"));
        pdf.close();

    }
}
