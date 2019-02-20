import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class studDao {
    public void save(Student st)
    {
        Session session = helper.getSessionFactory().openSession();
        Transaction tran = session.beginTransaction();
        session.save(st);
        tran.commit();
        session.close();
    }
    public void update(Student st)
    {
        Session session = helper.getSessionFactory().openSession();
        Transaction tran = session.beginTransaction();
        session.update(st);
        tran.commit();
        session.close();

    }
    public void delete(Student st)
    {
        Session session = helper.getSessionFactory().openSession();
        Transaction tran = session.beginTransaction();
        session.delete(st);
        tran.commit();
        session.close();

    }
    public List<Student> getAll(){
        List<Student> stud = (List<Student>)helper.getSessionFactory().openSession().createQuery("from Student").list();
        return  stud;
    }


    public Student getStudent(String surname){
        Session session = helper.getSessionFactory().openSession();
        Query query = session.createQuery("from Student where surname = :sname");
        query.setParameter("sname", surname);
        List list = query.list();
        Student st = (Student) list.iterator().next();
        session.close();
        return st;
    }
}

