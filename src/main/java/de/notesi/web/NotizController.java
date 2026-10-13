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

    List list = new LinkedList();


    @GetMapping("/notiz/neu")
    public String neueNotiz(Model model) {
        model.addAttribute("notizForm", new NotizForm());

        for(int i = 0; i<list.size(); i++){
            System.out.println(i + ": " + list.get(i));
        }
        return "notizneu";
    }

    @PostMapping("/notiz/neu")
    @ResponseBody
    public String neueNotiz(Model model, NotizForm notizForm) {

        System.out.println(notizForm.getTitel());
        System.out.println(notizForm.getBeschreibung());
        System.out.println(notizForm.getUrl());
        System.out.println(notizForm.getDatum());
        System.out.println(notizForm.getUhrzeit());
        System.out.println(notizForm.getDringlichkeit());

        list.add(notizForm);
        return "Erfolgreich";
    }
}
