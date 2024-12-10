package repositories;

import entities.Event;
import entities.Participant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventRepository {
    private static List<Event> events = new ArrayList<>();

    public Event addEvent(Event event) {
        events.add(event);
        return event;
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    public Optional<Event> findEventByName(String name) {
        return events.stream()
                .filter(event -> event.getNameEvent().equalsIgnoreCase(name))
                .findFirst();
    }

    public void updateEvent(Event event, String newName, String newDate, String newLocation) {
        event.setNameEvent(newName);
        event.setDateEvent(newDate);
        event.setEventLocation(newLocation);
    }
}

