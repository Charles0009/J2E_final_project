package tsi.ensg.jee.hibernate.colloque.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tsi.ensg.jee.hibernate.colloque.metier.Participant;
import tsi.ensg.jee.hibernate.colloque.session.Participant.HibernateUtils;

import java.util.ArrayList;
import java.util.List;


public class ParticipantService {


    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();

    public ParticipantService(){}

//    public ParticipantService(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public void insertParticipant(Participant participant) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(participant);
        session.getTransaction().commit();
        session.close();
    }

    public boolean deleteParticipant(int id) {
        Participant participantToDelete = this.get(id);
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(participantToDelete);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    public Participant get(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Participant result = session.get(Participant.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
    public ArrayList<Participant> getAll() {
        Session session = sessionFactory.openSession();
        ArrayList<Participant> result = (ArrayList<Participant>) session.createQuery("from Participant").list();
        session.close();
        return result;
    }
}
