package ticket.system.theater.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ticket.system.theater.tickets.model.Event;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private List<Event> events;

    public EventServiceImpl(){
        this.events = new ArrayList<>();
    }

    @Override
    public void createEvent(Event u) {
        this.events.add(u);
    }

    @Override
    public void removeEvent(Long id) {
        this.events.removeIf(e -> e.getEventId().equals(id));
    }

    @Override
    public Event findById(Long id) {
        for (Event e:
             this.events) {
            if (e.getEventId().equals(id)){
                return e;
            }
        }
        throw new IllegalArgumentException("No event with such id!");
    }

    @Override
    public void updateEvent(Event event) {
        for (Event e:
             this.events) {
            if (e.getEventId().equals(event.getEventId())){
                e = event;
                return;
            }
        }
    }
}
