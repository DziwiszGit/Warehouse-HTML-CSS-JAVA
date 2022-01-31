package pl.Warehouse.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.Warehouse.database.AccountDataBase;
import pl.Warehouse.database.IAccountDAO;
import pl.Warehouse.models.User;
import pl.Warehouse.services.IAuthenticationService;
import pl.Warehouse.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticateSerivice implements IAuthenticationService {

    @Autowired
    IAccountDAO accountDAO;

    @Resource
    SessionObject sessionObject;

    public void authentication(String login,String password){
        Optional<User> user = accountDAO.getUserByLogin(login);
        if(user.isEmpty()){
            return;
        }
        this.sessionObject.setUser(user.get());
    }

}
