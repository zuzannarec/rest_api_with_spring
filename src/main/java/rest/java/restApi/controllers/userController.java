package rest.java.restApi.controllers;

import java.lang.String;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.java.restApi.exceptions.userNotFoundException;
import rest.java.restApi.model.UserList;
import rest.java.restApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import rest.java.restApi.model.User;


import javax.validation.Valid;
import java.util.Optional;

@RestController
public class userController {
    @Autowired
    UserService service;


    @GetMapping("/users/{name}")
    public User getSurnameByName(@PathVariable("name") String name){
        Optional<User> optionalUser = service.getUserByName(name);

        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new userNotFoundException("user not found:" + name);
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody @Valid User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addUser(user));
    }

    @GetMapping("/users")
    public UserList getAllUsers(){
        return new UserList(service.getAllUsers());
    }

    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody @Valid User user, @PathVariable() Long id) {
        service.updateUser(user, id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }

}
