package com.itext.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;

import java.io.*;
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


        PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
        Map<String, PdfFormField> fields = form.getFormFields();
        fields.get("COMPANY_NAME").setValue("Black Barry");
        fields.get("ICO").setValue("078978745").setJustification(PdfFormField.ALIGN_CENTER);
        fields.get("DIC").setValue("5879875");
        fields.get("VAT_PAYER").setValue("On");
        fields.get("EMP_CNT").setValue("50");
        fields.get("datum33").setValue("30.11.1980");
        fields.get("doba12").setValue("2");
        System.out.println(fields.get("doba1").getFieldName());
        System.out.println(fields.containsKey("NE1"));
        System.out.println(fields.containsKey("NE8"));
        pdf.close();

    }
}
