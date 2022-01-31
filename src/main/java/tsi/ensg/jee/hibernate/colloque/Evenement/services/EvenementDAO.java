package tsi.ensg.jee.hibernate.colloque.Evenement.services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import tsi.ensg.jee.hibernate.colloque.metier.Evenement;
import tsi.ensg.jee.hibernate.colloque.session.Evenement.HibernateUtils;


public class EvenementDAO {


    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();
    public EvenementDAO() {
    }

    //, ArrayList<Participant> participants

    public long create(int num_even, String titre, String theme, String start_date, int duree, int max_participants, String description, String organisateur, String type) {
        Evenement evenement = new Evenement( num_even,  titre,  theme,  start_date,  duree,  max_participants,  description,  organisateur,  type);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(evenement);
        session.getTransaction().commit();
        session.close();
        return evenement.getId();
    }
    public boolean delete(long id) {
        Evenement evenementToDelete = this.get(id);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(evenementToDelete);
        session.getTransaction();
        session.close();
        return true;
    }

    public Evenement get(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Evenement result = session.get(Evenement.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
    public List<Evenement> getAll() {
        Session session = sessionFactory.openSession();
        List<Evenement> result = session.createQuery("from Evenement").list();
        session.close();
        return result;
    }


}
