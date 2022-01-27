package tsi.ensg.jee.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Charles1") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/addEvent")
    public String greeting2(@RequestParam(name="name", required=false, defaultValue="Charles") String name, Model model) {
        model.addAttribute("name", name);
        return "addEvent";
    }

//    @GetMapping("/greeting")
//    public String greeting2(@RequestParam(name="name2", required=false, defaultValue="Charles") String name, Model model) {
//        model.addAttribute("name2", name);
//        return "greeting2";
//    }

}
