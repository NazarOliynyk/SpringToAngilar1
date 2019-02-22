package oktenweb.controllers;

import oktenweb.models.Response;
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
    public Response saveUser(@RequestBody User user) {
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
    // this findUser method is no longer needed since the getting of a single user is held
    // on the front-end in the order to reduce code -
    // it uses the same url "/users" to get the whole list and check through it

//    @CrossOrigin(origins = "*")
//    @GetMapping("/users/{id}")
//    public User findUser(@PathVariable int id) {
//        return userService.findById(id);
//    }

    // this logination method is no longer needed since the logination is held
    // on the front-end in the order to reduce code -
    // it uses the same url "/users" to get the whole list and check through it

//    @CrossOrigin(origins = "*")
//    @PostMapping("/login")
//    public String logination(@RequestParam("login") String logIn,
//                             @RequestParam("password") String password){
//        System.out.println(userService.logination(logIn, password));
//        return userService.logination(logIn, password);
//    }

    // the following method delete is no longer needed since the above-mentioned
    // method is used to delete users

//    @CrossOrigin(origins = "*")
//    @PostMapping("/deleteUser")
//    public String delete(@RequestBody User user){
//        int id = user.getId();
//        return userService.deleteById(id);
//    }

}


