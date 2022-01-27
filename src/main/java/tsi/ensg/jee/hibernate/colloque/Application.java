package tsi.ensg.jee.hibernate.colloque;

import tsi.ensg.jee.hibernate.colloque.Participant.services.ParticipantDAO;
import tsi.ensg.jee.hibernate.colloque.Participant.metier.Participant;
import tsi.ensg.jee.hibernate.colloque.Evenement.services.EvenementDAO;
import tsi.ensg.jee.hibernate.colloque.Evenement.services.EvenementService;
import tsi.ensg.jee.hibernate.colloque.Evenement.metier.Evenement;

import javax.transaction.Transactional;
import java.util.List;
import java.util.ArrayList;
public class Application {

    public static void main(String[] args) {


        Evenement eve1 = new Evenement(1, "even1", "theme1", "2022-01-30", 15, 10, "descri1", "orga1","type1");

        Participant parti1 = new Participant(1,"Bob", "Bobby", "bob@bob.fr", "1999-02-07", "Org1", "pas dobs");
        Participant parti2 = new Participant(2,"Bob2", "Bobby2", "bob2@bob.fr", "1999-02-08", "Org2", "pas dobs2");

        eve1.addParticipant(parti1);
        eve1.addParticipant(parti2);


        EvenementService insert_test = new EvenementService();
        insert_test.insertEvenement(eve1);

    }


}
