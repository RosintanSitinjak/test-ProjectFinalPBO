package Views;

import entities.Event;
import entities.Participant;
import Services.EventService;
import Services.ParticipantService;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainView {
    private Scanner scanner;
    private EventService eventService;
    private ParticipantService participantService;

    public MainView(EventService eventService, ParticipantService participantService) {
        this.scanner = new Scanner(System.in);
        this.eventService = eventService;
        this.participantService = participantService;
    }

    public void utama() {
        while (true) {
            pilihanMenu();
            System.out.print("Masukkan pilihan Anda ): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    tambahEvent();
                    break;
                case 2:
                    lihatSemuaEvent();
                    break;
                case 3:
                    editEvent();
                    break;
                case 4:
                    hapusEvent();
                    break;
                case 5:
                    tambahPeserta();
                    break;
                case 6:
                    lihatPesertaEvent();
                    break;
                case 7:
                    lihatTotalPeserta();
                    break;
                case 8:
                    lihatDetailPeserta();
                    break;
                case 9:
                    hapusPeserta();
                    break;
                case 10:
                    System.out.println("Keluar...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void pilihanMenu() {
        System.out.println("====== Sistem Manajemen Event ======");
        System.out.println("1. Tambah Event");
        System.out.println("2. Lihat Semua Event");
        System.out.println("3. Edit Event");
        System.out.println("4. Hapus Event");
        System.out.println("5. Tambah Peserta");
        System.out.println("6. Lihat Peserta Event");
        System.out.println("7. Lihat Total Peserta");
        System.out.println("8. Lihat Detail Peserta");
        System.out.println("9. Hapus Peserta");
        System.out.println("10. Keluar");
    }

    private void tambahEvent() {
        System.out.print("Masukkan nama event: ");
        String nameEvent = scanner.nextLine();
        System.out.print("Masukkan tanggal event (YYYY-MM-DD): ");
        String dateEvent = scanner.nextLine();
        System.out.print("Masukkan lokasi event: ");
        String eventLocation = scanner.nextLine();

        Event event = eventService.tambahEvent(nameEvent, dateEvent, eventLocation);
        System.out.println("Event berhasil ditambahkan: " + event.getNameEvent());
    }

    private void lihatSemuaEvent() {
        List<Event> events = eventService.lihatSemuaEvent();
        events.forEach(event -> {
            System.out.println("Nama Event: " + event.getNameEvent());
            System.out.println("Tanggal Event: " + event.getDateEvent());
            System.out.println("Lokasi Event: " + event.getEventLocation());
            System.out.println("---------------------------");
        });
    }

    private void editEvent() {
        System.out.print("Masukkan ID event yang ingin diedit: ");
        String idEvent = scanner.nextLine();
        Optional<Event> event = eventService.cariEventBerdasarkanNama(idEvent);
        if (event.isPresent()) {
            System.out.print("Masukkan nama event baru: ");
            String newNameEvent = scanner.nextLine();
            System.out.print("Masukkan tanggal event baru (YYYY-MM-DD): ");
            String newDateEvent = scanner.nextLine();
            System.out.print("Masukkan lokasi event baru: ");
            String newEventLocation = scanner.nextLine();

            eventService.editEvent(event.get(), newNameEvent, newDateEvent, newEventLocation);
            System.out.println("Event berhasil diedit: " + event.get().getNameEvent());
        } else {
            System.out.println("Event tidak ditemukan.");
        }
    }

    private void hapusEvent() {
        System.out.print("Masukkan ID event yang ingin dihapus: ");
        String idEvent = scanner.nextLine();
        Optional<Event> event = eventService.cariEventBerdasarkanNama(idEvent);
        if (event.isPresent()) {
            eventService.hapusEvent(event.get());
            System.out.println("Event berhasil dihapus: " + event.get().getNameEvent());
        } else {
            System.out.println("Event tidak ditemukan.");
        }
    }

    private void tambahPeserta() {
        System.out.print("Masukkan nama peserta: ");
        String namaPeserta = scanner.nextLine();
        System.out.print("Masukkan NIM peserta: ");
        String nimPeserta = scanner.nextLine();
        System.out.print("Masukkan ID event yang ingin diikuti: ");
        String idEvent = scanner.nextLine();

        Optional<Event> event = eventService.cariEventBerdasarkanNama(idEvent);
        if (event.isPresent()) {
            Participant peserta = participantService.tambahPeserta(namaPeserta, nimPeserta, event.get());
            System.out.println("Peserta berhasil ditambahkan: " + peserta.getNama());
        } else {
            System.out.println("Event tidak ditemukan.");
        }
    }

    private void lihatPesertaEvent() {
        System.out.print("Masukkan ID event yang ingin dilihat pesertanya: ");
        String idEvent = scanner.nextLine();
        Optional<Event> event = eventService.cariEventBerdasarkanNama(idEvent);
        if (event.isPresent()) {
            List<Participant> pesertaList = participantService.lihatPesertaEvent(event.get());
            pesertaList.forEach(peserta -> {
                System.out.println("Nama Peserta: " + peserta.getNama());
                System.out.println("NIM Peserta: " + peserta.getNim());
                System.out.println("---------------------------");
            });
        } else {
            System.out.println("Event tidak ditemukan.");
        }
    }

    private void hapusPeserta() {
        System.out.print("Masukkan ID peserta yang ingin dihapus: ");
        String idPeserta = scanner.nextLine();
        Optional<Participant> peserta = participantService.cariPesertaBerdasarkanNama(idPeserta);
        if (peserta.isPresent()) {
            participantService.hapusPeserta(peserta.get());
            System.out.println("Peserta berhasil dihapus: " + peserta.get().getNama());
        } else {
            System.out.println("Peserta tidak ditemukan.");
        }
    }

    private void lihatTotalPeserta() {
        int totalPeserta = participantService.getTotalPeserta();
        System.out.println("Total peserta di semua event: " + totalPeserta);
    }

    private void lihatDetailPeserta() {
        System.out.print("Masukkan NIM peserta: ");
        String nimPeserta = scanner.nextLine();
        Optional<Participant> peserta = participantService.getDetailPesertaByNIM(nimPeserta);
        if (peserta.isPresent()) {
            Participant detailPeserta = peserta.get();
            System.out.println("Nama Peserta: " + detailPeserta.getNama());
            System.out.println("NIM Peserta: " + detailPeserta.getNim());
            System.out.println("Event Peserta: " + detailPeserta.getEvent().getNameEvent());
        } else {
            System.out.println("Peserta dengan NIM tersebut tidak ditemukan.");
        }
    }
}
