import org.hibernate.Session;
import org.hibernate.query.Query;

public class DeleteDemo {
    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        String hql = "DELETE FROM Engineer "+"WHERE Employ_ID= 1";
        Query query = session.createQuery(hql);
        int resutl = query.executeUpdate();
        System.out.println("successfully delete:" + resutl);
        session.getTransaction().commit();
        session.close();
    }



}
