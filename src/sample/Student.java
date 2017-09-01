package sample;

import sun.util.calendar.BaseCalendar;
import sun.util.calendar.LocalGregorianCalendar;

import javax.swing.*;
import java.time.LocalDate;
//import java.util.Date;
import java.sql.Date;

public class Student
{
//student variables
    private String stuId;
    private String stuGender;
    private  String stuFirstName;
    private  String stuMiddleName;
    private String stuLastName;
    private Date stuDateofBirth;
    private Date stuDateofAdmin;
    private String stuAdress;
    private String stuContact ;
    private String stuEmail;
    private String stuSchool;
    private String stuGrade;
    private String stuSyllabus;
    private String status;




    public Student()
    {

    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId() {
       // this.stuId = stuId;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuFirstName() {
        return stuFirstName;
    }

    public void setStuFirstName(String stuFirstName) {
        this.stuFirstName = stuFirstName;
    }

    public String getStuMiddleName() {
        return stuMiddleName;
    }

    public void setStuMiddleName(String stuMiddleName) {
        this.stuMiddleName = stuMiddleName;
    }

    public String getStuLastName() {
        return stuLastName;
    }

    public void setStuLastName(String stuLastName) {
        this.stuLastName = stuLastName;
    }

    public java.sql.Date getStuDateofBirth() {
        return stuDateofBirth;
    }

    public void setStuDateofBirth(LocalDate stuDateofBirth) {

        if (stuDateofBirth != null) {
            Date date = java.sql.Date.valueOf(stuDateofBirth);
            this.stuDateofBirth =  date;
//            JOptionPane.showMessageDialog( null,this.stuDateofBirth);
        } else
            {
                JOptionPane.showMessageDialog( null,"DOB feld should be filled");


            }
    }

    public java.sql.Date getStuDateofAdmin() {
        return stuDateofAdmin;
    }

    public void setStuDateofAdmin(LocalDate stuDateofAdmin) {

        if (stuDateofAdmin != null) {
            Date date = java.sql.Date.valueOf(stuDateofAdmin);
            this.stuDateofAdmin =  date;
//            JOptionPane.showMessageDialog( null,this.stuDateofAdmin);
        } else {
            JOptionPane.showMessageDialog( null,"Date Of Admission field should be filled");
        }
    }

    public String getStuAdress() {
        return stuAdress;
    }

    public void setStuAdress(String stuAdress) {
        this.stuAdress = stuAdress;
    }

    public String getStuContact() {
        return stuContact;
    }

    public void setStuContact(String stuContact)
    {
        try
        {
            char[] temp = stuContact.toCharArray();
            if(temp.length==10||temp.length ==0)
                this.stuContact = stuContact;
            else
                JOptionPane.showMessageDialog( null,"The Entered number in Student Contact number is incorrect");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuSchool() {
        return stuSchool;
    }

    public void setStuSchool(String stuSchool) {
        this.stuSchool = stuSchool;
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    public String getStuSyllabus() {
        return stuSyllabus;
    }

    public void setStuSyllabus(String stuSyllabus) {
        this.stuSyllabus = stuSyllabus;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status != null) {
            this.status = status;
        } else {
            JOptionPane.showMessageDialog(null,"Please mark the status of the student");
        }
    }
}
