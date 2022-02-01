package tsi.ensg.jee.servingwebcontent;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
//        System.out.println("/////////////////////////////////////////////////////////");
//        System.out.println(liste_evenements);
        model.addAttribute("evenement", liste_evenements);
        return "ManageEvenements";
    }

    @GetMapping("/editParticipant")
    public String editParticipant(@RequestParam(name="id_parti", required = true, defaultValue = "1") int id, Model model) {
        ParticipantService service_edit = new ParticipantService();
        Participant participant = service_edit.get(id);
        model.addAttribute("participant", participant);
        return "editParticipant";
    }

    @PostMapping("/participantEdit")
    public String participantEdit(@Validated Participant participant, BindingResult result, Model model) {
        ParticipantService service_parti = new ParticipantService();
        service_parti.insertParticipant(participant);
        return"redirect:/ManageParticipants";
    }

    @GetMapping("/editEvenement")
    public String editEvenement(@RequestParam(name="id_ev", required = true, defaultValue = "1") int id, Model model) {
        EvenementService service_ev_edit = new EvenementService();
        Evenement evenement = service_ev_edit.get(id);
        model.addAttribute("evenement", evenement);
        return "editEvenement";
    }

    @PostMapping("/evenementEdit")
    public String participantEdit(@Validated Evenement evenement, BindingResult result, Model model) {
        EvenementService service_ev = new EvenementService();
        service_ev.insertEvenement(evenement);
        return"redirect:/ManageEvenements";
    }

    @GetMapping("/deleteParticipant")
    public String deleteParticipant(@RequestParam(name="id_parti", required = true, defaultValue = "1") int id, Model model) {
        ParticipantService service_delete_parti = new ParticipantService();
        service_delete_parti.deleteParticipant(id);
        return "redirect:/ManageParticipants";
    }

    @GetMapping("/deleteEvenement")
    public String deleteEvenement_for_update(@RequestParam(name="id_ev", required = true, defaultValue = "1") int id, Model model) {
        EvenementService service_ev_delete = new EvenementService();
        service_ev_delete.deleteEvenement(id);
        return "redirect:/editEvenement";
    }

    
}
