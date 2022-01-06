import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    Configuration configuration = new Configuration().configure().addAnnotatedClass();
    ServiceRegistry serviceRegistry = new ServiceRegistryBUilder()
    private static SessionFactory sessionFactory = buildSessionFactory();

}
