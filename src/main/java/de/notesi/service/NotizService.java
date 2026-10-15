package de.notesi.service;

import de.notesi.domain.Notiz;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NotizService {

    private final NotizRepo notizRepo;

    public NotizService(NotizRepo notizRepo) {
        this.notizRepo = notizRepo;
    }

    // Alle Notizen abrufen
    public List<Notiz> alleNotizen() {
        return notizRepo.alleNotizen();
    }

    // Eine neue Notiz erstellen
    public void erstelleNotiz(Notiz notiz) {
        notizRepo.speichereNotiz(notiz);
    }

    // Eine Notiz anhand ihrer ID finden
    public Optional<Notiz> findeNotizMitId(UUID id) {

        return notizRepo.findeNotizMitId(id);
    }

    // Eine bestehende Notiz bearbeiten
    public void bearbeiteNotiz(Notiz notiz) {
        throw new UnsupportedOperationException(
                "Die Funktion 'bearbeiteNotiz' ist noch nicht implementiert."
        );
    }

    // Eine Notiz löschen
    public void loescheNotizNachId(UUID id) {
        notizRepo.loescheNotizNachId(id);
    }

    // Alle Notizen nach Dringlichkeit und Datum sortieren (Code muss überprüft werden)
    public List<Notiz> notizenSortiertNachDringlichkeit() {
        return notizRepo.alleNotizen().stream().sorted(Comparator
                // DRINGEND zuerst, NIEDRIG zuletzt
                .comparing(Notiz::getDringlichkeit, Comparator.nullsLast(Comparator.reverseOrder()))
                // Innerhalb der Dringlichkeit: frühester Termin zuerst
                .thenComparing(notiz -> {
                    if (notiz.getDatum() == null) {
                        return null;
                    }

                    LocalTime zeit = notiz.getUhrzeit() != null ? notiz.getUhrzeit() : LocalTime.MAX;

                    return LocalDateTime.of(notiz.getDatum(), zeit);
                }, Comparator.nullsLast(Comparator.naturalOrder()))).limit(5).toList();
    }

    // Alle zukünftigen Notizen nach Zeit sortieren (Code muss überprüft werden)
    public List<Notiz> notizenNachZeit() {
        LocalDateTime jetzt = LocalDateTime.now();

        return notizRepo.alleNotizen().stream()
                // Notizen ohne Datum ausschließen
                .filter(notiz -> notiz.getDatum() != null)
                // Ablaufzeit bestimmen und vergangene Termine ausschließen
                .filter(notiz -> {
                    LocalTime zeit = notiz.getUhrzeit() != null ? notiz.getUhrzeit() : LocalTime.MAX;

                    LocalDateTime termin = LocalDateTime.of(notiz.getDatum(), zeit);

                    return !termin.isBefore(jetzt);
                })
                // Nach Datum und Uhrzeit sortieren
                .sorted(Comparator.comparing(notiz -> {
                    LocalTime zeit = notiz.getUhrzeit() != null ? notiz.getUhrzeit() : LocalTime.MAX;

                    return LocalDateTime.of(notiz.getDatum(), zeit);
                })).limit(5).toList();
    }

    // Alle vergangenen Notizen nach Zeit sortieren (Code muss überprüft werden)
    public List<Notiz> vergangeneNotizenNachZeit() {
        LocalDateTime jetzt = LocalDateTime.now();

        return notizRepo.alleNotizen().stream()
                // Notizen ohne Datum ausschließen
                .filter(notiz -> notiz.getDatum() != null)
                // Ablaufzeit bestimmen und zukünftige Termine ausschließen
                .filter(notiz -> {
                    LocalTime zeit = notiz.getUhrzeit() != null ? notiz.getUhrzeit() : LocalTime.MAX;

                    LocalDateTime termin = LocalDateTime.of(notiz.getDatum(), zeit);

                    return termin.isBefore(jetzt);
                })
                // Älteste Termine zuerst
                .sorted(Comparator.comparing(notiz -> {
                    LocalTime zeit = notiz.getUhrzeit() != null ? notiz.getUhrzeit() : LocalTime.MAX;

                    return LocalDateTime.of(notiz.getDatum(), zeit);
                })).limit(5).toList();
    }
}
