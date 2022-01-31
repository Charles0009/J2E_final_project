package tsi.ensg.jee.servingwebcontent;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tsi.ensg.jee.hibernate.colloque.metier.Evenement;
import tsi.ensg.jee.hibernate.colloque.services.EvenementService;

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
        int id  = evenement.getId();
        String full = evenement.toString();
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(id);
        System.out.println(full);

        EvenementService service = new EvenementService();
        service.insertEvenement(evenement);



        return"redirect:/eventAdded";
    }

    @GetMapping("/eventAdded")
    public String eventAdded(@RequestParam(name="name", required=false, defaultValue="Charles1") String name, Model model) {
        model.addAttribute("name", name);
        return "eventAdded";
    }


    //  @GetMapping("/addParticipant")
    // public String greeting3(@RequestParam(name="name", required=false, defaultValue="Charles") String name, Model model) {
    //    model.addAttribute("name", name);
    //   return "addParticipant";
    //}




//    @GetMapping("/addParticipant")
//    public String addParticipant(Model model) {
//        model.addAttribute("participant", new Participant());
//        //récupération avec Hibernate
//        model.addAttribute("events", EvenementService.findAll());
//        return "addParticipant";
//    }

//    @GetMapping("/greeting")
//    public String greeting2(@RequestParam(name="name2", required=false, defaultValue="Charles") String name, Model model) {
//        model.addAttribute("name2", name);
//        return "greeting2";
//    }

}
