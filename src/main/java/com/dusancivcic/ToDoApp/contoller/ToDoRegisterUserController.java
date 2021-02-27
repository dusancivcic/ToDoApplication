package com.dusancivcic.ToDoApp.contoller;

import com.dusancivcic.ToDoApp.model.ToDoRegisterUser;
import com.dusancivcic.ToDoApp.service.ToDoRegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoRegisterUserController {
    @Autowired
    private ToDoRegisterUserService toDoRegisterUserService;
    @PostMapping("/registerUser")
    public void saveUser(@RequestBody ToDoRegisterUser toDoRegisterUser) {
        toDoRegisterUserService.registerUser(toDoRegisterUser);
    }
}
