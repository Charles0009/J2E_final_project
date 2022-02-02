package tsi.ensg.jee.hibernate.colloque;

import tsi.ensg.jee.hibernate.colloque.metier.Participant;
import tsi.ensg.jee.hibernate.colloque.services.EvenementService;
import tsi.ensg.jee.hibernate.colloque.metier.Evenement;
import tsi.ensg.jee.hibernate.colloque.services.ParticipantService;

import java.util.List;

public class Application {

    public static void main(String[] args) {


  //      Evenement eve1 = new Evenement(9, "even12", "theme1", "2022-01-30", 15, 10, "descri1", "orga1","type1");
   //     Evenement eve2 = new Evenement(3, "even2", "theme2", "2022-01-29", 16, 11, "descri2", "orga2","type2");
    //    Evenement eve3 = new Evenement(4, "even2", "theme2", "2022-01-29", 16, 11, "descri2", "orga2","type2");
     //   Evenement eve4 = new Evenement(5, "even2", "theme2", "2022-01-29", 16, 11, "descri2", "orga2","type2");
        Evenement eve5 = new Evenement(6, "even2", "theme2", "2022-01-29", 16, 11, "descri2", "orga2","type2");





        EvenementService service_ev = new EvenementService();
        eve5.setId(2);


 //       service_ev.insertEvenement(eve1);
   //     service_ev.insertEvenement(eve2);
     //   service_ev.insertEvenement(eve3);
       // service_ev.insertEvenement(eve4);

        service_ev.insertEvenement(eve5);



       // eve5.setId(4);
        // eve5.setId(3);


       // Participant parti1 = new Participant(4,"Bob4", "Bobby", "bob@bob.fr", "1999-02-07", "Org1", "pas dobs");
        //Participant parti2 = new Participant(2,"Bob2", "Bobby2", "bob2@bob.fr", "1999-02-08", "Org2", "pas dobs2");
        //Participant parti3 = new Participant(3,"Bob3", "Bobby3", "bob3@bob.fr", "1999-02-09", "Org3", "pas dobs3");

    //    ParticipantService service = new ParticipantService();

     //   Evenement eve1 = service_ev.get(1);
        //         Participant parti1 = service.get(1);
        //       Participant parti2 = service.get(2);
        //     Participant parti3 = service.get(3);




        //eve1.addParticipant(parti1);
        //eve1.addParticipant(parti2);

        //eve2.addParticipant(parti3);



        //EvenementService insert_test = new EvenementService();
        //insert_test.insertEvenement(eve1);
        //insert_test.insertEvenement(eve2);

    }


}
