package entities;

public class Participant {
    private String nama;
    private String nim;
    private entities.Event event;

    public Participant(String nama, String nim, entities.Event event) {
        this.nama = nama;
        this.nim = nim;
        this.event = event;
    }

    // Getters and Setters
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    public entities.Event getEvent() { return event; }
    public void setEvent(entities.Event event) { this.event = event; }
}

