import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;



public class helper {
    private static SessionFactory dbSession;

    public static SessionFactory getSessionFactory()
    {
        if (dbSession == null)
        {
            Configuration conf = new Configuration().configure("/hibernate.cfg.xml");
            conf.addAnnotatedClass(Class.class);
            conf.addAnnotatedClass(Progress.class);
            conf.addAnnotatedClass(Student.class);
            conf.addAnnotatedClass(Teacher.class);
            conf.addAnnotatedClass(Subject.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
            dbSession = conf.buildSessionFactory(builder.build());
        }
        return dbSession;
    }

    public String checkStudent(String surname)
    {
        Session session = null;
        if (dbSession == null)
        {
            dbSession = getSessionFactory();
        }

        session = dbSession.openSession();
        try {
            Query query = session.createQuery("from Student where login = :surn");
            query.setParameter("surn", surname);
            List student = query.list();
            if (student.size() == 0) {
                return "no data";
            }

            Student st = (Student) student.iterator().next();
            return "Name: " + st.getName() + " Secondname: "+ st.getSecondname();


        } catch (HibernateException ex)
        {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return "not connection";
    }
    public String InsertStud(String surname, String name, String secondname, String email)
    {
        if(dbSession == null)
        {
            dbSession = getSessionFactory();
        }
        Session session = dbSession.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Student st = new Student();
            st.setSurname(surname);
            st.setName(name);
            st.setSecondname(secondname);
            st.setEmail(email);
            session.save(st);
            transaction.commit();

        }
        catch(HibernateException ex)
        {
            if(transaction !=null)
                transaction.rollback();
            ex.printStackTrace();
            return "Ошибка транзакций";
        }
        finally{
            session.close();
        }

        return "данные получены";
    }
}
