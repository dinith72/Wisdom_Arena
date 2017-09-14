package sample;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class PdfDoc
{
    public static void setLoc(String loc) {
        PdfDoc.loc = loc;
    }

    //    private static String loc = "E:\\dinith work\\MyProjects\\Wisdom_Arena\\pdf_output\\pdf2.pdf";
    private static String loc = "E:\\dinith work\\MyProjects\\Wisdom_Arena\\pdf_output\\pdf2.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 24,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 13,
            Font.NORMAL);
    private static Font subFontBld = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);
    private static Font xtrasmall = new Font(Font.FontFamily.TIMES_ROMAN, 10,
            Font.NORMAL);


    private  String datePdf ;
    private String stuName ;
    private String month ;
    private String grade ;
    private String syllabusPdf ;
    private double total;
    List<String> refId; ;
    List <String> subjects ;
    List <Double> amount ;

    public PdfDoc()
    {

    }
    public  void setDate(String date) {
        this.datePdf = date;
    }


    // crate the document and the header
    public void createDocStudentCpy()
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

// adding the title to the headr and the subtitlte ( lead to Excellence)
            Paragraph title = new Paragraph("Wisdom Arena",catFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            Paragraph subTitle = new Paragraph("Lead To Excellence",subFontBld);
            subTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(subTitle);

//adding the adress and the content to the header
            Paragraph adress = new Paragraph("No: 106, Station Road, Kandana, Sri Lanka \n email : wisdomarena2017@gmail.com   T.P. : 0769039960",xtrasmall);
            adress.setAlignment(Element.ALIGN_CENTER);
            document.add(adress);

//            adding the student copy label
           Rectangle rec = new Rectangle(475,735,550,785);
           rec.setBorder(Rectangle.BOX);
           rec.setBorderWidth(2);
           document.add(rec);

           ColumnText ctrec = new ColumnText(writer.getDirectContent());
           ctrec.setSimpleColumn(rec);
//           ctrec.setAlignment(Element.ALIGN_CENTER);
            Paragraph pr = new Paragraph("Student's \n Copy");
            pr.setAlignment(Element.ALIGN_CENTER);
           ctrec.addElement(pr);
           ctrec.go();

//            adding a seperator

            PdfContentByte canvas = writer.getDirectContent();
            canvas.moveTo(36, 713);
            canvas.lineTo(559, 713);
            canvas.stroke();

//            adding name
            ColumnText name = new ColumnText(writer.getDirectContent());
            name.setSimpleColumn(50,650,325,680);
            name.setText( new Phrase("Name : " + stuName,smallBold));
            name.go();

//            adding syllabus
            ColumnText syllabus = new ColumnText(writer.getDirectContent());
            name.setSimpleColumn(375,650,550,680);
            name.setText( new Phrase("Syllabus : " + syllabusPdf,smallBold));
            name.go();


//            adding the date
            ColumnText date = new ColumnText(writer.getDirectContent());
            date.setSimpleColumn(50,620,325,645);
            date.setText(new Phrase( "Grade : " + grade, smallBold));
            date.go();

//          adding month
            ColumnText mnt = new ColumnText(writer.getDirectContent());
            mnt.setSimpleColumn(375,620,550,645);
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
//            System.out.println(refId.size());

//          adding the content
//            double total = 0.0;
            PdfPCell conRefNo = new PdfPCell();
            PdfPCell conSubject = new PdfPCell();
            PdfPCell conAmnt = new PdfPCell();
            for ( int i =0 ; i < refId.size() ; i++)
            {
                total+= amount.get(i);
                 conRefNo = new PdfPCell(new Paragraph(refId.get(i),small));
//
                table.addCell(conRefNo);

                 conSubject= new PdfPCell(new Paragraph(subjects.get(i),small));

                table.addCell(conSubject);

                 conAmnt = new PdfPCell(new Paragraph(amount.get(i).toString(),small));

                table.addCell(conAmnt);

            }

//            adding the total cell
                PdfPCell totalStr = new PdfPCell(new Paragraph("TOTAL",smallBold));
                totalStr.setColspan(2);
                totalStr.setHorizontalAlignment(Element.ALIGN_CENTER);


                PdfPCell totalNu = new PdfPCell(new Paragraph(String.valueOf(total),smallBold));
                totalNu.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(totalStr);
                table.addCell(totalNu);




//            table.setTotalWidth(550);

            ColumnText tab = new ColumnText(writer.getDirectContent());
            tab.setSimpleColumn(50,400,550,600);

            tab.addElement(table);
            tab.go();

//            end of student copy double seperator

//            P
            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-4);
            dottedline.setGap(4f);
            dottedline.setLineWidth(2);

            ColumnText sep1 = new ColumnText(writer.getDirectContent());
            sep1.setSimpleColumn(20,395,575,397);
            sep1.addElement(dottedline);
            sep1.go();
            ColumnText sep2 = new ColumnText(writer.getDirectContent());
            sep2.setSimpleColumn(20,398,575,400);
            sep2.addElement(dottedline);
            sep2.go();
// *********************************************************************************************************
 //  *****************************************************************************************************

           //adding the wisdom arena logo
            Image img2 = Image.getInstance("src\\sample\\assets\\images\\wanew.jpg");
            img2.setAbsolutePosition(10,290);

            document.add(img2);
            // adding the title to the headr and the subtitlte ( lead to Excellence)

            ColumnText cttitle2 = new ColumnText(writer.getDirectContent());
            cttitle2.setSimpleColumn(36,330,559,370);
            cttitle2.setAlignment(Element.ALIGN_CENTER);
            cttitle2.setText(new Phrase( "Wisdom Arena", catFont));
            cttitle2.go();

            ColumnText ctSub = new ColumnText(writer.getDirectContent());
            ctSub.setSimpleColumn(36,315,559,345);
            ctSub.setAlignment(Element.ALIGN_CENTER);
            ctSub.setText(new Phrase("Lead To Excellence",subFontBld));
            ctSub.go();

            ColumnText ctAdress = new ColumnText(writer.getDirectContent());
            ctAdress.setSimpleColumn(36,310,559,330);
            ctAdress.setAlignment(Element.ALIGN_CENTER);
            ctAdress.setText(new Paragraph("No: 106, Station Road, Kandana, Sri Lanka ",xtrasmall));
            ctAdress.go();

            ColumnText ctAdress2 = new ColumnText(writer.getDirectContent());
            ctAdress2.setSimpleColumn(36,295,559,315);
            ctAdress2.setAlignment(Element.ALIGN_CENTER);
            ctAdress2.setText(new Paragraph("email : wisdomarena2017@gmail.com   T.P. : 0769039960",xtrasmall));
            ctAdress2.go();



//

//            Paragraph subTitle2 = new Paragraph("Lead To Excellence",subFontBld);
//            subTitle2.setAlignment(Element.ALIGN_CENTER);
//            document.add(subTitle2);
            //adding the adress and the content to the header
//            Paragraph adress2 = new Paragraph("No: 106, Station Road, Kandana, Sri Lanka \n email : wisdomarena2017@gmail.com   T.P. : 0769039960",xtrasmall);
//            adress2.setAlignment(Element.ALIGN_CENTER);
//            document.add(adress2);

//            adding the student copy label
            Rectangle rec2 = new Rectangle(475,315,550,365);
            rec2.setBorder(Rectangle.BOX);
            rec2.setBorderWidth(2);
            document.add(rec2);

//            ColumnText ctrec = new ColumnText(writer.getDirectContent());
            ctrec.setSimpleColumn(rec2);
            ctrec.setAlignment(Element.ALIGN_CENTER);
            Paragraph pr2 = new Paragraph("Office's \n Copy");
            pr2.setAlignment(Element.ALIGN_CENTER);
            ctrec.addElement(pr2);
            ctrec.go();

//            adding a seperator

            PdfContentByte canvas2 = writer.getDirectContent();
            canvas2.moveTo(36, 290);
            canvas2.lineTo(559, 290);
            canvas2.stroke();



//            adding name
            ColumnText name2 = new ColumnText(writer.getDirectContent());
            name2.setSimpleColumn(50,250,325,280);
            name2.setText( new Phrase("Name : " + stuName,smallBold));
            name2.go();

//            adding syllabus
            ColumnText syllabus2 = new ColumnText(writer.getDirectContent());
            name2.setSimpleColumn(375,250,550,280);
            name2.setText( new Phrase("Syllabus : " + syllabusPdf,smallBold));
            name2.go();


//            adding the date
            ColumnText date2 = new ColumnText(writer.getDirectContent());
            date2.setSimpleColumn(50,220,325,245);
            date2.setText(new Phrase( "Grade : " + grade, smallBold));
            date2.go();

//          adding month
            ColumnText mnt2 = new ColumnText(writer.getDirectContent());
            mnt2.setSimpleColumn(375,220,550,245);
            mnt2.setText(new Phrase( "Month : " + month, smallBold));
            mnt2.go();


//adding the pdf table
            ColumnText tab2 = new ColumnText(writer.getDirectContent());
            tab2.setSimpleColumn(50,30,550,200);

            tab2.addElement(table);
            tab2.go();


            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




//    get the values to the arrays
    public void setValues (List<String>r, List<String>s, List<Double> a)
    {
        refId = r ;
        subjects = s ;
        amount = a ;
//        for (int i =0 ; i< 5 ;i++)
//        {
//            System.out.println(refId.get(i) + " " + subjects.get(i) + " " + amount.get(i));
//        }
    }


//    public String getStuName() {
//        return stuName;
//    }

    public void setStuName(String stuName) {
        if (stuName != null) {
            this.stuName = stuName;
        } else
            {
                this.stuName = "";
        }
    }

//    public String getMonth() {
//        return month;
//    }

    public void setMonth(String month) {
        if ( month != null) {
            this.month = month;
        } else {
            this.month = "";
        }
    }

//    public String getGrade() {
//        return grade;
//    }

    public void setGrade(String grade) {
        if (grade != null) {
            this.grade = grade;
        } else {
            this.grade = "";
        }
    }

//    public String getSyllabusPdf() {
//        return syllabusPdf;
//    }

    public void setSyllabusPdf(String syllabusPdf) {
        if (syllabusPdf!= null) {
            this.syllabusPdf = syllabusPdf;
        } else {
            this.syllabusPdf= "";
        }
    }
}


