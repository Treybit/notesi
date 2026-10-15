package de.notesi.web;

import de.notesi.domain.Notiz;
import de.notesi.service.NotizRepo;
import de.notesi.service.NotizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static de.notesi.web.NotizForm.convertToNotizForm;

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
        System.out.println(notizService.alleNotizen().get(0).getDatum());
        model.addAttribute("dringendeNotizen", notizService.notizenSortiertNachDringlichkeit());
        model.addAttribute("kommendeNotizen", notizService.notizenNachZeit());
        model.addAttribute("vergangeneNotizen", notizService.vergangeneNotizenNachZeit());

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

    //Vorhandene Notiz aufrufen
    @GetMapping("/notiz/{id}")
    public String getNotiz(@PathVariable UUID id, Model model) {
        Optional<Notiz> notiz = notizService.findeNotizMitId(id);

        //Sollte eine UUID nicht gefunden werden, dann kommt man auf eine Fehlerseite
        if(notiz.isEmpty()){
            return "notiznichtvorhanden";
        }

        model.addAttribute("notiz", notiz.get());
        return "notiz";
    }

    //Vorhandene Notiz löschen
    @GetMapping("/notiz/loeschen/{id}")
    public String loescheNotiz(@PathVariable UUID id, Model model) {
        Optional<Notiz> notiz = notizService.findeNotizMitId(id);

        //Sollte eine UUID nicht gefunden werden, dann kommt man auf eine Fehlerseite
        if(notiz.isEmpty()){
            return "notiznichtvorhanden";
        }

        model.addAttribute("notiz", notiz.get());
        return "notizloeschen";
    }

    @PostMapping("/notiz/loeschen/{id}")
    public String loescheNotiz(@PathVariable UUID id) {

        notizService.loescheNotizNachId(id);

        return "redirect:/";
    }

    //Vorhandene Notiz bearbeiten
    @GetMapping("/notiz/bearbeiten/{id}")
    public String bearbeiteNotiz(@PathVariable UUID id, Model model){

        //Suche erstmal die Notiz, die bearbeitet werden soll
        Optional<Notiz> optnotiz = notizService.findeNotizMitId(id);
        if(optnotiz.isEmpty()){
            return "notiznichtvorhanden";
        }
        Notiz notiz = optnotiz.get();

        NotizForm notizForm = convertToNotizForm(notiz);

        model.addAttribute("notizForm", notizForm);
        //Datum wird nicht übernommen in das Formular!

        System.out.println(notizForm.getDatum());

        return "notizbearbeiten";
    }

    @PostMapping("/notiz/bearbeiten/{id}")
    public String bearbeiteNotiz(@PathVariable UUID id, NotizForm notizForm){

        UUID tmpId = id;

        notizService.loescheNotizNachId(id);
        Notiz notiz = notizForm.convertToNotiz();
        notiz.setId(id);
        notizService.erstelleNotiz(notiz);

        return "redirect:/";
    }
}
