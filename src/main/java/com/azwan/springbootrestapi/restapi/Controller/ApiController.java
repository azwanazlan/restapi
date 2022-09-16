package com.azwan.springbootrestapi.restapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.azwan.springbootrestapi.restapi.Models.User;
import com.azwan.springbootrestapi.restapi.Repo.UserRepo;

@RestController
public class ApiController {
    
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping("/user")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        // User user = new User();
        userRepo.save(user);
        return "saved...";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@RequestBody long id, User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setfirstName(user.getfirstName());
        updatedUser.setLastName(user.getlastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "updated...";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@RequestBody long id) {
        User deletedUser = userRepo.findById(id).get();
        userRepo.delete(deletedUser);
        return "deleted... with the id: " + id;
    }

    
}
