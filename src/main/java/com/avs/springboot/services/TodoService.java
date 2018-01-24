package com.avs.springboot.services;

import com.avs.springboot.model.Todo;

import java.util.Date;
import java.util.List;

public interface TodoService {

    public List<Todo> retrieveTodos(String user);

    public Todo retrieveTodosById(Integer id);

    public void addTodo(String name, String desc, Date targetDate,
                        boolean isDone);

    public void deleteTodo(int id);

    public void updateTodo(Todo todo);
}
