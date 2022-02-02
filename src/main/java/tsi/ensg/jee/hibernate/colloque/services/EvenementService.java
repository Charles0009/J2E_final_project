package tsi.ensg.jee.hibernate.colloque.services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;


import tsi.ensg.jee.hibernate.colloque.metier.Evenement;
import tsi.ensg.jee.hibernate.colloque.metier.Participant;
import tsi.ensg.jee.hibernate.colloque.session.Evenement.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class EvenementService {

    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();

    public EvenementService(){
    }

    public void insertEvenement(Evenement evenement) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(evenement);
        session.getTransaction().commit();
        session.close();
    }

    public boolean deleteEvenement(int id) {
        Evenement evenementToDelete = this.get(id);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(evenementToDelete);
        session.getTransaction();
        session.close();
        return true;
    }

    public Evenement get(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Evenement result = session.get(Evenement.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
    public ArrayList<Evenement> getAll() {
        Session session = sessionFactory.openSession();
        ArrayList<Evenement> result = (ArrayList<Evenement>) session.createQuery("from Evenement").list();
        session.close();
        return result;
    }


}
