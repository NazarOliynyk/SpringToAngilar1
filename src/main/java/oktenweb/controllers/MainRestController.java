package oktenweb.controllers;

import oktenweb.models.User;
import oktenweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRestController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "*")
    @GetMapping("/users")
    public List<User> users() {
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user) {
        System.out.println(user);
        System.out.println(userService.saveUser(user));
        return userService.saveUser(user);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/users/{id}")
    public List<User> delete(@PathVariable int id) {
        userService.deleteById(id);
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/users/{id}")
    public User findUser(@PathVariable int id) {
        return userService.findById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/logIn")
    public String logination(@RequestParam("logIn") String logIn,
                             @RequestParam("password") String password){
        System.out.println(userService.logination(logIn, password));
        return userService.logination(logIn, password);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/deleteUser")
    public String delete(@RequestBody User user){
        int id = user.getId();
        return userService.deleteById(id);
    }

}


