package pl.Warehouse.database;

import org.springframework.stereotype.Component;
import pl.Warehouse.models.Positions;
import pl.Warehouse.models.User;
import pl.Warehouse.models.Warehouseman;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AccountDataBase {
    private List<User> users = new ArrayList<>();

    public AccountDataBase() {
        users.add(new User("admin","admin"));
        users.add(new User("root","root"));
    }

    public List<User> getUsers() {
        return users;
    }
    public Optional<User> getUserByLogin(String login){
        for(User user : this.users){
            if(user.getLogin().equals(login)){
                return Optional.of(user);
            }
        }
        return  Optional.empty();
    }
}
