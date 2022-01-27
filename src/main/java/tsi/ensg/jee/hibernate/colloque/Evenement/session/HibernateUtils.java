package tsi.ensg.jee.hibernate.colloque.Evenement.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import tsi.ensg.jee.hibernate.colloque.Evenement.metier.Evenement;

import java.util.List;

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

    public void insertEvenement(Evenement evenement) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(evenement);
        session.getTransaction().commit();
        session.close();
    }

    public List<Evenement> getAllEvenement (){
        Session session = sessionFactory.openSession();
        List<Evenement> result = session.createQuery("from Evenement").list();
        session.close();
        return result;
    }


}
