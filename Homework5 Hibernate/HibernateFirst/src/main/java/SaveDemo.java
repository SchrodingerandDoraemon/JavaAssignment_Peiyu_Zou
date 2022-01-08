import org.hibernate.Session;
import org.hibernate.query.Query;

public class SaveDemo {
    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Engineer engineer1 = new Engineer();
        engineer1.setEmail("bill@microsoft.com");
        engineer1.setFirstName("bill");
        engineer1.setLastName("Zuckerberg");
        engineer1.setEmployID(2);
        engineer1.setSenior(true);

        session.beginTransaction();
        session.save(engineer1);
//        Engineer a = (Engineer) session.get(Engineer.class, 1);
//        Query query = session.createQuery("FROM Engineer Where rollno=?");
        session.getTransaction().commit();
        session.close();
    }
}
