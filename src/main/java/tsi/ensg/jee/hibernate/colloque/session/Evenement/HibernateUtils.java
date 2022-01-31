package tsi.ensg.jee.hibernate.colloque.session.Evenement;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {


    public final SessionFactory sessionFactory =  createSessionFactory();
    public static SessionFactory createSessionFactory() {
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
        try {
            return (SessionFactory) new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder
                    .destroy(registry);
        }
        return null;
    }

}
