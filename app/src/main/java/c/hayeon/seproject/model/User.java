package c.hayeon.seproject.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

    public String firstName;
    public String lastName;
    public String studentId;
    public String password;
    public String address1;
    public String address2;
    public String mobile;
    public String email;
    public String dob;


    List<Appointment> currentAppointments= new ArrayList<>();
    List<Appointment> pastAppointments = new ArrayList<>();

    public User() {

    }

    public User(String firstName, String lastName, String studentId, String password, String address1, String address2, String mobile, String email, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.address1 = address1;
        this.address2 = address2;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.dob = dob;
    }

    public List<Appointment> getCurrentAppointments() {
        return currentAppointments;
    }

    public List<Appointment> getPastAppointments() {
        return pastAppointments;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentId(String studentId) { this.studentId = studentId;}

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void makeAppointment(Appointment appointment){
        currentAppointments.add(appointment);
    }

    public void saveAppointment(Appointment appointment){
        pastAppointments.add(appointment);
    }
}