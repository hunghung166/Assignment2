/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javaconsole.enity.Student;
import javaconsole.model.StudentModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author nguyenhung
 */
public class FormAdd extends JPanel {

    private JLabel lblName;
    private JTextField txtName;
    private JButton btnLogin;
    private JButton btnReset;
    private JLabel lblPhone;
    private JLabel lblEmail;
    private JLabel lblRollnumber;
    private JLabel lblClassname;
    private JTextField txtEmail;
    private JTextField txtRollnumber;
    private JTextField txtClassname;
    private JFormattedTextField txfPhone;
    private JLabel lblNameMessage;
    private JLabel lblEmailtMessage;
    private JLabel lblRollnumbertMessage;
    private JLabel lblClassnametMessage;
    private JLabel lblTotalMessage;
    private JLabel lblPhonetMessage;

    public FormAdd() {
        this.setBounds(10, 400, 620, 600);

//        khởi tạo các component con
        this.lblName = new JLabel("Name");
        this.lblEmail = new JLabel("Email");
        this.lblRollnumber = new JLabel("Rollnumber");
        this.lblClassname = new JLabel("Classname");
        this.lblPhone = new JLabel("Phone");

        this.lblTotalMessage = new JLabel();
        this.lblNameMessage = new JLabel();
        this.lblEmailtMessage = new JLabel();
        this.lblRollnumbertMessage = new JLabel();
        this.lblClassnametMessage = new JLabel();
        this.lblPhonetMessage = new JLabel();

        this.txtName = new JTextField();
        this.txtEmail = new JTextField();
        this.txtRollnumber = new JTextField();
        this.txtClassname = new JTextField();

        JFormattedTextField txfPhone;
        MaskFormatter formatter2 = null;
        try {
            formatter2 = new MaskFormatter("+84 ### ### ###");
        } catch (ParseException e) {
            System.err.println("Hãy nhập đúng định dạng" + e.getMessage());
            System.exit(0);
        }
        this.txfPhone = new JFormattedTextField(formatter2);

        this.btnLogin = new JButton("Login");
        this.btnReset = new JButton("Reset");

//        Định vị toạ độ cho các component
        this.lblName.setBounds(90, 115, 80, 40);
        this.lblEmail.setBounds(90, 165, 80, 40);
        this.lblRollnumber.setBounds(90, 215, 80, 40);
        this.lblClassname.setBounds(90, 265, 80, 40);
        this.lblPhone.setBounds(90, 315, 80, 40);

        this.lblTotalMessage.setBounds(200, 25, 300, 40);
        this.lblNameMessage.setBounds(550, 115, 200, 40);
        this.lblEmailtMessage.setBounds(550, 165, 200, 40);
        this.lblRollnumbertMessage.setBounds(550, 215, 200, 40);
        this.lblClassnametMessage.setBounds(550, 265, 200, 40);
        this.lblPhonetMessage.setBounds(550, 315, 200, 40);

        this.txtName.setBounds(205, 115, 300, 40);
        this.txtEmail.setBounds(205, 165, 300, 40);
        this.txtRollnumber.setBounds(205, 215, 300, 40);
        this.txtClassname.setBounds(205, 265, 300, 40);
        this.txfPhone.setBounds(205, 315, 300, 40);

        this.btnLogin.setBounds(220, 400, 130, 40);
        this.btnReset.setBounds(360, 400, 130, 40);

//        xử lý sự kiện
        this.btnLogin.addActionListener(new LoginHandle());
        this.btnReset.addActionListener(new ResetHandle());

        this.setLayout(null);
//        Thêm component vào container
        this.add(this.lblName);
        this.add(this.lblEmail);
        this.add(this.lblRollnumber);
        this.add(this.lblClassname);
        this.add(this.lblPhone);

        this.add(this.lblTotalMessage);
        this.add(this.lblNameMessage);
        this.add(this.lblEmailtMessage);
        this.add(this.lblRollnumbertMessage);
        this.add(this.lblClassnametMessage);
        this.add(this.lblPhonetMessage);

        this.add(this.txtName);
        this.add(this.txtEmail);
        this.add(this.txtRollnumber);
        this.add(this.txtClassname);
        this.add(this.txfPhone);

        this.add(this.btnLogin);
        this.add(this.btnReset);

        this.setVisible(false);
    }

    class LoginHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student stu = new Student();
            stu.setName(txtName.getText());
            stu.setEmail(txtEmail.getText());
            stu.setRollnumber(txtRollnumber.getText());
            stu.setClassname(txtClassname.getText());
            stu.setPhone(txfPhone.getText());

            HashMap<String, String> errors = new FormHandle().validateLogin(stu);
            if (errors.size() == 0) {
                resetMessage();
                StudentModel studentM = new StudentModel();
                studentM.insert(stu);
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                studentM.getListStudent();
            } else {
                showError(errors);
            }
        }
    }

    private void resetMessage() {
        lblTotalMessage.setText("");
        lblNameMessage.setText("");
        lblEmailtMessage.setText("");
        lblRollnumbertMessage.setText("");
        lblClassnametMessage.setText("");
        lblPhonetMessage.setText("");
    }

    private void showError(HashMap<String, String> errors) {
        lblTotalMessage.setForeground(Color.red);
        lblTotalMessage.setText("* Vui lòng sửa các lỗi bên dưới và submit lại form.");

        if (errors.containsKey("txtName")) {
            lblNameMessage.setForeground(Color.red);
            lblNameMessage.setText(errors.get("txtName"));
        } else {
            lblNameMessage.setForeground(Color.green);
            lblNameMessage.setText("Hợp lệ.");
        }

        if (errors.containsKey("txtEmail")) {
            lblEmailtMessage.setForeground(Color.red);
            lblEmailtMessage.setText(errors.get("txtEmail"));
        } else {
            lblEmailtMessage.setForeground(Color.green);
            lblEmailtMessage.setText("Hợp lệ.");
        }

        if (errors.containsKey("txtRollnumber")) {
            lblRollnumbertMessage.setForeground(Color.red);
            lblRollnumbertMessage.setText(errors.get("txtRollnumber"));
        } else {
            lblRollnumbertMessage.setForeground(Color.green);
            lblRollnumbertMessage.setText("Hợp lệ.");
        }

        if (errors.containsKey("txtClassname")) {
            lblClassnametMessage.setForeground(Color.red);
            lblClassnametMessage.setText(errors.get("txtClassname"));
        } else {
            lblClassnametMessage.setForeground(Color.green);
            lblClassnametMessage.setText("Hợp lệ.");
        }

        if (errors.containsKey("txfPhone")) {
            lblPhonetMessage.setForeground(Color.red);
            lblPhonetMessage.setText(errors.get("txfPhone"));
        } else {
            lblPhonetMessage.setForeground(Color.green);
            lblPhonetMessage.setText("Hợp lệ.");
        }
    }

    class ResetHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Đã xoá");
            txtName.setText("");
            txtEmail.setText("");
            txtRollnumber.setText("");
            txtClassname.setText("");
            txfPhone.setText("");
        }

    }

    public class FormHandle {

        public HashMap<String, String> validateLogin(Student stu) {
            HashMap<String, String> errors = new HashMap<>();

            if (stu.getName().isEmpty()) {
                errors.put("txtName", "Vui lòng nhập tên.");

            }

            if (stu.getEmail().isEmpty()) {
                errors.put("txtEmail", "Vui lòng nhập email.");
            }

            if (stu.getPhone().isEmpty()) {
                errors.put("txfPhone", "Vui lòng nhập số điện thoại");
            }

            if (stu.getRollnumber().isEmpty()) {
                errors.put("txtRollnumber", "Vui lòng nhập Rollnumber");
            }

            if (stu.getClassname().isEmpty()) {
                errors.put("txtClassname", "Vui lòng nhập Classname");
            }

            return errors;
        }

    }

}
