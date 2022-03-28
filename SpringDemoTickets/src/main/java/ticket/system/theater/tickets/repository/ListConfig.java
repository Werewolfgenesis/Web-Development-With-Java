package ticket.system.theater.tickets.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ticket.system.theater.tickets.model.Event;
import ticket.system.theater.tickets.model.Ticket;
import ticket.system.theater.tickets.model.User;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ListConfig {

    @Bean
    public EventRepoImpl getRepoImpl(){
        return new EventRepoImpl();
    }

    @Bean
    public TicketRepoImpl getTicketImpl(){
        return new TicketRepoImpl();
    }

    @Bean
    public UserRepoImpl getUserRepo(){
        return new UserRepoImpl();
    }

    @Bean
    public List<Event> eventsList(){
        return new ArrayList<>();
    }

    @Bean
    public List<Ticket> ticketList(){
        return new ArrayList<>();
    }

    @Bean
    public List<User> userList(){
        return new ArrayList<>();
    }
}
