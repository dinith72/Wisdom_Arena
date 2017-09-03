package sample;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

public class PdfDoc
{
    private static String loc = "E:\\dinith work\\MyProjects\\Wisdom_Arena\\pdf_output\\pdf2.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    public PdfDoc()
    {

    }

    // crate the document and the header
    public void createDoc()
    {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(loc)));
            document.open();
            document.addTitle("Wisdom Arena - Payment slip");
            document.addAuthor("Dinith Jayabodhi");

            Paragraph title = new Paragraph("Wisdom Arena",catFont);
//            title.add(new Paragraph("Wisdom Arena",catFont));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
