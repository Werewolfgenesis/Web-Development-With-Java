package App;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ticket.system.theater.tickets.model.Event;
import ticket.system.theater.tickets.model.Ticket;
import ticket.system.theater.tickets.model.User;
import ticket.system.theater.tickets.repository.EventRepoImpl;
import ticket.system.theater.tickets.repository.ListConfig;
import ticket.system.theater.tickets.service.TicketServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages={
		"ticket.system.theater.tickets.model", "ticket.system.theater.tickets.repository",
		"ticket.system.theater.tickets.service"})
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(ListConfig.class);
		EventRepoImpl eventRepoTest = context.getBean(
				EventRepoImpl.class);
		//initialise events
		eventRepoTest.createEvent(new Event(Long.decode("1111"), "Mitaka Madafaka",
				LocalDateTime.now(), "baaaaatence"));
		eventRepoTest.createEvent(new Event(Long.decode("1112"), "Nasko Pederasko <3",
				LocalDateTime.now(), "Varna mentality"));
		eventRepoTest.createEvent(new Event(Long.decode("1113"), "Gosin Predsedatel",
				LocalDateTime.now(), "The pacifist"));

		//print events
		System.out.println(eventRepoTest.toString());

		//remove event
		eventRepoTest.removeEvent(Long.decode("1111"));

		//find Event by id
		System.out.println(eventRepoTest.findById(Long.decode("1112")).toString());

		//update event
		Event toUpdate = new Event(Long.decode("1112"), "Vasko Pederasko <3",
				LocalDateTime.now(), "Sofia mentality");
		eventRepoTest.updateEvent(toUpdate);

		//print events
		System.out.println(eventRepoTest.toString());

	}


}
