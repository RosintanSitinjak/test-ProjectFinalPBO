package repositories;

import entities.Event;
import entities.Participant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ParticipantRepository {
    private static List<Participant> pesertaList = new ArrayList<>();

    public Participant tambahPeserta(Participant peserta) {
        pesertaList.add(peserta);
        return peserta;
    }

    public void hapusPeserta(Participant peserta) {
        pesertaList.remove(peserta);
    }

    public List<Participant> getAllPeserta() {
        return new ArrayList<>(pesertaList);
    }

    public List<Participant> getPesertaByEvent(Event event) {
        return pesertaList.stream()
                .filter(p -> p.getEvent().equals(event))
                .collect(Collectors.toList());
    }

    public Optional<Participant> findPesertaByName(String nama) {
        return pesertaList.stream()
                .filter(p -> p.getNama().equalsIgnoreCase(nama))
                .findFirst();
    }
}
