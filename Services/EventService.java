package Services;


import entities.Event;
import entities.Participant;
import repositories.EventRepository;
import repositories.ParticipantRepository;
import java.util.List;
import java.util.Optional;

public class EventService {
    private EventRepository eventRepository;
    private ParticipantRepository participantRepository;

    public EventService(EventRepository eventRepository, ParticipantRepository participantRepository) {
        this.eventRepository = eventRepository;
        this.participantRepository = participantRepository;
    }

    public Event tambahEvent(String nameEvent, String dateEvent, String eventLocation) {
        Event event = new Event(nameEvent, dateEvent, eventLocation);
        return eventRepository.addEvent(event);
    }

    public void hapusEvent(Event event) {
        eventRepository.removeEvent(event);
    }

    public void editEvent(Event event, String newName, String newDate, String newLocation) {
        eventRepository.updateEvent(event, newName, newDate, newLocation);
    }

    public List<Event> lihatSemuaEvent() {
        return eventRepository.getAllEvents();
    }

    public Optional<Event> cariEventBerdasarkanNama(String nama) {
        return eventRepository.findEventByName(nama);
    }

    public List<Participant> lihatPesertaEvent(Event event) {
        return participantRepository.getPesertaByEvent(event);
    }

}

