package com.avs.springboot.services;

import com.avs.springboot.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "test", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "test", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "test", "Learn Hibernate", new Date(),
                false));
    }

    @Override
    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String name, String desc, Date targetDate,
                        boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }


    @Override
    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public Todo retrieveTodosById(Integer id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
               return todo;
            }
        }
        return null;
    }

    public void updateTodo(Todo todo){
        todos.remove(todo);
        todos.add(todo);
    }
}
