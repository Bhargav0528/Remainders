package com.personal.todoapp.controller;

import com.personal.todoapp.dto.TodoItemDTO;
import com.personal.todoapp.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//controller = input apis
//service  = business logic
//repository = talk to db
//

//CRUD
// JSON
// STATELESS

/**
 * Categories
 */

@RestController
public class TodoItemController {

  @Autowired
  TodoItemService todoItemService;

  @PostMapping("/todoitem/save")
  public ResponseEntity<Boolean> saveTodoItem(@RequestBody TodoItemDTO todoItemDTO) {
    todoItemService.saveTodoItem(todoItemDTO);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @GetMapping("/todoitem/fetch")
  public ResponseEntity<List<TodoItemDTO>> fetchAllTodoItems() {
    return new ResponseEntity<>(todoItemService.fetchAllTodoItems(), HttpStatus.OK);
  }

  @GetMapping("/todoitem/fetch/name/")
  public ResponseEntity<List<TodoItemDTO>> fetchTodoItemsByname(@RequestParam String itemName) {
    return new ResponseEntity<>(todoItemService.fetchAllTodoItems(itemName), HttpStatus.OK);
  }


  // GET != body , POST body
  // GET "/todoItem" - todoItemController.getTodoItems();
  // 8 threads

  // POST "/todoItem" todoItem - todoItemController.getTodoItems(String todoItem);

}
