import repositories.EventRepository;
import repositories.ParticipantRepository;
import Services.EventService;
import Services.ParticipantService;
import Views.MainView;


public class Main {
    public static void main(String[] args) {
        EventRepository eventRepository = new EventRepository();
        ParticipantRepository participantRepository = new ParticipantRepository();
        EventService eventService = new EventService(eventRepository, participantRepository);
        ParticipantService participantService = new ParticipantService(participantRepository, eventRepository);
        MainView mainView = new MainView(eventService, participantService);
        mainView.utama();
    }
}
