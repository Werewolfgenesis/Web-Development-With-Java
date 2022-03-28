package ticket.system.theater.tickets.repository;

import ticket.system.theater.tickets.model.Ticket;

public interface TicketRepository {
    /**
     * Create ticket
     */
    void createTicket(Ticket u);

    /**
     * Remove ticket
     */
    void removeTicket(Long id);

    /**
     * Find ticket by Id
     */
    Ticket findById(Long id);

    /**
     * Update ticket information
     */
    void updateTicketById(Ticket ticket);
}
