package tsi.ensg.jee.hibernate.colloque.Participant.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

import tsi.ensg.jee.hibernate.colloque.session.Participant.HibernateUtils;
import tsi.ensg.jee.hibernate.colloque.metier.Participant;

public class ParticipantDAO {

    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();
    public ParticipantDAO() {
    }
//, List<Evenement> attending_events

    public long create(int num_pers,String nom,String prenom,String email, String date_naiss, String organisation, String observations) {
        Participant participant = new Participant(num_pers, nom, prenom, email,  date_naiss,  organisation,  observations);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(participant);
        session.getTransaction().commit();
        session.close();
        return participant.getId();
    }
    public boolean delete(long id) {
        Participant participantToDelete = this.get(id);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(participantToDelete);
        session.getTransaction();
        session.close();
        return true;
    }

//    public boolean update(long id) {
//        Participant participantToUpdate = this.get(id);
//        int salary = participantToUpdate.getSalary();
//        if (salary<1000) {
//            salary +=  100;
//        } else {
//            salary += salary * 0.1;
//        }
//        participantToUpdate.setSalary(salary);
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.merge(employeeToUpdate);
//        session.getTransaction().commit();
//        session.close();
//        return true;
//    }

    public Participant get(long id) {
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

//    public List<Participant> getAllByFirstName(String firstName) {
//        Session session = sessionFactory.openSession();
//        List<Participant> result = session.createQuery("from Employee p where p.firstName = :firstName").setParameter("firstName", firstName).list();
//        session.close();
//        return result;
//    }

}
