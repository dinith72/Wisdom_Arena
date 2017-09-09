package sample;

import javafx.beans.property.SimpleStringProperty;

public class NotPaid {
    private SimpleStringProperty stuId ;
    private SimpleStringProperty stuName ;
    private SimpleStringProperty stuSubject ;
    private SimpleStringProperty stucontactNo ;

    public NotPaid(String id , String name , String sub , String cn)
    {
        this.stuId = new SimpleStringProperty(id);
        this.stuName = new SimpleStringProperty(name);
        this.stuSubject = new SimpleStringProperty(sub);
        this.stucontactNo =new SimpleStringProperty(cn);
    }

    public String getStuId() {
        return stuId.get();
    }

//    public void setStuId(String stuId) {
//        this.stuId.set(stuId);
//    }

    public String getStuName() {
        return stuName.get();
    }

//    public void setStuName(SimpleStringProperty stuName) {
//        this.stuName = stuName;
//    }

    public String getStuSubject() {
        return stuSubject.get();
    }

//    public void setStuSubject(SimpleStringProperty stuSubject) {
//        this.stuSubject = stuSubject;
//    }

    public String getStucontactNo() {
        return stucontactNo.get();
    }

//    public void setStucontactNo(SimpleStringProperty stucontactNo) {
//        this.stucontactNo = stucontactNo;
//    }
}
