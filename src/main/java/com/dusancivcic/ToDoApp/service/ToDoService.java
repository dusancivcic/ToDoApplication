package com.dusancivcic.ToDoApp.service;

import com.dusancivcic.ToDoApp.model.ToDo;
import com.dusancivcic.ToDoApp.model.ToDoUser;
import com.dusancivcic.ToDoApp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;
    private Authentication authentication;
    private ToDoUser currentUser;


    public List<ToDo> toDoList() {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = (ToDoUser) authentication.getPrincipal();
        Long userId = currentUser.getId();
        return toDoRepository.findByUserId(userId);
    }

    public void addToDo(ToDo toDo) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = (ToDoUser) authentication.getPrincipal();
        Long userId = currentUser.getId();
        toDo.setUserId(userId);
        toDoRepository.save(toDo);
    }

    public ToDo getById(Long id) {
        return toDoRepository.findById(id).orElse(null);
    }

    public void updateToDo(ToDo toDo) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = (ToDoUser) authentication.getPrincipal();
        Long userId = currentUser.getId();
        toDo.setUserId(userId);
        toDoRepository.save(toDo);
    }

    public void deleteToDoById(Long id) {
        toDoRepository.deleteById(id);
    }

    public String loggedUserName() {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUser = (ToDoUser) authentication.getPrincipal();
        String currentUserName = currentUser.getUserName();
        return currentUserName;
    }
}

