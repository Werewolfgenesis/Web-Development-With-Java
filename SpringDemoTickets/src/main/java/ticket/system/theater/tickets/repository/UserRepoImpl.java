package ticket.system.theater.tickets.repository;

import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ticket.system.theater.tickets.model.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepoImpl implements UserRepository{
    @Autowired
    private List<User> users;

    public UserRepoImpl(){
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User u) {
        this.users.add(u);
    }

    @Override
    public void deleteUser(Long id) {
        this.users.removeIf(u -> u.getId().equals(id));
    }

    @Override
    public User findById(Long id) {
        for (User e:
             this.users) {
            if (e.getId().equals(id)){
                return  e;
            }
        }
        throw new IllegalArgumentException("No user with such id!");
    }

    @Override
    public void updateUser(User user) {
        User toUpdate = findById(user.getId());
        toUpdate = user;
    }
}
