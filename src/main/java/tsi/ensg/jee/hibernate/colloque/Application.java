package tsi.ensg.jee.hibernate.colloque;

import tsi.ensg.jee.hibernate.colloque.metier.Participant;
import tsi.ensg.jee.hibernate.colloque.services.EvenementService;
import tsi.ensg.jee.hibernate.colloque.metier.Evenement;
import tsi.ensg.jee.hibernate.colloque.services.ParticipantService;

import java.util.List;

public class Application {

    public static void main(String[] args) {


        //Evenement eve1 = new Evenement(9, "even12", "theme1", "2022-01-30", 15, 10, "descri1", "orga1","type1");
        Evenement eve2 = new Evenement(2, "even2", "theme2", "2022-01-29", 16, 11, "descri2", "orga2","type2");

        EvenementService service_ev = new EvenementService();

        List<Evenement> liste = service_ev.getAll();

        System.out.println("/////////////////////////////////////////////////////////////////////////");
        System.out.println(liste);
        System.out.println(liste.toArray().length);


        //insert_test.insertEvenement(eve1);


        Participant parti1 = new Participant(4,"iiiii", "Bobbite", "bob@bob.fr", "1999-02-07", "Org1", "pas dobs");
        //Participant parti2 = new Participant(2,"Bob2", "Bobby2", "bob2@bob.fr", "1999-02-08", "Org2", "pas dobs2");
        //Participant parti3 = new Participant(3,"Bob3", "Bobby3", "bob3@bob.fr", "1999-02-09", "Org3", "pas dobs3");

        ParticipantService service = new ParticipantService();

        Evenement eve1 = service_ev.get(3);
        //         Participant parti1 = service.get(1);
        //       Participant parti2 = service.get(2);
        //     Participant parti3 = service.get(3);

//        List<Participant> participants =  eve1.getParticipants();
//        System.out.println("/////////////////////////////////////////////////////////////////////////");
//
//        for (int i = 0; i < participants.size(); i++)
//        {
//            Participant participant = participants.get(i);
//            System.out.println(participant);
//        }


        eve1.addParticipant(parti1);
        //eve1.addParticipant(parti2);

        //eve2.addParticipant(parti3);



        EvenementService insert_test = new EvenementService();
        insert_test.insertEvenement(eve1);
        //insert_test.insertEvenement(eve2);

        List <Participant> participants2 = eve1.getParticipants();
        for (int i = 0; i < participants2.size(); i++)
            {
              Participant participant = participants2.get(i);
              System.out.println(participant);
          }
    }


}
