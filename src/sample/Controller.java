package sample;

import com.itextpdf.text.Paragraph;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
//import java.sql.*;
import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.stage.FileChooser;
import org.controlsfx.control.textfield.TextFields ;
import sun.security.action.OpenFileInputStreamAction;

import java.awt.Desktop;


public class Controller implements Initializable
{
    List <String> stuNos = new ArrayList<String>();
    double billTotal = 0 ;
    ObservableList<Referance> ref = FXCollections.observableArrayList(
    );

    ObservableList<NotPaid> notPaid = FXCollections.observableArrayList(
    );

    ObservableList<History> history = FXCollections.observableArrayList();

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

//    table view for the old payments
    @FXML
    public  TableView <History> historyTableView = new TableView<History>();

    @FXML
    public TableColumn <History,String> subColHistory = new TableColumn();

    @FXML
    public TableColumn <History,String> mnth1 = new TableColumn();

    @FXML
    public TableColumn <History,String> mnth2 = new TableColumn();

    @FXML
    public TableColumn <History,String> mnth3 = new TableColumn();

//    table view for the new payment

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
    public TextField txtDiscount = new TextField();

    @FXML
    public Label lblTotalBill = new Label();

    @FXML
    public Button btnPrintBill = new Button();


// end of bill generation controls

// report generating pannel
    @FXML
    public ComboBox cmbMonthReport = new ComboBox();


    @FXML
    public Button btnPrintReport = new Button();

    @FXML
    public  Button btnExecuteReport = new Button();

    @FXML
    public TableView <NotPaid> notPaidTableView  = new TableView<NotPaid>();
    @FXML
    public TableColumn<NotPaid,String> stuNoCol = new TableColumn();
    @FXML
    public TableColumn<NotPaid,String> stuNameCol = new TableColumn();
    @FXML
    public TableColumn<NotPaid,String> subColRpt = new TableColumn();
    @FXML
    public TableColumn<NotPaid,String> cntNoCol = new TableColumn();

//
//    String[] stuNos = {"WA0001" , "WA0002", "WA0003"};


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        getStuIds();
       // System.out.print("runnig");
        BillGenerator.setVisible(false);
        Reports.setVisible(false);
        hideAll();
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



    // date in the bill generator form
    LocalDate localDate = LocalDate.now();
    lblDateBill.setText(localDate.toString());

    // methods payments in the
        cmbPaymentMethod.getItems().addAll("Cash","Cheque","Bank Deposit Slip");

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
            boolean search = stuNos.contains(txtStuId.getText());

            if (search == false) {
                stuNos.add(txtStuId.getText());
                TextFields.bindAutoCompletion(txtStuId,stuNos);
                TextFields.bindAutoCompletion(txtStuIdBill,stuNos);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        // JOptionPane.showMessageDialog(null,stu.getStuDateofBirth());
    }


    @FXML
    public void btnAddNewClicked(ActionEvent event)
    {
        unhideall(); // making all the field editable
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

            prg.executeUpdate();
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void btnActive(ActionEvent event)
    {
        inactive.setSelected(false);
        active.setSelected(true);
    }

    @FXML
    public void btnInactive(ActionEvent event)
    {
        inactive.setSelected(true);
        active.setSelected(false);
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
        unhideall(); // making all the field editable
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
        List<String> subjects = new ArrayList<>();
        historyTableView.getItems().clear();
        cmbSubjectBill.getItems().clear();

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
                lblGradeBill.setText( "Grade " + rs.getString(4));
                lblSyllabusBill.setText(rs.getString(5));
                lblRefDeposit.setText(rs.getString(6));

            }

            // getting the list of subjects to the form
            PreparedStatement ps = conn.prepareStatement("SELECT `subject` FROM `stu_subjects` WHERE `Stu_Id` = ?;");
            ps.setString(1,txtStuIdBill.getText());
            ResultSet rssub = ps.executeQuery();
            while (rssub.next())
            {
                subjects.add(rssub.getString(1));
//                JOptionPane.showMessageDialog(null,rssub.getString(1));
                cmbSubjectBill.getItems().add(rssub.getString(1));
            }


            cmbSubjectBill.getItems().add("Admission Fee");
            cmbSubjectBill.getItems().add("Refundable Deposit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        initilising the observable list
        subColHistory.setCellValueFactory(
                new PropertyValueFactory<History,String>("subject"));
        mnth1.setCellValueFactory(
                new PropertyValueFactory<History,String>("mon1"));
        mnth2.setCellValueFactory(
                new PropertyValueFactory<History,String>("mon2"));
        mnth3.setCellValueFactory(
                new PropertyValueFactory<History,String>("mon3"));
//        history.add(new History("dhe","a","jul","jun"));

//        Student History table
        String []mnths ;
        String []amnt;
        Payment pmnt = new Payment();
//        setting the table headers
        mnths = pmnt.getmonthHeaders();
        mnth1.setGraphic(new Label(mnths[0]));
        mnth2.setGraphic(new Label(mnths[1]));
        mnth3.setGraphic(new Label(mnths[2]));
        pmnt.setStuId(txtStuIdBill.getText());
        int i = 0 ;
        for (String sub:subjects)
        {
//            System.out.println(subjects.get(i));

            amnt = pmnt.getPaidAmount(subjects.get(i));
            history.add(new History(subjects.get(i),amnt[0],amnt[1],amnt[2]));
            i++;
//            System.out.println(amnt[0] +" "+ amnt[1] +" "+ amnt[2]);
        }

//updating the table view

        historyTableView.setItems(history);
    }


    @FXML
    private void setBtnAddtoTableBill(ActionEvent event)
    {
        Payment pmnt = new Payment();
        boolean add = false;
        double subtotal = 0.0 ;
        double discount;


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
//            calculating the discount
            subtotal = 0.0 ;
            if (!txtDiscount.getText().isEmpty()) {
                discount = Double.parseDouble(txtDiscount.getText());
            } else {
                discount = 0.0;
            }
            if (discount<=100) {
                subtotal= Double.parseDouble(txtAmountBill.getText())*(1-discount/100);
            } else {
                throw new ArithmeticException();
            }

            pmnt.setStuId(txtStuIdBill.getText());
            pmnt.setMonth(cmbMonthBill.getValue().toString());
            pmnt.setSubject(cmbSubjectBill.getValue().toString());
            pmnt.setMethod(cmbPaymentMethod.getValue().toString());
            pmnt.setDescription(txtDescription.getText());
            pmnt.setAmount( subtotal );
            pmnt.createRefId();
            add = pmnt.insertToDatabase();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,"Theare are uncompleted fields in your payment");
            e.printStackTrace();
        }
        catch (ArithmeticException ae)
        {
            JOptionPane.showMessageDialog(null,"The amount entered in the discount field is incorrect ");
        }


        if(add)
        {


//            JOptionPane.showMessageDialog(null,"running");
            ref.add(new Referance(pmnt.getRefID(),pmnt.getSubject(),subtotal));
//
//
            tablePayments.setItems(ref);
            billTotal += subtotal ;

            lblTotalBill.setText( String.valueOf(billTotal));
        }

//        JOptionPane.showMessageDialog(null,pmnt.getRefID());

    }

    @FXML
    private void setBtnPrintBill (ActionEvent event)
    {
        List<String> refId = new ArrayList<String>();
        List<String> subjects = new ArrayList<String>();
        List<Double> amount = new ArrayList<Double>();
        String filename = lblNameBill.getText()+"-"+cmbMonthBill.getValue().toString();
        FileChooser fc = new FileChooser();
        File selFile = fc.showSaveDialog(null); // obataining file path
//        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
        //JOptionPane.showMessageDialog(null,selFile.getPath().toString());


        LocalDate localDate = LocalDate.now();
        JOptionPane.showMessageDialog(null,"print bill");
        PdfDoc doc = new PdfDoc();
//        doc.setLoc("E:\\dinith work\\MyProjects\\Wisdom_Arena\\pdf_output\\"+filename+".Pdf");
        doc.setLoc(selFile.getPath()+"_"+filename+".Pdf");
        doc.setStuName(lblNameBill.getText());
        doc.setGrade(lblGradeBill.getText());
        doc.setSyllabusPdf(lblSyllabusBill.getText());
        doc.setMonth(cmbMonthBill.getValue().toString());
        doc.setDate("2017-12-25");
//        doc.createDoc();

        for(int i =0 ; i < ref.size();i++)
        {
           refId.add(ref.get(i).getRefID()) ;
           subjects.add(ref.get(i).getSubject());
           amount.add(ref.get(i).getAmount());
        }
        doc.setValues(refId,subjects,amount);
        doc.createDocStudentCpy();
//        doc.createDocOfficeCpy();
//
        JOptionPane.showMessageDialog(null,"Bill prinitng succeded");
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

    @FXML
    public void setBtnExecuteReport (ActionEvent event)
    {
        notPaidTableView.getItems().clear();
        stuNoCol.setCellValueFactory(new PropertyValueFactory<NotPaid,String>("stuId"));
        stuNameCol.setCellValueFactory(new PropertyValueFactory<NotPaid,String>("stuName"));
        subColRpt.setCellValueFactory(new PropertyValueFactory<NotPaid,String>("stuSubject"));
        cntNoCol.setCellValueFactory(new PropertyValueFactory<NotPaid,String>("stucontactNo"));
//        notPaid.add(new NotPaid("wa001","dinith","p6","0767"));
        try {
            ConObj conObj = new ConObj();
            Connection conn = conObj.getCon();
            PreparedStatement ps = conn.prepareStatement("SELECT stu_subjects.Stu_Id,student.First_Name,student.Last_Name,stu_subjects.subject,student.ContactNo FROM `stu_subjects` , `student` " +
                    "WHERE student.status = 'active' AND stu_subjects.Stu_Id = student.Stu_Id");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
//                checking whether there is a payment for that perticular subject and student
//                System.out.println(rs.getString(1)+ " "+rs.getString(4));
                String id = rs.getString(1);
                String sub = rs.getString(4);
                PreparedStatement psnew = conn.prepareStatement("SELECT `Reference_ID` FROM `payments` WHERE `Stu_No`= ? AND `subject` = ? AND payments.month = ? ");
                psnew.setString(1,id);
                psnew.setString(2,sub);
                psnew.setString(3,cmbMonthReport.getValue().toString());
                ResultSet rsnew = psnew.executeQuery();
                if(!rsnew.next())
                {String name = rs.getString(2) + " "+ rs.getString(3);

                    notPaid.add(new NotPaid(rs.getString(1),name,rs.getString(4), rs.getString(5)));
                }
            }


        } catch (NullPointerException nullPoint)
        {
            JOptionPane.showMessageDialog(null,"Please input the relavant month");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        notPaidTableView.setItems(notPaid);
    }
    @FXML
    public void setBtnPrintReport(ActionEvent event)
    {
        List<String> stuId = new ArrayList<>();
        List<String> stuName = new ArrayList<>();
        List<String> subject = new ArrayList<>();
        List<String> conNo =  new ArrayList<>();

        for(int i =0 ; i < notPaid.size();i++)
        {
            stuId.add(notPaid.get(i).getStuId()) ;
            stuName.add(notPaid.get(i).getStuName());
            subject.add(notPaid.get(i).getStuSubject());
            conNo.add(notPaid.get(i).getStucontactNo());
        }


//        JFileChooser fc = new JFileChooser();
//        JFileChooser fc = new JFileChooser();
//        int respose = fc.showSaveDialog(SaveFile.this);

        // creating the pdf doc class
        PdfDoc doc = new PdfDoc();


        FileChooser fc = new FileChooser();
        File selFile = fc.showSaveDialog(null); // obataining file path
//        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
       // JOptionPane.showMessageDialog(null,selFile.getPath().toString());
        doc.setLoc(selFile.getPath()+"pdf"); // sending file path
        doc.setValuesNotPaid(stuId,stuName,subject,conNo);
        doc.createReport();





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

    private void  hideAll()
    {
        cmbGenderStu.setDisable(true);
        txtFirstNameStu.setDisable(true);
        txtMiddleNameStu.setDisable(true);
        txtLastNameStu.setDisable(true);
        dobStu.setDisable(true);
        txtAdressStu.setDisable(true);
        txtContactnoStu.setDisable(true);
        txtEmailStu.setDisable(true);
        txtSchoolStu.setDisable(true);

//guardian details
        cmbGenderGuardian.setDisable(true);
        txtFirstNameGuardian.setDisable(true);
        txtMiddleNameGuardian.setDisable(true);
        txtLastNameGuardian.setDisable(true);
        txtContactnoMobileGuardian.setDisable(true);
        txtContactnoOfficeGuardian.setDisable(true);
        txtContactnoHomeGuardian.setDisable(true);
        txtEmailGuardian.setDisable(true);

        dateOfAdmission.setDisable(true);
        cmbSubjects.setDisable(true);
        grade.setDisable(true);
        syllabus.setDisable(true);
    }

    private void unhideall()
    {
        cmbGenderStu.setDisable(false);
        txtFirstNameStu.setDisable(false);
        txtMiddleNameStu.setDisable(false);
        txtLastNameStu.setDisable(false);
        dobStu.setDisable(false);
        txtAdressStu.setDisable(false);
        txtContactnoStu.setDisable(false);
        txtEmailStu.setDisable(false);
        txtSchoolStu.setDisable(false);

//guardian details
        cmbGenderGuardian.setDisable(false);
        txtFirstNameGuardian.setDisable(false);
        txtMiddleNameGuardian.setDisable(false);
        txtLastNameGuardian.setDisable(false);
        txtContactnoMobileGuardian.setDisable(false);
        txtContactnoOfficeGuardian.setDisable(false);
        txtContactnoHomeGuardian.setDisable(false);
        txtEmailGuardian.setDisable(false);

        dateOfAdmission.setDisable(false);
        cmbSubjects.setDisable(false);
        grade.setDisable(false);
        syllabus.setDisable(false);
    }
}

