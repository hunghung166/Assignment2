package MenuBar;

import Form.FormAdd;
import Form.FormList;
import Form.FormSearch;
import java.awt.CardLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyMenuBar extends JFrame {

    public static void main(String[] args) {
        new MyMenuBar();
    }
    private JFrame frame = new JFrame();

    private JMenuBar menuBar = new JMenuBar();

    private JMenu menu1 = new JMenu("Menu");
    private JMenuItem itemAddSt = new JMenuItem("Add Student");
    private JMenuItem itemListSt = new JMenuItem("List Student");
    private JMenuItem itemEditSt = new JMenuItem("Edit Student");

    private JMenuItem menu2 = new JMenuItem("About me");

    private FormAdd Add = new FormAdd();
    private FormList List = new FormList();
    private FormSearch Search = new FormSearch();

    private FormList tableList = new FormList();

    public MyMenuBar() {

//        JPanel panel = new JPanel();
//        panel.setLayout(card);
//
//        
        menu1.add(itemAddSt);
        menu1.add(itemListSt);
        menu1.add(itemEditSt);

        menuBar.add(menu1);
        menuBar.add(menu2);

        frame.setJMenuBar(menuBar);
        frame.add(Add);
        frame.add(List);
        frame.add(Search);
        frame.add(tableList);

        frame.setSize(630, 1000);
        frame.setVisible(true);
//        menu2.addActionListener(this);
        itemAddSt.addActionListener(new Add());
        itemListSt.addActionListener(new List());
        itemEditSt.addActionListener(new Edit());
    }

    class Add implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Add.setVisible(true);
            List.setVisible(false);
            Search.setVisible(false);

        }
    }

    class List implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Add.setVisible(false);
            List.setVisible(true);
            Search.setVisible(false);
        }

    }

    class Edit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Add.setVisible(false);
            List.setVisible(false);
            Search.setVisible(true);
        }

    }
}
