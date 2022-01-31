package tsi.ensg.jee.hibernate.colloque;

import tsi.ensg.jee.hibernate.colloque.services.EvenementService;
import tsi.ensg.jee.hibernate.colloque.metier.Evenement;

public class Application {

    public static void main(String[] args) {


        Evenement eve1 = new Evenement(2, "even1", "theme1", "2022-01-30", 15, 10, "descri1", "orga1","type1");
        Evenement eve2 = new Evenement(2, "even2", "theme2", "2022-01-29", 16, 11, "descri2", "orga2","type2");

        EvenementService insert_test = new EvenementService();

        String full = eve1.toString();
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(full);

        insert_test.insertEvenement(eve1);

        //Participant parti1 = new Participant(1,"Bob", "Bobby", "bob@bob.fr", "1999-02-07", "Org1", "pas dobs");
        //Participant parti2 = new Participant(2,"Bob2", "Bobby2", "bob2@bob.fr", "1999-02-08", "Org2", "pas dobs2");
        //Participant parti3 = new Participant(3,"Bob3", "Bobby3", "bob3@bob.fr", "1999-02-09", "Org3", "pas dobs3");

        //eve1.addParticipant(parti1);
        //eve1.addParticipant(parti2);

        //eve2.addParticipant(parti3);



        //EvenementService insert_test = new EvenementService();
        //insert_test.insertEvenement(eve1);
        //insert_test.insertEvenement(eve2);

    }


}
