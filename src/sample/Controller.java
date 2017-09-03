package sample;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
//import java.sql.*;
import javax.security.auth.Subject;
import javax.swing.*;
import javax.xml.soap.SOAPPart;
import java.awt.*;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import org.controlsfx.control.textfield.TextFields ;



public class Controller implements Initializable
{
    List <String> stuNos = new ArrayList<String>();
    double billTotal = 0 ;
    ObservableList<Referance> ref = FXCollections.observableArrayList(
    );

    @FXML
    SplitPane splitPane = new SplitPane();

    @FXML
    public ScrollPane StuReg = new ScrollPane();

    @FXML
    public ScrollPane BillGenerator = new ScrollPane();

    @FXML
    public ScrollPane Reports = new ScrollPane();

// menu bar controls

    @FXML
    public Menu menuStuReg = new Menu();

    @FXML
    private Menu menuBillGenerate = new Menu();



    @FXML
    public Menu menuReports = new Menu();

// end of menu bar controls

//    student regestration header controlles
    @FXML
    public Button btnFirst = new Button();
    @FXML
    public Button btnPrevious = new Button();
    @FXML
    public Button btnNext = new Button();
    @FXML
    public Button btnLast = new Button();
    @FXML
    public Button btnAddNew = new Button();

    @FXML
    public RadioButton active = new RadioButton();

    @FXML
    public RadioButton inactive = new RadioButton();

    @FXML
    public  Button go = new Button();
    @FXML
    public TextField txtStuId = new TextField();


// student registration controllers student profile section

    @FXML
    public ComboBox cmbGenderStu = new ComboBox();


    @FXML
    public TextField txtFirstNameStu = new TextField();

    @FXML
    public TextField txtMiddleNameStu = new TextField();

    @FXML
    public TextField txtLastNameStu = new TextField();

    @FXML
    public DatePicker dobStu = new DatePicker();

    @FXML
    public TextField txtAdressStu = new TextField();

    @FXML
    public TextField txtContactnoStu = new TextField();

    @FXML
    public TextField txtEmailStu = new TextField();

    @FXML
    public TextField txtSchoolStu = new TextField();

    @FXML
    public ComboBox cmbGenderGuardian = new ComboBox();

    @FXML
    public TextField txtFirstNameGuardian = new TextField();

    @FXML
    public TextField txtMiddleNameGuardian = new TextField();

    @FXML
    public TextField txtLastNameGuardian = new TextField();

    @FXML
    public TextField txtContactnoMobileGuardian = new TextField();

    @FXML
    public TextField txtContactnoHomeGuardian = new TextField();

    @FXML
    public TextField txtContactnoOfficeGuardian = new TextField();

    @FXML
    public TextField txtEmailGuardian = new TextField();



// enf of regestration controllers

//    student regestration controllers acadamic  section

    @FXML
    public ComboBox grade = new ComboBox();

    @FXML
    public ComboBox syllabus = new ComboBox();

    @FXML
    public DatePicker dateOfAdmission = new DatePicker();

    @FXML
    public ComboBox cmbSubjects = new ComboBox();
    @FXML
    public Label refDeposit = new Label();

    @FXML
    public Button btnSubmit = new Button();

    @FXML
    public Button btnDeleteSubject = new Button();

    @FXML
    public Label adminFee = new Label();

    @FXML
    public ListView<String> subjectsList = new ListView();



// end of acadamic regestration controlers

// Bill Generation Controls
    @FXML
    public Label lblDateBill = new Label();

   @FXML
   public TextField txtStuIdBill = new TextField();

    @FXML
    public Label lblNameBill = new Label();

    @FXML
    public ComboBox cmbMonthBill = new ComboBox();

    @FXML
    public Label lblGradeBill = new Label();

    @FXML
    public Label lblSyllabusBill = new Label();

    @FXML
    public Label lblRefDeposit = new Label();

    @FXML
    public TextField txtRefDepAmnt = new TextField();

    @FXML
    public  Button btnEditBill = new Button();

    @FXML
    public  Button btnSaveBill = new Button();

    @FXML
    public ComboBox cmbSubjectBill = new ComboBox();

    @FXML
    public  ComboBox cmbPaymentMethod = new ComboBox();

    @FXML
    public  TextArea txtDescription = new TextArea();

    @FXML
    public  TextField txtAmountBill = new TextField();

    @FXML
    public TableView <Referance> tablePayments  = new TableView<Referance>();

    @FXML
    public TableColumn<Referance,String> refIdCol = new TableColumn();

    @FXML
    public TableColumn< Referance ,String> subjectCol = new TableColumn();

    @FXML
    public TableColumn<Referance,Double> amountCol = new TableColumn();


    @FXML
    public Button btnAddtoTableBill = new Button();

    @FXML
    public Button btnDeleteTabel = new Button();

    @FXML
    public Label lblTotalBill = new Label();

    @FXML
    public Button btnPrintBill = new Button();

// end of bill generation controls

// report generating pannel
    @FXML
    public ComboBox cmbMonthReport = new ComboBox();

    @FXML
    public ComboBox cmbYearReport = new ComboBox();

    @FXML
    public Button btnPrintReport = new Button();

//
//    String[] stuNos = {"WA0001" , "WA0002", "WA0003"};


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        getStuIds();
       // System.out.print("runnig");
        BillGenerator.setVisible(false);
        Reports.setVisible(false);
//
//        student menu pannel items

        TextFields.bindAutoCompletion(txtStuId,stuNos);
        TextFields.bindAutoCompletion(txtStuIdBill,stuNos);

    //student regestration pannel
        cmbGenderStu.getItems().addAll("Miss","Master");
        cmbGenderGuardian.getItems().addAll("Mr","Mrs","Ms");
        grade.getItems().addAll("6","7" , "8" , "9" , "10" , "11" , "12" ,"13");
        syllabus.getItems().addAll("National" , "Edexcel" , "Cambridge");
        cmbSubjects.getItems().addAll("Chemistry Theory" ,"Chemistry Practical" ,
                                            "Biology Theory","Biology Practical",
                                            "Physics Theory" , "Physics Practical",
                                            "Mathematics" , "English","Science");

    // end of student regestration pannel
    // bill generation pannel
        cmbMonthBill.getItems().addAll("January","February","March","April","May"
                ,"June","July","August","September","October","November","December");
    //report generating pannel
        cmbMonthReport.getItems().addAll("January","February","March","April","May"
                ,"June","July","August","September","October","November","December");

        cmbYearReport.getItems().addAll("2017","2018","2019");

    // date in the bill generator form
    LocalDate localDate = LocalDate.now();
    lblDateBill.setText(localDate.toString());

    // methods payments in the
        cmbPaymentMethod.getItems().addAll("Cash","Cheque","Bamk Deposit Slip");

        //diabloing the refundale deposit amounts
        btnSaveBill.setVisible(false);
        txtRefDepAmnt.setVisible(false);

    }

    @FXML
    public void btnSubmitClicked()
    {
        Student stu = new Student();
        Guardian grd = new Guardian();
    // student personal details
        stu.setStuId();
        stu.setStuGender( (String)cmbGenderStu.getValue());
        stu.setStuFirstName(txtFirstNameStu.getText());
        stu.setStuMiddleName(txtMiddleNameStu.getText());
        stu.setStuLastName(txtLastNameStu.getText());
        stu.setStuDateofBirth(dobStu.getValue());
        stu.setStuAdress(txtAdressStu.getText());
        stu.setStuContact(txtContactnoStu.getText());
        stu.setStuEmail(txtEmailStu.getText());
        stu.setStuSchool(txtSchoolStu.getText());

        if (active.isSelected()) {
//            JOptionPane.showMessageDialog(null,"active");
            stu.setStatus("active");
        }
        if(inactive.isSelected())
            stu.setStatus("inactive");

        // guardian details
        grd.setGender((String) cmbGenderGuardian.getValue());
        grd.setFirstName(txtFirstNameGuardian.getText());
        grd.setMiddleName(txtMiddleNameGuardian.getText());
        grd.setLastName(txtLastNameGuardian.getText());
        grd.setContactNoMobile(txtContactnoMobileGuardian.getText());
        grd.setContactNoHome(txtContactnoHomeGuardian.getText());
        grd.setContactNoOffice(txtContactnoOfficeGuardian.getText());
        grd.setEmail(txtEmailGuardian.getText());

     // student Acadamic details
        stu.setStuGrade((String)grade.getValue());
        stu.setStuSyllabus((String)syllabus.getValue());
        stu.setStuDateofAdmin(dateOfAdmission.getValue());

     // updating the database with the values
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
            ConObj obj = new ConObj();
            Connection conn = obj.getCon();
           PreparedStatement pr = conn.prepareStatement("UPDATE `student` \n" +
                   "SET `gender`= ?,`First_Name`= ?,`Middle_Name`= ?,`Last_Name`= ?,`DateofBirth`= ?,`DateofAdmin`= ?,`Adress`= ?,`ContactNo`= ? ,`Email`= ? ,`School`= ?,`Grade`= ? ,`Syllabus`= ? ,`status` = ?\n" +
                   "WHERE Stu_Id = ?;");
           pr.setString(1,stu.getStuGender());
            pr.setString(2,stu.getStuFirstName());
            pr.setString(3,stu.getStuMiddleName());
            pr.setString(4,stu.getStuLastName());
            pr.setDate(5,stu.getStuDateofBirth());
            pr.setDate(6,stu.getStuDateofAdmin());
            pr.setString(7,stu.getStuAdress());
            pr.setString(8,stu.getStuContact());
            pr.setString(9,stu.getStuEmail());
            pr.setString(10,stu.getStuSchool());
            pr.setString(11,stu.getStuGrade());
            pr.setString(12,stu.getStuSyllabus());
            pr.setString(13,stu.getStatus());
            pr.setString(14,txtStuId.getText());

//          guardian detail update to databse
            PreparedStatement prg = conn.prepareStatement("UPDATE `guardian` SET `Gender`= ?,`First name`= ?," +
                    "`Middle name`= ? ,`Last name`= ?,`Mobile no`= ? ,`Home no`= ? ,`Office no`= ? ,`email`= ?  WHERE `Stu_Id` = ? ;");
            prg.setString(1,grd.getGender());
            prg.setString(2,grd.getFirstName());
            prg.setString(3,grd.getMiddleName());
            prg.setString(4,grd.getLastName());
            prg.setString(5,grd.getContactNoMobile());
            prg.setString(6,grd.getContactNoHome());
            prg.setString(7,grd.getContactNoOffice());
            prg.setString(8,grd.getEmail());
            prg.setString(9,txtStuId.getText());

            pr.executeUpdate(); // sql update of the student
            prg.executeUpdate();  // sql update of the guardian
           JOptionPane.showMessageDialog(null,"Record succesfully saved in the Databse");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ConObj obj = new ConObj();
            Connection conn = obj.getCon();
            PreparedStatement prg = conn.prepareStatement("UPDATE `guardian` \n" +
                    " SET `Gender`= ?,`First name`= ?,`Middle name`= ?,`Last name`= ? ,`Mobile no`= ?,`Home no`= ?,`Office no`= ?,`email`= ? \n" +
                    "WHERE `Stu_Id` = 'WA0001';");
            prg.setString(1,grd.getGender());
            prg.setString(2,grd.getFirstName());
            prg.setString(3,grd.getMiddleName());
            prg.setString(4,grd.getLastName());

            prg.setString(5,grd.getContactNoMobile());
            prg.setString(6,grd.getContactNoHome());
            prg.setString(7,grd.getContactNoOffice());
            prg.setString(8,grd.getEmail());
            prg.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        // JOptionPane.showMessageDialog(null,stu.getStuDateofBirth());
    }

    @FXML
    public void btnAddNewClicked(ActionEvent event)
    {
        String curret ;
        int CurrstuNo;

        String changedsno;

        if (!stuNos.isEmpty()) {
            curret = stuNos.get(stuNos.size()-1);
            String[] parts = curret.split("-");
            CurrstuNo = Integer.parseInt(parts[1]);
            CurrstuNo++;
        } else {
            CurrstuNo = 1;
        }
        if(CurrstuNo < 10)
            changedsno = "WA-000"+CurrstuNo;
        else if (CurrstuNo < 100)
            changedsno = "WA-00"+CurrstuNo;
        else if (CurrstuNo < 1000)
            changedsno = "WA-0"+CurrstuNo;
        else
            changedsno= "WA-"+CurrstuNo;
        txtStuId.setText(changedsno);
        clearAll();
        JOptionPane.showMessageDialog(null,changedsno);

//   inserting the student numebr into database
        try {
            ConObj conobj = new ConObj();
            Connection conn = conobj.getCon();
            PreparedStatement pr = conn.prepareStatement("INSERT INTO student (`Stu_Id`) VALUES (?)");
            pr.setString(1,changedsno); // updating the student

            PreparedStatement prg = conn.prepareStatement("INSERT INTO `guardian`(`Stu_Id`) VALUES ( ? );");
            prg.setString(1,changedsno); // updating the guardian
            pr.executeUpdate();
            prg.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void menuStuRegClicked(ActionEvent event)
    {
//        JOptionPane.showMessageDialog(null,"student regestration");
        StuReg.setVisible(true);
        BillGenerator.setVisible(false);
        Reports.setVisible(false);
    }

    @FXML
    public void menuReportClicked(ActionEvent event)
    {
//        JOptionPane.showMessageDialog(null,"Report");
        StuReg.setVisible(false);
        BillGenerator.setVisible(false);
        Reports.setVisible(true);
    }

    @FXML
    private void menuBillGenerateClicked(ActionEvent event)
    {
//        JOptionPane.showMessageDialog(null,"Bill Generate");
        BillGenerator.setVisible(true);
        StuReg.setVisible(false);
        Reports.setVisible(false);
    }

    @FXML
    private void txtStuTextChanged(ActionEvent event)
    {
//        JOptionPane.showMessageDialog(null,"Text changed");
        fillForm(txtStuId.getText());
    }

    @FXML
    private void btnFirstClicked(ActionEvent event)
    {
        String id = stuNos.get(0);
        fillForm(id);
        txtStuId.setText(id);

    }

    @FXML
    private void btnPreviousClicked(ActionEvent event)
    {

        String curret ;
        int CurrstuNo;

        String changedsno;
        if(txtStuId.getText()!= null)
        {
            curret = txtStuId.getText();
            String[] parts = curret.split("-");
            CurrstuNo = Integer.parseInt(parts[1]);
        }
        else
            CurrstuNo = 0;
        CurrstuNo--;
        if(CurrstuNo < 10)
            changedsno = "WA-000"+CurrstuNo;
        else if (CurrstuNo < 100)
            changedsno = "WA-00"+CurrstuNo;
        else if (CurrstuNo < 1000)
            changedsno = "WA-0"+CurrstuNo;
        else
            changedsno= "WA-"+CurrstuNo;
        txtStuId.setText(changedsno);
        fillForm(changedsno);
//        JOptionPane.showMessageDialog(null,changedsno);

    }

    @FXML
    private void btnNextClicked(ActionEvent event)
    {
        String curret ;
        int CurrstuNo;

        String changedsno;
        if(txtStuId.getText()!= null)
        {
            curret = txtStuId.getText();
            String[] parts = curret.split("-");
            CurrstuNo = Integer.parseInt(parts[1]);
        }
        else
            CurrstuNo = 0;
        CurrstuNo++;
        if(CurrstuNo < 10)
            changedsno = "WA-000"+CurrstuNo;
        else if (CurrstuNo < 100)
            changedsno = "WA-00"+CurrstuNo;
        else if (CurrstuNo < 1000)
            changedsno = "WA-0"+CurrstuNo;
        else
            changedsno= "WA-"+CurrstuNo;
        txtStuId.setText(changedsno);
        fillForm(changedsno);
//        JOptionPane.showMessageDialog(null,changedsno);
    }

    @FXML
    private void btnLastClicked(ActionEvent event)
    {
        String id = stuNos.get(stuNos.size()-1) ;
        fillForm(id);
        txtStuId.setText(id);

    }

    @FXML
    private void cmbSubjectsSelected(ActionEvent event)
    {
        Subjects sub = new Subjects();
        String strsub = cmbSubjects.getValue().toString();
//        JOptionPane.showMessageDialog(null,strsub);

        sub.setStuId(txtStuId.getText());
        sub.setSubject(strsub);
        boolean add = sub.addToDatabse();

        if (add) {
            subjectsList.getItems().add(strsub); // adding to the list view
        }


    }

    @FXML
    private void setBtnDeleteSubject(ActionEvent event)
    {
        Subjects sub = new Subjects();
        sub.setStuId(txtStuId.getText());
       String subDelete =  subjectsList.getSelectionModel().getSelectedItem();
       int itemPos = subjectsList.getSelectionModel().getSelectedIndex();
       JOptionPane.showMessageDialog(null, subDelete);
       boolean delete = sub.deleteFromDatabase(subDelete);

       if(delete)
           subjectsList.getItems().remove(itemPos);
    }

    @FXML
    private void setTxtStuIdBill(ActionEvent event)
    {
        try {
            // getting the students personal details to the form
            ConObj conObj = new ConObj();
            Connection conn = conObj.getCon();
            PreparedStatement pr = conn.prepareStatement("SELECT `First_Name`,`Middle_Name`,`Last_Name`," +
                    "`Grade`,`Syllabus`,`Refundable Deposit` FROM `student` WHERE `Stu_Id` = ? ;");
            pr.setString(1,txtStuIdBill.getText());
            ResultSet rs = pr.executeQuery();
            while(rs.next())
            {
                lblNameBill.setText(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
                lblGradeBill.setText(rs.getString(4));
                lblSyllabusBill.setText(rs.getString(5));
                lblRefDeposit.setText(rs.getString(6));

            }

            // getting the list of subjects to the form
            PreparedStatement ps = conn.prepareStatement("SELECT `subject` FROM `stu_subjects` WHERE `Stu_Id` = ?;");
            ps.setString(1,txtStuIdBill.getText());
            ResultSet rssub = ps.executeQuery();
            while (rssub.next())
            {
//                JOptionPane.showMessageDialog(null,rssub.getString(1));
                cmbSubjectBill.getItems().add(rssub.getString(1));
            }
            cmbSubjectBill.getItems().add("Admission Fee");
            cmbSubjectBill.getItems().add("Refundable Deposit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void setBtnAddtoTableBill(ActionEvent event)
    {
        Payment pmnt = new Payment();
        boolean add = false;

//        inititalising the observable list to columns
        refIdCol.setCellValueFactory(
                new PropertyValueFactory<Referance,String>("refID")
        );
        subjectCol.setCellValueFactory(
                new PropertyValueFactory<Referance,String>("subject")
        );
        amountCol.setCellValueFactory(
                new PropertyValueFactory<Referance,Double>("amount")
        );


        try {
            pmnt.setStuId(txtStuIdBill.getText());
            pmnt.setMonth(cmbMonthBill.getValue().toString());
            pmnt.setSubject(cmbSubjectBill.getValue().toString());
            pmnt.setMethod(cmbPaymentMethod.getValue().toString());
            pmnt.setDescription(txtDescription.getText());
            pmnt.setAmount( Double.parseDouble(txtAmountBill.getText()) );
            pmnt.createRefId();
            add = pmnt.insertToDatabase();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,"Theare are uncompleted fields in your payment");
        }


        if(add)
        {

//            JOptionPane.showMessageDialog(null,"running");
            ref.add(new Referance(pmnt.getRefID(),pmnt.getSubject(),pmnt.getAmount()));
//
//
            tablePayments.setItems(ref);
            billTotal += pmnt.getAmount();

            lblTotalBill.setText( String.valueOf(billTotal));
        }

//        JOptionPane.showMessageDialog(null,pmnt.getRefID());

    }

    @FXML
    private void setBtnPrintBill (ActionEvent event)
    {
        JOptionPane.showMessageDialog(null,"print bill");
        PdfDoc doc = new PdfDoc();
        doc.createDoc();
    }

    @FXML
    private void setBtnDeleteTabel(ActionEvent event)
    {
        try {
            Payment pmnt = new Payment();
            Referance refDel = tablePayments.getSelectionModel().getSelectedItem();

//            JOptionPane.showMessageDialog(null,refDel.getRefID());
            boolean delete = pmnt.deleteFromDatabse(refDel.getRefID().toString());

            if (delete) {
                ref.remove(refDel);
                billTotal -= refDel.getAmount();
                lblTotalBill.setText(String.valueOf(billTotal));
            } else {
                JOptionPane.showMessageDialog(null,"Error");
            }
        } catch (NullPointerException npexe) {
            JOptionPane.showMessageDialog(null,"Please selecte the item t delete ");
        }

    }

    @FXML
    public  void setBtnEditBill(ActionEvent event)
    {
        btnSaveBill.setVisible(true);
        txtRefDepAmnt.setVisible(true);
        btnEditBill.setVisible(false);
    }

    @FXML
    public void setBtnSaveBill(ActionEvent event)
    {
        Payment pmnt = new Payment();
        pmnt.setStuId(txtStuIdBill.getText());
        double amount = Double.parseDouble(txtRefDepAmnt.getText());
        boolean update = pmnt.updateRefDep(amount);
        if (update)
        {
           lblRefDeposit.setText(String.valueOf(amount));
            txtRefDepAmnt.setVisible(false);
            btnSaveBill.setVisible(false);
            btnEditBill.setVisible(true);
           JOptionPane.showMessageDialog(null,"Refundable Deposit is successfully updated");
        }

    }
    private void fillForm(String id)
    {
        clearAll();
        try {
            ConObj conpbj = new ConObj();
            Connection con = conpbj.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT `gender`,`First_Name`,`Middle_Name`,`Last_Name`,`DateofBirth`," +
                    "`DateofAdmin`,`Adress`,`ContactNo`,`Email`,`School`,`Grade`,`Syllabus`," +
                    "`Refundable Deposit` , `Admission fee`,`status` FROM `student` WHERE `Stu_Id` = ? ");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                cmbGenderStu.setValue(rs.getString(1));
                txtFirstNameStu.setText(rs.getString(2));
                txtMiddleNameStu.setText(rs.getString(3));
                txtLastNameStu.setText(rs.getString(4));
                dobStu.setValue( LocalDate.parse( rs.getString(5)));
                dateOfAdmission.setValue( LocalDate.parse(rs.getString(6)));
                txtAdressStu.setText(rs.getString(7));
                txtContactnoStu.setText(rs.getString(8));
                txtEmailStu.setText(rs.getString(9));
                txtSchoolStu.setText(rs.getString(10));
                grade.setValue(rs.getString(11));
                syllabus.setValue(rs.getString(12));
                refDeposit.setText(rs.getString(13));
                adminFee.setText(rs.getString(14));
                String st = rs.getString(15);
                if(st.matches("active")) {
                    active.setSelected(true);
                    inactive.setSelected(false);
                }
                if(st.matches("inactive")) {
                    inactive.setSelected(true);
                    active.setSelected(false);
                }

//                adding guardian details to the form
                PreparedStatement prg = con.prepareStatement("SELECT `Gender`, `First name`, `Middle name`," +
                        " `Last name`, `Mobile no`, `Home no`, `Office no`, `email` FROM `guardian` WHERE `Stu_Id` = ?;");
                prg.setString(1,id);
                ResultSet rsg = prg.executeQuery();
                while(rsg.next())
                {
                    cmbGenderGuardian.setValue(rsg.getString(1));
                    txtFirstNameGuardian.setText(rsg.getString(2));
                    txtMiddleNameGuardian.setText(rsg.getString(3));
                    txtLastNameGuardian.setText(rsg.getString(4));
                    txtContactnoMobileGuardian.setText(rsg.getString(5));
                    txtContactnoHomeGuardian.setText(rsg.getString(6));
                    txtContactnoOfficeGuardian.setText(rsg.getString(7));
                    txtEmailGuardian.setText(rsg.getString(8));
                }

                PreparedStatement prs = con.prepareStatement("SELECT `subject` FROM `stu_subjects` WHERE `Stu_Id` = ? ");
                prs.setString(1,id);
                ResultSet rsSub = prs.executeQuery();
                while (rsSub.next())
                {
                    subjectsList.getItems().add(rsSub.getString(1));
                }
            }

        }
        catch (ArrayIndexOutOfBoundsException outOfArray)
        {
            JOptionPane.showMessageDialog(null,"You have reached to the last record in the list");
        }
        catch (NullPointerException nullpointer)
        {

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getStuIds()
    {
        try {
            ConObj conpbj = new ConObj();
            Connection con = conpbj.getCon();
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT `Stu_Id` FROM `student`");
            while (rs.next())
            {
                stuNos.add(rs.getString(1));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void clearAll()
    {
//       regestration  student details
        cmbGenderStu.setValue(null);
        txtFirstNameStu.setText("");
        txtMiddleNameStu.setText("");
        txtLastNameStu.setText("");
        dobStu.setValue(null);
        txtAdressStu.setText("");
        txtContactnoStu.setText("");
        txtEmailStu.setText("");
        txtSchoolStu.setText("");
        grade.setValue(null);
        syllabus.setValue(null);
        dateOfAdmission.setValue(null);
        refDeposit.setText("");
        adminFee.setText("");

        cmbSubjects.setValue(null);
        subjectsList.getItems().clear();

//        regestration guardian details
        cmbGenderGuardian.setValue(null);
        txtFirstNameGuardian.setText("");
        txtMiddleNameGuardian.setText("");
        txtLastNameGuardian.setText("");
        txtContactnoMobileGuardian.setText("");
        txtContactnoHomeGuardian.setText("");
        txtContactnoOfficeGuardian.setText("");
        txtEmailGuardian.setText("");



    }
}

