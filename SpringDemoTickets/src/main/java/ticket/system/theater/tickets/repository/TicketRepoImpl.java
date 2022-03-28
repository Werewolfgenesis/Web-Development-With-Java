package ticket.system.theater.tickets.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ticket.system.theater.tickets.model.Ticket;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class TicketRepoImpl implements TicketRepository{
    @Autowired
    List<Ticket> tickets;

    public TicketRepoImpl(){
        this.tickets = new ArrayList<>();
    }
    @Override
    public void createTicket(Ticket u) {
        this.tickets.add(u);
    }

    @Override
    public void removeTicket(Long id) {
        this.tickets.removeIf(t -> t.getTicketId().equals(id));
    }

    @Override
    public Ticket findById(Long id) {
        for (Ticket t:
             this.tickets) {
            if (t.getTicketId().equals(id)){
                return t;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void updateTicketById(Ticket ticket) {
        for (Ticket t:
                this.tickets) {
            if (t.getTicketId().equals(ticket.getTicketId())){
                t = ticket;
                return;
            }
        }
    }
}
