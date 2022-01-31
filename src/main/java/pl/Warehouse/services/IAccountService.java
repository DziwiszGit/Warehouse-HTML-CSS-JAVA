package pl.Warehouse.services;

import pl.Warehouse.models.User;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    public List<User> getUsers();
    public Optional<User> getUserByLogin(String login);
    public void addUser(User user);
}
