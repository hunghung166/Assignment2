/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javaconsole.enity.Student;

/**
 *
 * @author nguyenhung
 */
public class StudentModel {

    private long startTime;

    public ArrayList<Student> getListStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM student;");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getNString("name"));
                student.setEmail(rs.getNString("email"));
                student.setRollnumber(rs.getNString("roll_number"));
                student.setClassname(rs.getNString("class_name"));
                student.setPhone(rs.getString("phone"));
                listStudent.add(student);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình lấy danh sách sinh viên" + e.getMessage());
        }
        return listStudent;
    }

    public void insert(Student student) {
        try {
            java.sql.Connection cnn = DAO.getConnection();
            Statement stt = cnn.createStatement();
            StringBuilder sqlQueryBuilder = new StringBuilder();
            sqlQueryBuilder.append("INSERT INTO student (name, email, roll_number, class_name, phone)");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("VALUES");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("(");
            sqlQueryBuilder.append("'" + student.getName() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getEmail() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getRollnumber() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getClassname() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getPhone() + "'");
            sqlQueryBuilder.append(");");

            System.out.println(sqlQueryBuilder.toString());

            stt.execute(sqlQueryBuilder.toString());

        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình insert dữ liệu " + e.getMessage());;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian chạy mất: " + (endTime - startTime) + " (mls). ");
    }

    public void update(Student s) {
        System.out.println("Updat: "+ s.toString());
        String sqlCommand = "update student set name=?, email=?, roll_number=?, class_name=?, phone=? where id = ?";
        try {
            java.sql.Connection cnn = DAO.getConnection();
            PreparedStatement pst = cnn.prepareStatement(sqlCommand);
            pst.setString(1, s.getName());
            pst.setString(2, s.getEmail());
            pst.setString(3, s.getRollnumber());
            pst.setString(4, s.getClassname());
            pst.setString(5, s.getPhone());
            pst.setInt(6, s.getId());
            pst.execute();
            if (pst.executeUpdate() > 0) {
                System.out.println("Thành công");
            } else {
                System.out.println("Thất bại");
            }
        } catch (SQLException e) {
            System.err.println("Cập nhật thất bại" + e.getMessage());
        }
    }

    public void deleteId(int id) {
        String sqlCommand = "DELETE FROM student WHERE id = ?";
        try {
            PreparedStatement pst = DAO.getConnection().prepareStatement(sqlCommand);
            pst.setInt(1, id);
            System.out.println("Xoá thành công");
            pst.execute();
        } catch (SQLException e) {
            System.err.println("Xoá thất bại " + e.getMessage());
        }

    }

    public Student getById(int Id) {
        try {
            java.sql.Connection cnn = DAO.getConnection();
            PreparedStatement pst = cnn.prepareStatement("SELECT * FROM student where id=?");
            pst.setInt(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getNString("name"));
                student.setEmail(rs.getNString("email"));
                student.setRollnumber(rs.getNString("roll_number"));
                student.setClassname(rs.getNString("class_name"));
                student.setPhone(rs.getString("phone"));
                System.out.println(student.toString());
                return student;
            }
        } catch (SQLException e) {
            System.err.println("Lỗi câu lệnh SQL");
        }
        return null;

    }

    public static void main(String[] args) {
        StudentModel st = new StudentModel();
//        st.deleteId(3);
////        st.getListStudent();
//        st.update(3, new Student(13, "Hùng Việt", "hungviet@gmail.com", "3333", "6666", "84 123 123 123"));
    }
}
