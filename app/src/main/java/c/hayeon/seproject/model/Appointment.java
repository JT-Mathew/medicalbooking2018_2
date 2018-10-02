package c.hayeon.seproject.model;
import java.util.Date;
import java.util.UUID;

public class Appointment {


    Date appointmentDateTime;
    String studentId;
    String docId;
    UUID appointmentId;

    public Appointment(Date appointmentDateTime, String studentId, String docId, UUID appointmentId) {
        this.appointmentDateTime = appointmentDateTime;
        this.studentId = studentId;
        this.docId = docId;
        appointmentId = UUID.randomUUID();
    }

    public Date getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(Date appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }
}