package c.hayeon.seproject.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

    String firstName;
    String lastName;
    String studentId;
    String password;
    String roadNumber;
    String streetName;
    String suburbName;
    int postcode;
    List<Appointment> currentAppointments= new ArrayList<Appointment>();
    List<Appointment> pastAppointments = new ArrayList<Appointment>();

    public User(String firstName, String lastName, String studentId, String password, String roadNumber, String streetName, String suburbName, int postcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.roadNumber = roadNumber;
        this.streetName = streetName;
        this.suburbName = suburbName;
        this.postcode = postcode;
        this.password = password;
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

    public String getRoadNumber() {
        return roadNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburbName() {
        return suburbName;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoadNumber(String roadNumber) {
        this.roadNumber = roadNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void makeAppointment(Appointment appointment){
        currentAppointments.add(appointment);
    }

    public void saveAppointment(Appointment appointment){
        pastAppointments.add(appointment);
    }
}