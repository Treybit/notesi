package de.notesi.service;

import de.notesi.domain.Notiz;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotizRepo {

    // Alle Notizen abrufen
    List<Notiz> alleNotizen();

    // Eine neue Notiz speichern
    void speichereNotiz(Notiz notiz);

    // Eine Notiz anhand ihrer ID finden
    Optional<Notiz> findeNotizMitId(UUID id);

    // Eine bestehende Notiz bearbeiten
    void bearbeiteNotiz(Notiz notiz);

    // Eine Notiz anhand ihrer ID löschen
    void loescheNotizNachId(UUID id);

}
