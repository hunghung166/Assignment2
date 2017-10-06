/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.enity;

/**
 *
 * @author nguyenhung
 */
public class Student {

    private int id;
    private String name;
    private String email;
    private String rollnumber;
    private String classname;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    

    public Student(int id, String name, String email, String rollnumber, String classname, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rollnumber = rollnumber;
        this.classname = classname;
        this.phone = phone;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", rollnumber=" + rollnumber + ", classname=" + classname + ", phone=" + phone + '}';
    }

}
