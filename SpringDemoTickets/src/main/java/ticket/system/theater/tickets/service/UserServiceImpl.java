package ticket.system.theater.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ticket.system.theater.tickets.model.Event;
import ticket.system.theater.tickets.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private List<User> users;

    public UserServiceImpl(){
        this.users = new ArrayList<>();
    }

    @Override
    public void createUser(User u) {
        this.users.add(u);
    }

    @Override
    public void deleteUser(Long id) {

        this.users.removeIf(t -> t.getId().equals(id));
    }

    @Override
    public User findById(Long id) {
        for (User e:
             this.users) {
            if (e.getId().equals(id)){
                return e;
            }
        }
        throw new IllegalArgumentException("No object with such id!");
    }

    @Override
    public void updateUserInformation(User user) {
        for (User e:
             this.users) {
            if (e.getId().equals(user.getId())){
                e = user;
                return;
            }
        }
    }

    @Override
    public List<Event> getAllVisitedEvent() {
        List<Event> result = new ArrayList<>();
        for (User e:
                this.users) {

        }
        return result;
    }

    @Override
    public List<Event> getAllVisitedEventsInPastMonth() {
        List<Event> eventsVisited = getAllVisitedEvent();
        for (Event e:
             eventsVisited) {
            if (e.getDate().isAfter(LocalDateTime.now().minusDays(30))){
                eventsVisited.add(e);
            }
        }
        return eventsVisited;
    }
}
