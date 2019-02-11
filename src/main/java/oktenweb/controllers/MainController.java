package oktenweb.controllers;

import oktenweb.dao.UserDAO;
import oktenweb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/")
    public String callPage(){
        return "index";
    }

    @GetMapping("/loginationPage")
    public String loginationPage(){
        return "logination";
    }

    @GetMapping("/backToMainPage")
    public String backToMainPage(){
        return "index";
    }

    @GetMapping("/selectAllUsers")
    public String allUsers(Model model){
        model.addAttribute("users", userDAO.findAll());
        return "select1";
    }


//    @PostMapping("/saveUser")
//    public String save(
//            @RequestParam("logIn") String logIn,
//            @RequestParam("password") String password,
//            @RequestParam("name") String name,
//            @RequestParam("surname") String surname,
//            @RequestParam("email") String email,
//            @RequestParam("DOB") String DOB
//    ){
//        User user = new User();
//        user.setLogIn(logIn);
//        user.setPassword(password);
//        user.setName(name);
//        user.setSurname(surname);
//        user.setEmail(email);
//        user.setDOB(DOB);
//        userDAO.save(user);
//        return "redirect:/";
//    }

//    @PostMapping("/logIn")
//    public String logination(
//            Model model,
//            @RequestParam("logIn") String logIn,
//            @RequestParam("password") String password){
//        String url="";
//        List<User> users = userDAO.findAll();
//        for (User user : users) {
//            if((user.getLogIn().equals(logIn))&&(user.getPassword().equals(password))){
//                System.out.println("Logged in SUCCESSFULLY");
//                url= "redirect:/";
//
//            }
//            else {
//                System.out.println("Wrong INPUT");
//                url= "logination";
//            }
//        }return url;
//    }
//

}
