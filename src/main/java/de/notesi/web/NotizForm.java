package de.notesi.web;

import de.notesi.domain.Dringlichkeit;
import de.notesi.domain.Notiz;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class NotizForm {

    private String titel;

    private String beschreibung;

    private String url;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate datum;

    private LocalTime uhrzeit;

    private Dringlichkeit dringlichkeit;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(LocalTime uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public Dringlichkeit getDringlichkeit() {
        return dringlichkeit;
    }

    public void setDringlichkeit(Dringlichkeit dringlichkeit) {
        this.dringlichkeit = dringlichkeit;
    }

    //Gehört diese Methode hier rein?????
    //NotizForm zu Notiz
    public Notiz convertToNotiz() {
        //URL ist einfach leer, datum ist NULL und uhrzeit ist NULL
        //Dieses SOUT muss noch weg!!!
        System.out.println(url + datum + uhrzeit);
        Notiz notiz = new Notiz(titel, beschreibung, url, datum, uhrzeit, dringlichkeit);
        return notiz;
    }

    //Notiz zu NotizForm
    static public NotizForm convertToNotizForm(Notiz notiz){

        NotizForm notizForm = new NotizForm();

        notizForm.titel = notiz.getTitel();
        notizForm.beschreibung = notiz.getBeschreibung();
        notizForm.url = notiz.getUrl();
        notizForm.datum = notiz.getDatum();
        notizForm.uhrzeit = notiz.getUhrzeit();
        notizForm.dringlichkeit = notiz.getDringlichkeit();

        return notizForm;
    }
}
