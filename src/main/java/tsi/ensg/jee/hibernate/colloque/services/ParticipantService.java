package tsi.ensg.jee.hibernate.colloque.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tsi.ensg.jee.hibernate.colloque.metier.Participant;


public class ParticipantService {


    private final SessionFactory sessionFactory;

    public ParticipantService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertParticipant(Participant participant) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(participant);
        session.getTransaction().commit();
        session.close();
    }
}
