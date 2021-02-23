package com.dusancivcic.ToDoApp.contoller;

import com.dusancivcic.ToDoApp.model.ToDo;
import com.dusancivcic.ToDoApp.model.ToDoRegisterUser;
import com.dusancivcic.ToDoApp.service.ToDoRegisterUserService;
import com.dusancivcic.ToDoApp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @Autowired
    private ToDoRegisterUserService toDoRegisterUserService;

    @PostMapping("/addToDo")
    public String addToDo(@ModelAttribute ToDo toDo) {
        toDoService.addToDo(toDo);
        return "redirect:/homePage";
    }

    @RequestMapping(value = "/updateToDo", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateToDo(ToDo toDo) {
        toDoService.updateToDo(toDo);
        return "redirect:/homePage";
    }

    @GetMapping("/homePage")
    public String getHomePage(Model model) {
        model.addAttribute("todoList", toDoService.toDoList());
        model.addAttribute("userName", toDoService.loggedUserName());
        return "homePage";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Long Id) {
        toDoService.deleteToDoById(Id);
        return "redirect:/homePage";
    }

    @PostMapping("/registerUser")
    public String saveUser(@ModelAttribute ToDoRegisterUser toDoRegisterUser) {
        toDoRegisterUserService.registerUser(toDoRegisterUser);
        return "loginPage";
    }

    @GetMapping("/register")
    public String registerToDoUser(Model model) {
        ToDoRegisterUser toDoRegisterUser = new ToDoRegisterUser();
        model.addAttribute("user", toDoRegisterUser);
        return "registerPage";
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
