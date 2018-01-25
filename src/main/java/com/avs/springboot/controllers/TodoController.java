package com.avs.springboot.controllers;

import com.avs.springboot.model.Todo;
import com.avs.springboot.services.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
@Slf4j
public class TodoController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }


    @Autowired
    TodoService todoService;

    @GetMapping("/list-todos")
    public String showTodos(ModelMap model) {
        String name = getLoggedInUserName();
        model.put("todos", todoService.retrieveTodos(name));
        return "list-todos";

    }

    @RequestMapping("/add-todos")
    public String showTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo(0, getLoggedInUserName(), "Default Desc",
                new Date(), false));
        return "add-todos";
    }

    @GetMapping("/{id}/delete-todo")
    public String deleteTodo(ModelMap modelMap, @PathVariable String id) {
        String name = getLoggedInUserName();
        todoService.deleteTodo(Integer.valueOf(id));
        return "redirect:/list-todos";
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    @GetMapping("/{id}/update-todo")
    public String showUpdateTodo(ModelMap modelMap, @PathVariable String id) {

        Todo todo = todoService.retrieveTodosById(Integer.valueOf(id));

        modelMap.put("todo", todo);
        return "/add-todos";
    }

    @PostMapping("/{id}/update-todo")
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {

        todo.setUser(getLoggedInUserName());
        if (bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });

            return "/add-todos";
        }

        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @PostMapping("/add-todos")
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });

            return "/add-todos";
        }
        String name = getLoggedInUserName();
        todoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }
}
