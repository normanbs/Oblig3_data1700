package org.example.oblig3_data1700v6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerKunde {

    @Autowired
    TicketRepo ticketRepository;
    @PostMapping ("/lagreTicket")
    public void addTicket(@RequestBody Ticket ticket) {
        ticketRepository.lagreTicket(ticket);
    }

    @GetMapping("/hentTicket")
    public List<Ticket> getAllTickets() {
        return ticketRepository.hentTicket();
    }

    @DeleteMapping("/deleteAll")
    public void deleteAlle() {
        System.out.println("Slettet alle");
        ticketRepository.deleteAll();
    }

    @DeleteMapping("/deleteEntry")
    public void deleteTicket(@RequestBody int id) {
        ticketRepository.deleteTicket(id);
        System.out.println("Slettet entry: " + id);
    }
}
