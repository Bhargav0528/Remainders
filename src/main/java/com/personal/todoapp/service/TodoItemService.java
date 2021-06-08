package com.personal.todoapp.service;

import com.personal.todoapp.dto.TodoItemDTO;

import java.util.List;

public interface TodoItemService {

  void saveTodoItem(TodoItemDTO todoItemDTO);

  List<TodoItemDTO> fetchAllTodoItems();

  List<TodoItemDTO> fetchAllTodoItems(String name);

  void fetchTodoItem();

}
