package oktenweb.services;

import netscape.javascript.JSObject;
import oktenweb.dao.UserDAO;
import oktenweb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public List<User> findAllUsers(){
        return userDAO.findAll();
    }

    public String saveUser(User user){
        userDAO.save(user);
        return "User saved";
    }

    public String logination(String logIn, String password){
        String reply = "";
        List<User> users = userDAO.findAll();
        for (User user : users) {
            if((user.getLogIn().equals(logIn))&&(user.getPassword().equals(password))){
                reply= "Logged in";
            }else {reply= "Wrong input";}
        }return reply;
    }

    public User findById(int id){
        return userDAO.findOne(id);
    }

    public String deleteById(int id){
        userDAO.delete(id);
        return "User deleted";
    }
}
