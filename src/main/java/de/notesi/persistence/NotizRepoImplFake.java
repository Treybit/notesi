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
        return List.of();
    }

    @Override
    public void speichereNotiz(Notiz notiz) {

    }

    @Override
    public Optional<Notiz> findeNotizNachId(UUID id) {
        return Optional.empty();
    }

    @Override
    public void bearbeiteNotiz(Notiz notiz) {

    }

    @Override
    public void loescheNotizNachId(UUID id) {

    }
}
