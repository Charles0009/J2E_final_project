package tsi.ensg.jee.hibernate.colloque.Participant.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tsi.ensg.jee.hibernate.colloque.Participant.metier.Participant;


public class ParticipantService {


    private final SessionFactory sessionFactory;

    public ParticipantService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertParticipant(Participant participant) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(participant);
        session.getTransaction().commit();
        session.close();
    }
}
