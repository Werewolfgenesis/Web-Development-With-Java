package ticket.system.theater.tickets.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import ticket.system.theater.tickets.model.Event;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepoImpl implements EventRepository{

    @Autowired
    private List<Event> eventsList;

//    public EventRepoImpl(){
//        this.eventsList = new ArrayList<>();
//    }
    @Override
    public void createEvent(Event event) {
        this.eventsList.add(event);
    }

    @Override
    public void removeEvent(Long id) {
        this.eventsList.removeIf(e -> e.getEventId().equals(id));
    }

    @Override
    public Event findById(Long id) {
        for (Event e:
                this.eventsList) {
            if (e.getEventId().equals(id)){
                return e;
            }
        }
        return null;
    }

    @Override
    public void updateEvent(Event event) {

        for (Event e:
             this.eventsList) {
            if (e.getEventId().equals(event.getEventId())){
                e.setDate(event.getDate());
                e.setDescription(event.getDescription());
                e.setName(event.getName());
                return;
            }
        }
    }

    @Override
    public String toString() {
        String result = new String();

        for (Event e:
             this.eventsList) {
            result = result  + e.toString() + "\n";
        }

        return result;
    }
}
