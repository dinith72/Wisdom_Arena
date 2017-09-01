package sample;

import javax.swing.*;

public class Guardian
{

    private String gender;
    private String firstName;
    private String middleName;
    private String lastName;
    private String contactNoMobile;
    private String contactNoHome;
    private String contactNoOffice;
    private String email;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNoMobile() {
        return contactNoMobile;
    }

    public void setContactNoMobile(String contactNoMobile) {
        char[] temp = contactNoMobile.toCharArray();
        if (temp.length == 10 || temp.length == 0) {
            this.contactNoMobile = contactNoMobile;
        } else
            {
                JOptionPane.showMessageDialog(null,"Enter Valid mobile number");
        }
    }

    public String getContactNoHome() {
        return contactNoHome;
    }

    public void setContactNoHome(String contactNoHome) {
        char[] temp = contactNoHome.toCharArray();
        if (temp.length == 10 || temp.length == 0) {
            this.contactNoHome = contactNoHome;
        } else {
            JOptionPane.showMessageDialog(null,"Enter Valid home contact number");
        }
    }

    public String getContactNoOffice() {
        return contactNoOffice;
    }

    public void setContactNoOffice(String contactNoOffice) {
        char[] temp = contactNoOffice.toCharArray();
        if (temp.length == 10 || temp.length == 0) {
            this.contactNoOffice = contactNoOffice;
        } else {
            JOptionPane.showMessageDialog(null,"Enter Valid office contact number");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
