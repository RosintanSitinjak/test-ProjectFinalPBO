package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Event {
    private String nameEvent;
    private String dateEvent;
    private String eventLocation;
    private List<Participant> pesertaList;

    public Event(String nameEvent, String dateEvent, String eventLocation) {
        this.nameEvent = nameEvent;
        this.dateEvent = dateEvent;
        this.eventLocation = eventLocation;
        this.pesertaList = new ArrayList<>();
    }

    // Getters and Setters
    public String getNameEvent() { return nameEvent; }
    public void setNameEvent(String nameEvent) { this.nameEvent = nameEvent; }
    public String getDateEvent() { return dateEvent; }
    public void setDateEvent(String dateEvent) { this.dateEvent = dateEvent; }
    public String getEventLocation() { return eventLocation; }
    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }

    public void tambahPeserta(Participant peserta) {
        pesertaList.add(peserta);
    }

    public void hapusPeserta(Participant peserta) {
        pesertaList.remove(peserta);
    }

    public List<Participant> getPesertaList() {
        return pesertaList;
    }
}

