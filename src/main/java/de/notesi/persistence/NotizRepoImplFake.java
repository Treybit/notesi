package de.notesi.persistence;

import de.notesi.domain.Dringlichkeit;
import de.notesi.domain.Notiz;
import de.notesi.service.NotizRepo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Repository
public class NotizRepoImplFake implements NotizRepo {

    private final Map<UUID, Notiz> notizenMap = new HashMap<>();

    @Override
    public List<Notiz> alleNotizen() {

        ArrayList<Notiz> alleNotizen = new ArrayList<>(notizenMap.values());
        return alleNotizen;
    }

    @Override
    public void speichereNotiz(Notiz notiz) {
        notizenMap.put(notiz.getId(), notiz);
    }

    @Override
    public Optional<Notiz> findeNotizMitId(UUID id) {
        //Falls Notiz nicht gefunden wird, wird NULL zurückgegeben (Optional.ofNullable)
        return Optional.ofNullable(notizenMap.get(id));
    }

    @Override
    public void bearbeiteNotiz(Notiz notiz) {

        //Fehlt noch
        throw new UnsupportedOperationException(
                "Die Funktion 'bearbeiteNotiz' ist noch nicht implementiert."
        );

    }

    @Override
    public void loescheNotizNachId(UUID id) {
        notizenMap.remove(id);
    }


    //Testdaten im Konstruktor
    public NotizRepoImplFake() {

        Notiz notiz1 = new Notiz(
                "Einkaufsliste",
                "Milch, Brot, Eier und Käse kaufen.",
                "https://example.com/einkauf",
                LocalDate.of(2026, 10, 14),
                LocalTime.of(10, 0),
                Dringlichkeit.NORMAL
        );

        Notiz notiz2 = new Notiz(
                "Projekt abgeben",
                "Die Dokumentation fertigstellen und das Projekt einreichen.",
                "https://example.com/projekt",
                LocalDate.of(2026, 10, 15),
                LocalTime.of(14, 30),
                Dringlichkeit.DRINGEND
        );

        Notiz notiz3 = new Notiz(
                "Geburtstagsgeschenk",
                "Ein Geschenk für einen guten Freund besorgen.",
                "https://example.com/geschenk",
                LocalDate.of(2026, 10, 20),
                LocalTime.of(16, 0),
                Dringlichkeit.HOCH
        );

        Notiz notiz4 = new Notiz(
                "Buch lesen",
                "Das neue Buch weiterlesen und Kapitel 5 beenden.",
                "https://example.com/buch",
                LocalDate.of(2026, 10, 25),
                LocalTime.of(20, 0),
                Dringlichkeit.NIEDRIG
        );

        Notiz notiz5 = new Notiz(
                "Arzttermin vereinbaren",
                "Wegen eines Kontrolltermins in der Praxis anrufen.",
                "",
                LocalDate.of(2026, 10, 16),
                LocalTime.of(9, 0),
                Dringlichkeit.HOCH
        );

        speichereNotiz(notiz1);
        speichereNotiz(notiz2);
        speichereNotiz(notiz3);
        speichereNotiz(notiz4);
        speichereNotiz(notiz5);
    }

}
