package com.dusancivcic.ToDoApp.service;

import com.dusancivcic.ToDoApp.model.ToDoRegisterUser;
import com.dusancivcic.ToDoApp.model.ToDoUser;
import com.dusancivcic.ToDoApp.model.ToDoUserRoll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoRegisterUserService {
    @Autowired
    private ToDoUserService toDoUserService;

    public void registerUser(ToDoRegisterUser toDoRegisterUser) {
        ToDoUser toDoUser = new ToDoUser(toDoRegisterUser.getUserName(),
                toDoRegisterUser.getPassword(),
                true,
                true,
                true,
                true,
                ToDoUserRoll.USER);
        toDoUserService.registerUser(toDoUser);
    }
}
