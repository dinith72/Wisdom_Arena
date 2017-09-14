package sample;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.sun.xml.internal.fastinfoset.util.StringArray;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payment
{
    private String refID;
    private String stuId;
    private String subject;
    private String month;
    private String method;
    private String description;
    private Double amount;

    public String getRefID() {
        return refID;
    }

//    public void setRefID(String refID) {
//        this.refID = refID;
//    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        if (!stuId.isEmpty()) {
            this.stuId = stuId;
        } else {
            JOptionPane.showMessageDialog(null,"please Enter Student ID");
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        System.out.print(subject);
        if (!subject.isEmpty()) {
            this.subject = subject;
        } else {
            JOptionPane.showMessageDialog(null,"please Select Subject");
        }
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        if (!month.isEmpty()) {
            this.month = month;
        } else {
            JOptionPane.showMessageDialog(null,"please Select Month");
        }
    }



    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        if (!method.isEmpty()) {
            this.method = method;
        } else {
            JOptionPane.showMessageDialog(null,"please Select Method of Payment");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (!description.isEmpty()) {
            this.description = description;
        } else {
            this.description = stuId + " " + subject;
        }
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        if (amount != null || amount != 0) {
            this.amount = amount;
        } else {
            JOptionPane.showMessageDialog(null,"please Enter Correct Amount");
        }
    }

//    insert data into the database
    public boolean insertToDatabase()
    {
        try {
            ConObj conObj = new ConObj();
            Connection conn = conObj.getCon();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO `payments`(`Reference_ID`, `Stu_No`, `subject`, `month`, `method`, `description`, `amount`) " +
                    "VALUES (?,?,?,?,?,?,?);");
            ps.setString(1,refID);
            ps.setString(2,stuId);
            ps.setString(3,subject);
            ps.setString(4,month);
            ps.setString(5,method);
            ps.setString(6,description);
            ps.setDouble(7,amount);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"The reference "+refID + " has been succesfully sdded to the table");
            return  true ;

        } catch (MySQLIntegrityConstraintViolationException sql)
        {
            JOptionPane.showMessageDialog(null,"There is a duplicate referance to the  student & " +
                    "month & subject combination entered ");
            sql.printStackTrace();
            return false;
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sql)
        {
            JOptionPane.showMessageDialog(null,"There is a duplicate referance to the  student & " +
                    "month & subject combination entered ");
            sql.printStackTrace();
            return false;
        }

        catch (Exception exe)
        {
            exe.printStackTrace();
            return false;
        }

    }

//    creaating the refereance id
    public void createRefId()
    {
        String monthIndex;
        String stunoIndex;
        String subjectIndex = "";
        // getting the numeric year value
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR)%2000;

        //convertig month to numeric value
        if(month.matches("January"))
            monthIndex = "01";
        else if (month.matches("February"))
            monthIndex = "02" ;
        else if (month.matches("March"))
            monthIndex = "03";
        else if (month.matches("April"))
            monthIndex = "04";
        else if (month.matches("May"))
            monthIndex = "05";
        else if (month.matches("June"))
            monthIndex = "06";
        else if (month.matches("July"))
            monthIndex = "07" ;
        else if (month.matches("August"))
            monthIndex = "08";
        else if (month.matches("September"))
            monthIndex = "09";
        else if (month.matches("October"))
            monthIndex = "10";
        else if (month.matches("November"))
            monthIndex = "11";
        else
            monthIndex = "12";

        //converting student number to stu number index
        String[] temp = stuId.split("-");
        stunoIndex = temp[1];

        // converting the shortened form of subjects to string
        if (subject.matches("Chemistry Theory"))
            subjectIndex = "CT";
        else if (subject.matches("Chemistry Practical"))
            subjectIndex="CP";
        else if (subject.matches("Biology Theory"))
            subjectIndex = "BT";
        else if (subject.matches("Biology Practical"))
            subjectIndex = "BP";
        else if (subject.matches("Physics Theory"))
            subjectIndex = "PT";
        else if (subject.matches("Physics Practical"))
            subjectIndex = "PP";
        else if (subject.matches("Mathematics"))
            subjectIndex = "Mat";
        else if (subject.matches("English"))
            subjectIndex = "Eng";
        else if (subject.matches("Science"))
            subjectIndex = "Sci";

        else if (subject.matches("Admission Fee"))
            subjectIndex ="AF";
        else if (subject.matches("Refundable Deposit"))
            subjectIndex = "RD";


        refID = "RN/"+year+"/"+monthIndex+"/"+stunoIndex+"/"+subjectIndex;
//        JOptionPane.showMessageDialog(null,year + monthIndex + " "+ stunoIndex +" "+ subjectIndex);
    }

    public boolean deleteFromDatabse(String id )
    {
        try {
            ConObj conObj = new ConObj();
            Connection conn = conObj.getCon();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM `payments` WHERE `Reference_ID` = ?;");
            ps.setString(1,id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "The referance of "+id+ " has been deleted from the database");
            return true ;
        }
        catch (Exception exe)
        {
            exe.printStackTrace();
            return false;
        }

    }

    public boolean updateRefDep(double amnt)
    {
        try {
            ConObj conObj = new ConObj();
            Connection conn = conObj.getCon();
            PreparedStatement ps = conn.prepareStatement("UPDATE `student` SET `Refundable Deposit`= ? WHERE `Stu_Id` = ?;");
            ps.setDouble(1,amnt);
            ps.setString(2,stuId);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    // this function is used in the payment history where the previous month payments are displayed
    private  String[] mnths= new String[3];
    public String[] getmonthHeaders()
    {
        
        Calendar cal = Calendar.getInstance();

//        for the first month before
        cal.add(Calendar.MONTH,-1);
        mnths[0] = new SimpleDateFormat("MMMM").format(cal.getTime());

//        for the second month before
        cal.add(Calendar.MONTH,-1);
        mnths[1] = new SimpleDateFormat("MMMM").format(cal.getTime());

//        for the third month before
        cal.add(Calendar.MONTH,-1);
        mnths[2] = new SimpleDateFormat("MMMM").format(cal.getTime());



//        System.out.println(mnths[0] + mnths[1] + mnths[2]);


        return mnths;
    }
    
    public String[] getPaidAmount(String subject)
    {
        String []amnt = new String[3];
        int i =0 ;
        for (String m:mnths)
        {
            try {
                ConObj conObj = new ConObj();
                Connection conn = conObj.getCon();
                PreparedStatement stmnt = conn.prepareStatement("SELECT amount FROM `payments` WHERE `Stu_No` = ? AND `subject` = ? AND `month` = ?");
                stmnt.setString(1,stuId);
                stmnt.setString(2,subject);
                stmnt.setString(3,m);
                ResultSet rs = stmnt.executeQuery();
                while (rs.next())
                {
                    amnt[i] = rs.getString(1);
                    i++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(amnt[0] +" "+ amnt[1] +" "+ amnt[2]);
        return amnt;
    }


}
