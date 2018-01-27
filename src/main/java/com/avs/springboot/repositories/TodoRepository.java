package com.avs.springboot.repositories;

import com.avs.springboot.model.Todo;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

    List<Todo> findByUser(String user);
}
