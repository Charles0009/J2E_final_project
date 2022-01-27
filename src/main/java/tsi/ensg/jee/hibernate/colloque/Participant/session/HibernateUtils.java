package tsi.ensg.jee.hibernate.colloque.Participant.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import tsi.ensg.jee.hibernate.colloque.Participant.metier.Participant;

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

    public void insertParticipant(Participant participant) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(participant);
        session.getTransaction().commit();
        session.close();
    }

    public List<Participant> getAllParticipants (){
        Session session = sessionFactory.openSession();
        List<Participant> result = session.createQuery("from Participant").list();
        session.close();
        return result;
    }

}
