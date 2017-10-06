/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Panel;
import java.util.ArrayList;
import javaconsole.enity.Student;
import javaconsole.model.StudentModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyenhung
 */
public class FormList extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    
    public static void main(String[] args) {
        FormList formList = new FormList();
    }

    public FormList() {
        
        

        table = new JTable();
        tableModel = new DefaultTableModel();
        scrollPane = new JScrollPane(table);
        table.setLayout(null);

        this.setSize(620, 400);
        this.setLayout(null);
        scrollPane.setBounds(15, 20, 600, 400);

        tableModel.addColumn("Id");
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Rollnumber");
        tableModel.addColumn("Classname");
        tableModel.addColumn("Phone");

        StudentModel studentModel = new StudentModel();
        ArrayList<Student> list = studentModel.getListStudent();
        for (Student student : list) {
            Object[] str = new Object[]{student.getId(), student.getName(), student.getEmail(), student.getRollnumber(), student.getClassname(), student.getPhone()};
            tableModel.addRow(str);

        }
        table.setModel(tableModel);
        table.setRowHeight(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);

        //  
        this.add(scrollPane);
        this.setVisible(true);
        
    }

}
