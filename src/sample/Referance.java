package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Referance {

    private SimpleStringProperty refID ;
    private SimpleStringProperty subject;
    private SimpleDoubleProperty amount ;

    public Referance(String id,String sub, double amnt )
    {
        this.refID = new SimpleStringProperty(id);
        this.subject = new SimpleStringProperty(sub);

        this.amount = new SimpleDoubleProperty(amnt);
    }

    public String getRefID() {

        return refID.get();
    }

    public void setRefID(String refID) {

        this.refID.set(refID);
    }

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public Double getAmount() {
        return amount.get();
    }

    public void setAmount(Double amount) {
        this.amount.set(amount);
    }
}
