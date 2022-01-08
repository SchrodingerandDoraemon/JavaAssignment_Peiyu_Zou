import org.hibernate.Session;
import org.hibernate.query.Query;

public class InsertDemo {
    public static void main(String[] arg){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        String hql = "INSERT INTO Engineer(Employ_ID, First_Name, Last_Name)" +
                "SELECT ID, FirstName, LastName FROM backup";
        Query query = session.createQuery(hql);
        int result = query.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();
        session.close();

    }
}
