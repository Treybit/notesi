package de.notesi.service;

import de.notesi.domain.Notiz;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<Notiz> findeNotizNachId(UUID id) {

        return notizRepo.findeNotizNachId(id);
    }

    // Eine bestehende Notiz bearbeiten
    public void bearbeiteNotiz(Notiz notiz) {
        notizRepo.bearbeiteNotiz(notiz);
    }

    // Eine Notiz löschen
    public void loescheNotizNachId(UUID id) {
        notizRepo.loescheNotizNachId(id);
    }
}
