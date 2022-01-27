package tsi.ensg.jee.hibernate.colloque.Evenement.services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tsi.ensg.jee.hibernate.colloque.Evenement.metier.Evenement;
import tsi.ensg.jee.hibernate.colloque.Evenement.session.HibernateUtils;

import java.util.List;

public class EvenementService {

//
//    private final SessionFactory sessionFactory;
    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();

    public EvenementService(){

    }

//    public EvenementService(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public void insertEvenement(Evenement evenement) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(evenement);
        session.getTransaction().commit();
        session.close();
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