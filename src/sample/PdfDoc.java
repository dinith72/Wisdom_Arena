package sample;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.util.Calendar;


import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class PdfDoc
{
    private static String loc = "E:\\dinith work\\MyProjects\\Wisdom_Arena\\pdf_output\\pdf2.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 14,
            Font.NORMAL);
    private static Font subFontBld = new Font(Font.FontFamily.HELVETICA, 14,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);


    private  String datePdf ;
    private String stuName = "dinith chathuranga jayabodhixxxxxxxxxxxxxxxxxxxxxxx";
    private String month = "january";
    private String contactNoStu ;
    private String contactNoGrd;

    public PdfDoc()
    {

    }
    public  void setDate(String date) {
        this.datePdf = date;
    }


    // crate the document and the header
    public void createDoc()
    {
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(loc)));
            document.open();
            document.addTitle("Wisdom Arena - Payment slip");
            document.addAuthor("Dinith Jayabodhi");

//adding the wisdom arena logo
            Image img = Image.getInstance("src\\sample\\assets\\images\\wanew.jpg");
            img.setAbsolutePosition(10,720);

            document.add(img);

// adding the title to the headr
            Paragraph title = new Paragraph("Wisdom Arena",catFont);

//            title.add(new Paragraph("Wisdom Arena",catFont));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

//adding the adress and the content to the header
            Paragraph adress = new Paragraph("No: 106, Station Road, Kandana, Sri Lanka",smallBold);
            adress.setAlignment(Element.ALIGN_CENTER);
            document.add(adress);

//            adding a seperator

            PdfContentByte canvas = writer.getDirectContent();
            canvas.moveTo(36, 700);
            canvas.lineTo(559, 700);
            canvas.stroke();

//            adding name
            ColumnText name = new ColumnText(writer.getDirectContent());
            name.setSimpleColumn(50,650,550,680);
            name.setText( new Phrase("Name : " + stuName,smallBold));
            name.go();


//            adding the date
            ColumnText date = new ColumnText(writer.getDirectContent());
            date.setSimpleColumn(50,620,250,645);
            date.setText(new Phrase( "Date : " + datePdf, smallBold));
            date.go();

//          adding month
            ColumnText mnt = new ColumnText(writer.getDirectContent());
            mnt.setSimpleColumn(275,620,550,645);
            mnt.setText(new Phrase( "Month : " + month, smallBold));
            mnt.go();


//            Paragraph date= new Paragraph("Date "+ this.date,smallBold);
            PdfPTable table = new PdfPTable(3);

//            adding the tittles
            PdfPCell refNo = new PdfPCell(new Paragraph("Ref. No.",subFont));
            refNo.setBackgroundColor(BaseColor.LIGHT_GRAY);
            refNo.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell subject = new PdfPCell(new Paragraph("Subject",subFont));
            subject.setBackgroundColor(BaseColor.LIGHT_GRAY);
            subject.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell amnt = new PdfPCell(new Paragraph("Amount",subFont));
            amnt.setBackgroundColor(BaseColor.LIGHT_GRAY);
            amnt.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(refNo);
            table.addCell(subject);
            table.addCell(amnt);

//          adding the content
            for ( int i =0 ; i < 15 ; i++)
            {
                PdfPCell conRefNo = new PdfPCell(new Paragraph("one"));
//
                table.addCell(conRefNo);

                PdfPCell conSubject = new PdfPCell(new Paragraph("teo"));

                table.addCell(conSubject);

                PdfPCell conAmnt = new PdfPCell(new Paragraph("three"));

                table.addCell(conAmnt);

            }

//            adding the total cell
                PdfPCell totalStr = new PdfPCell(new Paragraph("TOTAL",subFontBld));
                totalStr.setColspan(2);
                totalStr.setHorizontalAlignment(Element.ALIGN_CENTER);


                PdfPCell totalNu = new PdfPCell(new Paragraph("100",subFontBld));
                totalNu.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(totalStr);
                table.addCell(totalNu);




//            table.setTotalWidth(550);

            ColumnText tab = new ColumnText(writer.getDirectContent());
            tab.setSimpleColumn(50,200,550,600);

            tab.addElement(table);
            tab.go();



//            line.setOffset(3);
//            document.add(line);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}


