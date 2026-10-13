package de.notesi.web;

import de.notesi.service.NotizRepo;
import de.notesi.service.NotizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@Controller
public class NotizController {

    private final NotizService notizService;

    public NotizController(NotizService notizService) {
        this.notizService = notizService;
    }

    //Startseite
    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("alleNotizen", notizService.alleNotizen());

        return "index";
    }

    //Neue Notizen erstellen
    @GetMapping("/notiz/neu")
    public String neueNotiz(Model model) {
        model.addAttribute("notizForm", new NotizForm());

        return "notizneu";
    }

    @PostMapping("/notiz/neu")
    public String neueNotiz(Model model, NotizForm notizForm) {

        notizService.erstelleNotiz(notizForm.convertToNotiz());

        return "redirect:/";
    }
}
