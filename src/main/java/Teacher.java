
import javax.persistence.*;

@Entity
@Table(name= "Teacher")


public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name= "surname")
    private String surname;
    @Column(name= "name")
    private String name;
    @Column(name= "secondname")
    private String secondname;
    @Column(name= "email")
    private String email;

    public void setSurname(String surname){this.surname = surname; }

    public void setName (String name) {this.name = name;}

    public void setSecondname (String secondname) {this.secondname = secondname;}

    public void setEmail (String email) {this.email = email;}

    public void setId (Integer id) {this.id = id;}

    public String getSurname () {return surname;}

    public String getName () {return name;}

    public String getSecondname () {return secondname;}

    public String getEmail () {return email;}

    public Integer getId () {return id;}
}