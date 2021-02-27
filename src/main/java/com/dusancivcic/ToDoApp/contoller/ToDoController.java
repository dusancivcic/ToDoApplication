package com.dusancivcic.ToDoApp.contoller;

import com.dusancivcic.ToDoApp.model.ToDo;
import com.dusancivcic.ToDoApp.model.ToDoRegisterUser;
import com.dusancivcic.ToDoApp.service.ToDoRegisterUserService;
import com.dusancivcic.ToDoApp.service.ToDoService;
import com.dusancivcic.ToDoApp.service.ToDoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping("/addToDo")
    public void addToDo(@ModelAttribute ToDo toDo) {
        toDoService.addToDo(toDo);
    }

    @RequestMapping(value = "/updateToDo", method = {RequestMethod.PUT, RequestMethod.GET})
    public void updateToDo(ToDo toDo) {
        toDoService.updateToDo(toDo);
    }

    @GetMapping("/getList")
    public List<ToDo> getToDoList(){
        return toDoService.toDoList();
    }
   /* @GetMapping("/homePage")
    public String getHomePage(Model model) {
        model.addAttribute("todoList", toDoService.toDoList());
        model.addAttribute("userName", toDoUserService.loggedUserName());
        return "homePage";
    }

    */

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public void deleteById(Long Id) {
        toDoService.deleteToDoById(Id);
    }

    @RequestMapping("/getById")
    @ResponseBody
    public ToDo getById(Long Id) {
        return toDoService.getById(Id);
    }

    @GetMapping("/login")
    public String getLoginView() {
        return "loginPage";
    }
}
