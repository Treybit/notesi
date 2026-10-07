package de.notesi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotizenController {

    @GetMapping("/notizen/neu")
    public String neueNotiz(){
        return "notizenneu";
    }
}
