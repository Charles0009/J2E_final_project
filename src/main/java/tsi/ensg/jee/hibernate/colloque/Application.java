package tsi.ensg.jee.hibernate.colloque;

import tsi.ensg.jee.hibernate.colloque.metier.Participant;
import tsi.ensg.jee.hibernate.colloque.services.EvenementService;
import tsi.ensg.jee.hibernate.colloque.metier.Evenement;
import tsi.ensg.jee.hibernate.colloque.services.ParticipantService;

import javax.servlet.http.Part;
import java.util.List;

public class Application {

    public static void main(String[] args) {


 //       Evenement eve1 = new Evenement(9, "even12", "theme1", "2022-01-30", 15, 10, "descri1", "orga1","type1");
  //      Evenement eve2 = new Evenement(2, "even2", "theme2", "2022-01-29", 16, 11, "descri2", "orga2","type2");
        Participant parti1 = new Participant(4,"Bob4", "Bobby", "bob@bob.fr", "1999-02-07", "Org1", "pas dobs");
        Participant parti2 = new Participant(2,"Bob2", "Bobby2", "bob2@bob.fr", "1999-02-08", "Org2", "pas dobs2");
        Participant parti3 = new Participant(3,"Bob3", "Bobby3", "bob3@bob.fr", "1999-02-09", "Org3", "pas dobs3");

        EvenementService service_ev = new EvenementService();
        ParticipantService service = new ParticipantService();



 //       service_ev.insertEvenement(eve1);
   //     service_ev.insertEvenement(eve2);
//
     //   service.insertParticipant(parti1);
       // service.insertParticipant(parti2);
       // service.insertParticipant(parti3);

          Evenement eve1 = service_ev.get(1);
 //         Participant parti1 = service.get(1);
   //       Participant parti2 = service.get(2);
     //     Participant parti3 = service.get(3);

//        List<Participant> participants =  eve1.getParticipants();
        //       System.out.println("/////////////////////////////////////////////////////////////////////////");

//        for (int i = 0; i < participants.size(); i++)
        //       {
        //          Participant participant = participants.get(i);
        //          System.out.println(participant);
        //      }

        eve1.addParticipant(parti1);
        eve1.addParticipant(parti2);
        eve1.addParticipant(parti3);

       service_ev.updateEvenement(eve1);

//        List<Participant> liste = service_ev.getParticipants(eve1);
//        System.out.println("/////////////////////////////////////////////////////////////////////////");
//        for (int i = 0; i < liste.size(); i++)
//        {
//            Participant participant = liste.get(i);
//            System.out.println(participant.toString());
//        }









    }


}
