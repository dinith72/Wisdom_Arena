package sample;

import javafx.beans.property.SimpleStringProperty;

public class History
{
    private SimpleStringProperty subject ;
    private SimpleStringProperty mon1;
    private SimpleStringProperty mon2;
    private SimpleStringProperty mon3;

    public History(String sub , String m1, String m2,String m3)
    {
        subject = new SimpleStringProperty(sub);
        mon1 = new SimpleStringProperty(m1);
        mon2 = new SimpleStringProperty(m2);
        mon3 = new SimpleStringProperty(m3);
    }

    public String getSubject() {
        return subject.get();
    }

    public String getMon1() {
        return mon1.get();
    }

    public String getMon2() {
        return mon2.get();
    }

    public String getMon3() {
        return mon3.get();
    }
}
