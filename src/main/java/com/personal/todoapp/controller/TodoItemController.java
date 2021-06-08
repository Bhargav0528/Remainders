package com.personal.todoapp.controller;

import com.personal.todoapp.entity.TodoItem;
import com.personal.todoapp.repo.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//controller = input apis
//service  = business logic
//repository =

@RestController
public class TodoItemController {

  @Autowired
  TodoItemRepository todoItemRepository;

  @GetMapping("/todoItem")
  public ResponseEntity<String> getTodoItems() {
    return new ResponseEntity<>("todoItems", HttpStatus.OK);
  }

  @PostMapping("/todoItem")
  public ResponseEntity<String> getTodoItems(@RequestBody TodoItem todoItem) {
    todoItemRepository.save(todoItem);
    return new ResponseEntity<>("done", HttpStatus.OK);
  }

  // GET != body , POST body
  // GET "/todoItem" - todoItemController.getTodoItems();
  // 8 threads

  // POST "/todoItem" todoItem - todoItemController.getTodoItems(String todoItem);

}
