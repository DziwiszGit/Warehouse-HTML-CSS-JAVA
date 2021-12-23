package pl.Warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.Warehouse.database.AccountDataBase;
import pl.Warehouse.models.User;
import pl.Warehouse.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticateSerivice {

    @Autowired
    AccountDataBase accountDataBase;

    @Resource
    SessionObject sessionObject;

    public void authentication(String login,String password){
        Optional<User> user = this.accountDataBase.getUserByLogin(login);
        if(user.isEmpty()){
            return;
        }
        this.sessionObject.setUser(user.get());
    }

}
