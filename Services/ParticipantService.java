package Services;

import entities.Event;
import entities.Participant;
import repositories.EventRepository;
import repositories.ParticipantRepository;
import java.util.List;
import java.util.Optional;

public class ParticipantService {
    private ParticipantRepository participantRepository;
    private EventRepository eventRepository;

    public ParticipantService(ParticipantRepository participantRepository, EventRepository eventRepository) {
        this.participantRepository = participantRepository;
        this.eventRepository = eventRepository;
    }

    public Participant tambahPeserta(String nama, String nim, Event event) {
        Participant peserta = new Participant(nama, nim, event);
        event.tambahPeserta(peserta);
        return participantRepository.tambahPeserta(peserta);
    }

    public void hapusPeserta(Participant peserta) {
        peserta.getEvent().hapusPeserta(peserta);
        participantRepository.hapusPeserta(peserta);
    }

    public List<Participant> lihatSemuaPeserta() {
        return participantRepository.getAllPeserta();
    }

    public int lihatTotalPeserta(Event event) {
        return event.getPesertaList().size();
    }

    public Optional<Participant> cariPesertaBerdasarkanNama(String nama) {
        return participantRepository.findPesertaByName(nama);
    }
}
