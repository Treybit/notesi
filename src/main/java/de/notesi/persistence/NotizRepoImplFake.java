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

        Notiz notiz6 = new Notiz(
                "Präsentation vorbereiten",
                "Die Folien für die Präsentation erstellen.",
                "https://example.com/praesentation",
                LocalDate.of(2026, 10, 13),
                LocalTime.of(12, 0),
                Dringlichkeit.DRINGEND
        );

        Notiz notiz7 = new Notiz(
                "Zimmer aufräumen",
                "Schreibtisch aufräumen und Staub wischen.",
                "",
                LocalDate.of(2026, 10, 13),
                LocalTime.of(18, 0),
                Dringlichkeit.NORMAL
        );

        Notiz notiz8 = new Notiz(
                "Steuerunterlagen sortieren",
                "Belege für die Steuererklärung zusammenstellen.",
                "https://example.com/steuer",
                LocalDate.of(2026, 10, 12),
                null,
                Dringlichkeit.HOCH
        );

        Notiz notiz9 = new Notiz(
                "Neue Musik entdecken",
                "Neue Alben und Künstler suchen.",
                null,
                null,
                null,
                Dringlichkeit.NIEDRIG
        );

        Notiz notiz10 = new Notiz(
                "Bewerbung abschicken",
                "Die Bewerbung noch einmal prüfen und versenden.",
                "https://example.com/bewerbung",
                LocalDate.of(2026, 10, 14),
                null,
                Dringlichkeit.DRINGEND
        );

        Notiz notiz11 = new Notiz(
                "Freunde kontaktieren",
                "Mal wieder bei alten Freunden melden.",
                null,
                LocalDate.of(2026, 10, 18),
                LocalTime.of(17, 30),
                Dringlichkeit.NORMAL
        );

        Notiz notiz12 = new Notiz(
                "Fahrrad reparieren",
                "Die Bremsen kontrollieren und den Reifen aufpumpen.",
                "",
                LocalDate.of(2026, 10, 10),
                LocalTime.of(10, 0),
                Dringlichkeit.HOCH
        );

        Notiz notiz13 = new Notiz(
                "Ideen für Urlaub sammeln",
                "Mögliche Reiseziele und Unterkünfte recherchieren.",
                "https://example.com/urlaub",
                null,
                null,
                Dringlichkeit.NORMAL
        );

        Notiz notiz14 = new Notiz(
                "Paket abholen",
                "Das Paket bei der Post abholen.",
                null,
                LocalDate.of(2026, 10, 13),
                LocalTime.of(9, 0),
                Dringlichkeit.DRINGEND
        );

        Notiz notiz15 = new Notiz(
                "Alte Dateien löschen",
                "Unnötige Dateien auf dem Computer entfernen.",
                "",
                LocalDate.of(2026, 10, 22),
                null,
                Dringlichkeit.NIEDRIG
        );

        Notiz notiz16 = new Notiz(
                "Rechnung bezahlen",
                "Die offene Stromrechnung überweisen.",
                "https://example.com/rechnung",
                LocalDate.of(2026, 10, 5),
                LocalTime.of(11, 0),
                Dringlichkeit.DRINGEND
        );

        Notiz notiz17 = new Notiz(
                "Bücher zurückgeben",
                "Die ausgeliehenen Bücher in der Bibliothek abgeben.",
                null,
                LocalDate.of(2026, 10, 8),
                LocalTime.of(16, 30),
                Dringlichkeit.NORMAL
        );

        Notiz notiz18 = new Notiz(
                "Werkstatttermin",
                "Das Auto zur Inspektion bringen.",
                "",
                LocalDate.of(2026, 10, 11),
                null,
                Dringlichkeit.HOCH
        );

        Notiz notiz19 = new Notiz(
                "Online-Bestellung prüfen",
                "Kontrollieren, ob die Bestellung angekommen ist.",
                "https://example.com/bestellung",
                LocalDate.of(2026, 10, 12),
                LocalTime.of(9, 15),
                Dringlichkeit.NIEDRIG
        );

        Notiz notiz20 = new Notiz(
                "Teammeeting vorbereiten",
                "Die Tagesordnung für das Teammeeting zusammenstellen.",
                null,
                LocalDate.of(2026, 10, 13),
                LocalTime.of(8, 0),
                Dringlichkeit.DRINGEND
        );

        speichereNotiz(notiz1);
        speichereNotiz(notiz2);
        speichereNotiz(notiz3);
        speichereNotiz(notiz4);
        speichereNotiz(notiz5);
        speichereNotiz(notiz6);
        speichereNotiz(notiz7);
        speichereNotiz(notiz8);
        speichereNotiz(notiz9);
        speichereNotiz(notiz10);
        speichereNotiz(notiz11);
        speichereNotiz(notiz12);
        speichereNotiz(notiz13);
        speichereNotiz(notiz14);
        speichereNotiz(notiz15);
        speichereNotiz(notiz16);
        speichereNotiz(notiz17);
        speichereNotiz(notiz18);
        speichereNotiz(notiz19);
        speichereNotiz(notiz20);
    }
}
