package tsi.ensg.jee.servingwebcontent;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tsi.ensg.jee.hibernate.colloque.metier.Evenement;
import tsi.ensg.jee.hibernate.colloque.metier.Participant;
import tsi.ensg.jee.hibernate.colloque.services.EvenementService;
import tsi.ensg.jee.hibernate.colloque.services.ParticipantService;

import java.util.List;

@Controller
public class GreetingController {

      @GetMapping("/greeting")
     public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    // @GetMapping("/addEvent")
    //  public String greeting2(@RequestParam(name="name", required=false, defaultValue="Charles") String name, Model model) {
    //    model.addAttribute("name", name);
    //     return "addEvent";
    //}


    @GetMapping("/addEvent")
    public String addEvent() {
        return "addEvent";
    }

    @PostMapping("/addEvenement")
    public String addEvenement(@Validated Evenement evenement, BindingResult result, Model model) {
        EvenementService service = new EvenementService();
        service.insertEvenement(evenement);
        return"redirect:/ManageEvenements";
    }

    @GetMapping("/eventAdded")
    public String eventAdded(@RequestParam(name="name", required=false, defaultValue="Charles1") String name, Model model) {
        model.addAttribute("name", name);
        return "eventAdded";
    }

    @GetMapping("/addParticipant/{id}")
    public String addParticipant(@PathVariable int id) {
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(id);
        return "addParticipant";
    }

//    @GetMapping("/Participant/Add/{id}")
//    public String ParticipantAdding(@PathVariable int id){
//        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////");
//        System.out.println(id);
//        return "redirect:/addParticipant.html";
//    }

    @PostMapping("/Participant/Add/{id}")
    public String ParticipantAdding(@Validated Participant p,@PathVariable int id, BindingResult result, Model model) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println(id);

        ParticipantService service = new ParticipantService();


        //String list_of_inputs = participant.toString();
        //int num_pers,String nom,String prenom,String email, String date_naiss, String organisation, String observations
        Participant new_part = new Participant(p.getNum_pers(),p.getNom(),p.getPrenom(),p.getEmail(),p.getDate_naiss(),p.getOrganisation(),p.getObservations());
        //System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        //System.out.println(list_of_inputs);

       //ParticipantService service_parti = new ParticipantService();
        //service.insertParticipant(new_part);

        EvenementService service_ev = new EvenementService();
        Evenement eve1 = service_ev.get(id);
        eve1.addParticipant(new_part);

        service_ev.insertEvenement(eve1);


        String ids=String.valueOf(id);
        return"redirect:/ManageParticipants/"+ids;
    }

    @GetMapping("/ManageParticipants/{id}")
    public String getParticipant(@PathVariable int id,Model model) {
        ParticipantService service = new ParticipantService();
        EvenementService service_ev = new EvenementService();
        Evenement eve1 = service_ev.get(id);
        List<Participant> liste_participants =  eve1.getParticipants();
        model.addAttribute("participant", liste_participants);
        return "ManageParticipants";
    }

    @GetMapping("/ManageEvenements")
    public String getEvenement(Model model) {
        EvenementService service_env = new EvenementService();
        List<Evenement> liste_evenements = service_env.getAll();
       // System.out.println("/////////////////////////////////////////////////////////");
        //System.out.println(liste_evenements);
        model.addAttribute("evenement", liste_evenements);
        return "ManageEvenements";
    }

    @PostMapping("delete/Event/{id}")
    public String deleteEvent(@PathVariable int id){
        System.out.println(id);
        //evenementService.delete(id);
        return "redirect:/ManageEvenements";
    }

    @GetMapping("voir/Participant/{id}")
    public String participant(@PathVariable int id) {
        System.out.println(id);
        EvenementService service = new EvenementService();
        Evenement evenement = service.get(id);
        System.out.println(evenement);
        return "redirect:/ManageParticipants/{id}";
    }

}
