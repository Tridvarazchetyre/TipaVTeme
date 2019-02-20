import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Progress")


public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name= "student")
    private String student;
    @Column(name= "subject")
    private String subject;
    @Column(name= "class")
    private String clas;
    @Column(name= "assessment")
    private String assessment;
    @Column(name= "attendance")
    private String attendance;
    @Column(name= "comment")
    private String comment;

    public void setId (Integer id) {this.id = id;}

    public void setStudent (String student) {this.student = student;}

    public void setSubject (String subject) {this.subject = subject;}

    public void setAssessment (String assessment) {this.assessment = assessment;}

    public void setAttendance (String attendance) {this.attendance = attendance;}

    public void setComment (String comment) {this.comment = comment;}


    public Integer getId (Integer id) {return id;}

    public String getStudent (String student) {return student;}

    public String getSubject (String subject) {return subject;}

    public String getAssessment (String assessment) {return assessment;}

    public String getAttendance (String attendance) {return attendance;}

    public String getComment (String comment) {return comment;}


}
