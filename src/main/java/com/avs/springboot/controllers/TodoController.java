package com.avs.springboot.controllers;

import com.avs.springboot.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {


    @Autowired
    TodoService todoService;

    @GetMapping("/list-todos")
    public String showTodos(ModelMap model) {
        String name = (String) model.get("name");
        model.put("todos", todoService.retrieveTodos(name));
        return "list-todos";

    }

    @RequestMapping("/add-todos")
    public String showTodoPage(ModelMap model) {

        return "add-todos";
    }

    @RequestMapping("/{id}/delete-todo")
    public String deleteTodo(ModelMap modelMap, @PathVariable String id) {
        String name = (String) modelMap.get("name");
        todoService.deleteTodo(Integer.valueOf(id));
        return "redirect:/list-todos";
    }


    @PostMapping("/add-todos")
    public String addTodo(ModelMap model, @RequestParam String description) {
        String name = (String) model.get("name");
        todoService.addTodo(name, description, new Date(), false);
        return "redirect:list-todos";
    }
}
