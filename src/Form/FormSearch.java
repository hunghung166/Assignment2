/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaconsole.enity.Student;
import javaconsole.model.StudentModel;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nguyenhung
 */
public class FormSearch extends JPanel {

    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblRollnumber;
    private JLabel lblClassname;
    private JLabel lblPhone;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtRollnumber;
    private JTextField txtClassname;
    private JTextField txtPhone;
    private JButton btnSearch;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JTextField txtName1;
    private JTextField txtEmail1;
    private JTextField txtClassname1;
    private JTextField txtRollnumber1;
    private JTextField txtPhone1;

    public static void main(String[] args) {
        new FormSearch();
    }

    public FormSearch() {
        this.setBounds(0, 400, 620, 600);

        this.lblId = new JLabel("ID");
        this.lblName = new JLabel("Name");
        this.lblEmail = new JLabel("Email");
        this.lblRollnumber = new JLabel("Rollnumber");
        this.lblClassname = new JLabel("Classname");
        this.lblPhone = new JLabel("Phone");

        this.txtId = new JTextField();
        this.txtName = new JTextField();
        this.txtEmail = new JTextField();
        this.txtRollnumber = new JTextField();
        this.txtClassname = new JTextField();
        this.txtPhone = new JTextField();

        this.txtName1 = new JTextField();
        this.txtEmail1 = new JTextField();
        this.txtRollnumber1 = new JTextField();
        this.txtClassname1 = new JTextField();
        this.txtPhone1 = new JTextField();

        this.btnSearch = new JButton("Search");
        this.btnDelete = new JButton("Delete");
        this.btnUpdate = new JButton("Update");

        this.lblId.setBounds(90, 70, 80, 40);
        this.lblName.setBounds(90, 115, 80, 40);
        this.lblEmail.setBounds(90, 165, 80, 40);
        this.lblRollnumber.setBounds(90, 215, 80, 40);
        this.lblClassname.setBounds(90, 265, 80, 40);
        this.lblPhone.setBounds(90, 315, 80, 40);

        this.txtId.setBounds(205, 70, 200, 40);
        this.txtName.setBounds(205, 115, 200, 40);
        this.txtEmail.setBounds(205, 165, 200, 40);
        this.txtRollnumber.setBounds(205, 215, 200, 40);
        this.txtClassname.setBounds(205, 265, 200, 40);
        this.txtPhone.setBounds(205, 315, 200, 40);

        this.txtName1.setBounds(420, 115, 200, 40);
        this.txtEmail1.setBounds(420, 165, 200, 40);
        this.txtRollnumber1.setBounds(420, 215, 200, 40);
        this.txtClassname1.setBounds(420, 265, 200, 40);
        this.txtPhone1.setBounds(420, 315, 200, 40);

        this.txtName.setEditable(false);
        this.txtEmail.setEditable(false);
        this.txtRollnumber.setEditable(false);
        this.txtClassname.setEditable(false);
        this.txtPhone.setEditable(false);

        this.txtName.setBackground(Color.MAGENTA);
        this.txtEmail.setBackground(Color.MAGENTA);
        this.txtRollnumber.setBackground(Color.MAGENTA);
        this.txtClassname.setBackground(Color.MAGENTA);
        this.txtPhone.setBackground(Color.MAGENTA);

        this.btnSearch.setBounds(450, 70, 100, 40);
        this.btnDelete.setBounds(310, 400, 100, 40);
        this.btnUpdate.setBounds(190, 400, 100, 40);

        this.btnSearch.addActionListener(new SearchHandle());
        this.btnDelete.addActionListener(new DeleteHandle());
        this.btnUpdate.addActionListener(new UpdateHandle());

        this.add(this.lblId);
        this.add(this.lblName);
        this.add(this.lblEmail);
        this.add(this.lblRollnumber);
        this.add(this.lblClassname);
        this.add(this.lblPhone);

        this.add(this.txtId);
        this.add(this.txtName);
        this.add(this.txtEmail);
        this.add(this.txtRollnumber);
        this.add(this.txtClassname);
        this.add(this.txtPhone);

        this.add(this.txtName1);
        this.add(this.txtEmail1);
        this.add(this.txtRollnumber1);
        this.add(this.txtClassname1);
        this.add(this.txtPhone1);

        this.add(this.btnSearch);
        this.add(this.btnDelete);
        this.add(this.btnUpdate);

        this.setVisible(false);
        this.setLayout(null);

    }

    private StudentModel studentModel = new StudentModel();

    private Student getStudent() {
        int id = Integer.parseInt(txtId.getText());
        Student stu = studentModel.getById(id);
        return stu;

    }

    class SearchHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student stu = getStudent();
            if (stu != null) {
                txtName.setText(stu.getName());
                txtEmail.setText(stu.getEmail());
                txtRollnumber.setText(stu.getRollnumber());
                txtClassname.setText(stu.getClassname());
                txtPhone.setText(stu.getPhone());
            }
        }
    }

    class DeleteHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student stu = getStudent();
            int choice;
            choice = JOptionPane.showConfirmDialog(null, "Delete student");
            if (choice == 0) {
                studentModel.deleteId(stu.getId());
                studentModel.getListStudent();
            }
        }
    }

    class UpdateHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student stu = getStudent();

            stu.setName(txtName1.getText());
            stu.setEmail(txtEmail1.getText());
            stu.setRollnumber(txtRollnumber1.getText());
            stu.setClassname(txtClassname1.getText());
            stu.setPhone(txtPhone1.getText());
            studentModel.update(stu);
            JOptionPane.showConfirmDialog(null, "Update Student");
            studentModel.getListStudent();
        }
    }

}
