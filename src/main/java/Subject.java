import javax.persistence.*;

@Entity
@Table(name= "Subject")

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name= "title")
    private String title;

    public void setId (Integer id) {this.id = id;}

    public void setTitle (String title) {this.title = title;}

    public Integer getId () {return id;}

    public String getTitle() {return title;}
}
