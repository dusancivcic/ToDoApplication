package com.dusancivcic.ToDoApp.contoller;

import com.dusancivcic.ToDoApp.model.ToDoUser;
import com.dusancivcic.ToDoApp.service.ToDoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoUserController {
    @Autowired
    private ToDoUserService toDoUserService;

    public ToDoUser getUserByUserName(){
        return toDoUserService.getCurrentUser();
    }
}
