package pl.Warehouse.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.Warehouse.database.IAccountDAO;
import pl.Warehouse.models.User;
import pl.Warehouse.services.IAccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    IAccountDAO accountDAO;

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }
    public Optional<User> getUserByLogin(String login){
       return accountDAO.getUserByLogin(login);
    }

    @Override
    public void addUser(User user) {
        accountDAO.addUser(user);
    }

}
