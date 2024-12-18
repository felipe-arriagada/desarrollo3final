package com.api.crud.controllers;


import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController///  convierte automáticamente los objetos Java en respuestas JSON o XML para APIs RESTful.
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return userService.saveUser(user);

    }
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable ("id")Long id) {
        return userService.getUserById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request,@PathVariable Long id) {
        return userService.updateUserById(request,id);
    }

@DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.userService.DeleteUser(id);

        if (ok) {
            return "User with id" + id + "Deleted";
        }else {
            return "User with id" + id + "Not found";
        }
}
}
