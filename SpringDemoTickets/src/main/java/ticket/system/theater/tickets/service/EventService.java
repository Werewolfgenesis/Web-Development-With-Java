package ticket.system.theater.tickets.service;

import org.springframework.stereotype.Repository;
import ticket.system.theater.tickets.model.Event;

public interface EventService {
    void createEvent(Event u);

    void removeEvent(Long id);

    Event findById(Long id);

    void updateEvent(Event event);
}
