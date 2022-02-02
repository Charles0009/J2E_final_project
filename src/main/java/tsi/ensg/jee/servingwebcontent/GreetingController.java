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
        return"redirect:/eventAdded";
    }

    @GetMapping("/eventAdded")
    public String eventAdded(@RequestParam(name="name", required=false, defaultValue="Charles1") String name, Model model) {
        model.addAttribute("name", name);
        return "eventAdded";
    }

    @GetMapping("/addParticipant")
    public String addParticipant() {
        return "addParticipant";
    }

    @PostMapping("/ParticipantAdding")
    public String ParticipantAdding(@Validated Participant participant, BindingResult result, Model model) {
          String list_of_inputs = participant.toString();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(list_of_inputs);

        ParticipantService service_parti = new ParticipantService();
        service_parti.insertParticipant(participant);
        return"redirect:/eventAdded";
    }

    @GetMapping("/ManageParticipants")
    public String getParticipant(Model model) {
        ParticipantService service = new ParticipantService();
        List<Participant> liste_participants = service.getAll();
        model.addAttribute("participant", liste_participants);
        return "ManageParticipants";
    }

    @GetMapping("/ManageEvenements")
    public String getEvenement(Model model) {
        EvenementService service_env = new EvenementService();
        List<Evenement> liste_evenements = service_env.getAll();
        System.out.println("/////////////////////////////////////////////////////////");
        System.out.println(liste_evenements);
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
        //evenementService.delete(id);
        return "redirect:/ManageParticipants";
    }



}
