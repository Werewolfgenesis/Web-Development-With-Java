package ticket.system.theater.tickets.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String email;
}
