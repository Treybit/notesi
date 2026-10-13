package de.notesi.persistence;

import de.notesi.domain.Notiz;
import de.notesi.service.NotizRepo;
import org.springframework.stereotype.Repository;

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
    public Optional<Notiz> findeNotizNachId(UUID id) {
        //Falls Notiz nicht gefunden wird, wird NULL zurückgegeben (Optional.ofNullable)
        return Optional.ofNullable(notizenMap.get(id));
    }

    @Override
    public void bearbeiteNotiz(Notiz notiz) {

        //Fehlt noch
        throw new UnsupportedOperationException(
                "Die Funktion 'Notiz bearbeiten' ist noch nicht implementiert."
        );

    }

    @Override
    public void loescheNotizNachId(UUID id) {
        notizenMap.remove(id);
    }
}
