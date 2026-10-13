package de.notesi.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Notiz {

    private final UUID id;

    private String titel;
    private String beschreibung;
    private String url;
    private LocalDate datum;
    private LocalTime uhrzeit;
    private Dringlichkeit dringlichkeit;

    public Notiz(
            String titel,
            String beschreibung,
            String url,
            LocalDate datum,
            LocalTime uhrzeit,
            Dringlichkeit dringlichkeit
    ) {
        this.id = UUID.randomUUID();
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.url = url;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.dringlichkeit = dringlichkeit;
    }

    public UUID getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getUrl() {
        return url;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public LocalTime getUhrzeit() {
        return uhrzeit;
    }

    public Dringlichkeit getDringlichkeit() {
        return dringlichkeit;
    }
}
