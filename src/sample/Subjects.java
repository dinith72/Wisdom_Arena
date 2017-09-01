package sample;
import javax.swing.*;
import java.sql.*;
public class Subjects
{
    private String stuId;
    private String subject ;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean addToDatabse()
    {
        try {
            ConObj conobj = new ConObj();
            Connection conn = conobj.getCon();
            PreparedStatement ps = conn.prepareStatement("SELECT `Stu_Id` FROM `stu_subjects` WHERE `Stu_Id` = ? AND `subject` = ?;");
            ps.setString(1,stuId);
            ps.setString(2,subject);
            ResultSet rs = ps.executeQuery();
            if (rs.next()==false) {
//                JOptionPane.showMessageDialog(null, "no previous records");
                PreparedStatement psnew = conn.prepareStatement("INSERT INTO `stu_subjects`(`Stu_Id`, `subject`) VALUES (?,?);");
                psnew.setString(1,stuId);
                psnew.setString(2,subject);
                psnew.executeUpdate();
                JOptionPane.showMessageDialog(null, subject+" is succesfully added to database");
                return true;

            }
            else {
                JOptionPane.showMessageDialog(null, "the subject is already added to the student");
                return false;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteFromDatabase(String sub)
    {
        try
        {
            ConObj conobj = new ConObj();
            Connection conn = conobj.getCon();
            PreparedStatement pr = conn.prepareStatement("DELETE FROM `stu_subjects` WHERE `Stu_Id` = ? AND `subject` = ? ; ");
            pr.setString(1,stuId);
            pr.setString(2,sub);
            pr.executeUpdate();
            JOptionPane.showMessageDialog(null,sub+" has beeen succesfully REMOVED from Student");
            return true;
        }
        catch (Exception exe){
            exe.printStackTrace();
            return false;

        }
    }



}
