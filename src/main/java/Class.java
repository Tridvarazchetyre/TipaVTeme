import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Class")

public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name= "theme")
    private String theme;
    @Column(name= "data")
    private Date date;
    @Column(name= "teacher")
    private String teacher;


    public void setId (Integer id) {this.id = id;}

    public void setTheme (String theme) {this.theme = theme;}

    public void setDate (Date date) {this.date = date;}

    public void setTeacher (String teacher) {this.teacher = teacher;}

    public Integer getId () {return id;}

    public String getTheme() {return theme;}

    public Date getDate () {return date;}

    public String getTeacher () {return teacher;}
}
