package de.notesi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@Controller
public class NotizController {

    //Startseite
    @GetMapping("/")
    public String index(Model model) {

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

        return "redirect:/";
    }
}
