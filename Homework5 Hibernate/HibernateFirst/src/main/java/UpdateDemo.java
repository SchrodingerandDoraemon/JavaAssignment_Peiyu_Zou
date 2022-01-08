import org.hibernate.Session;
import org.hibernate.query.Query;

public class UpdateDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        //Here the Engineer use the class name rather than the table name
        // The hql is case-sensitve and the space is important. Elment name are not case sensitve(e.g .in WHERE Willian and willian are same)
        String hql = "UPDATE Engineer SET Last_Name= :lastName, "+ "First_Name = :fn " + "WHERE Employ_ID = :ID AND " + "First_Name = :firstName";
        Query query = session.createQuery(hql);
        query.setParameter("lastName", "Gates");
        query.setParameter("ID", 2);
        query.setParameter("fn", "Willian");
        query.setParameter("firstName", "willian");
        int result = query.executeUpdate();
        System.out.println("result:" + result);
        session.getTransaction().commit();
        session.close();
    }
}
