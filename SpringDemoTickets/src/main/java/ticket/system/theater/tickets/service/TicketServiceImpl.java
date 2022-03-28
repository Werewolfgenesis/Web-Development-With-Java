package ticket.system.theater.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ticket.system.theater.tickets.model.Event;
import ticket.system.theater.tickets.model.Ticket;
import ticket.system.theater.tickets.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private List<Ticket> tickets;

    public TicketServiceImpl(){
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
        throw new IllegalArgumentException("No object with such id found!");
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

    @Override
    public List<Ticket> findAllTicketsByUser(User id) {
        List<Ticket> result = new ArrayList<>();

        for (Ticket t:
             this.tickets) {
            if (t.getUser().equals(id)){
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public List<Ticket> findAllTicketByEvent(Event event) {
        return this.tickets.stream().filter(t -> t.getEvent().equals(event))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> findAllEventsBetweenDates(LocalDate from, LocalDate to) {
        List<Event> events = new ArrayList<>();

        for (Ticket t:
             this.tickets) {
            if (t.getEvent().getDate().isAfter(ChronoLocalDateTime.from(from)) &&
            t.getEvent().getDate().isBefore(ChronoLocalDateTime.from(to))){
                events.add(t.getEvent());
            }
        }
        return events;
    }
}
