package com.personal.todoapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.todoapp.dto.TodoItemDTO;
import com.personal.todoapp.entity.TodoItemEntity;
import com.personal.todoapp.repo.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class TodoItemServiceImpl implements TodoItemService{

  @Autowired
  private TodoItemRepository todoItemRepository;

  @Override
  public void saveTodoItem(TodoItemDTO todoItemDTO) {
//    TodoItem todoItem = new TodoItem();
//    todoItem.setTitle(todoItemDTO.getTitle());
//    todoItem.setAuthorName(todoItemDTO.getAuthorName());
//    todoItem.setDescription(todoItemDTO.getDescription());
//    todoItem.setCreatedAt(new Date());

//    ObjectMapper objectMapper = new ObjectMapper();
//    TodoItemEntity todoItemEntity = objectMapper.convertValue(todoItemDTO, TodoItemEntity.class);

    TodoItemEntity todoItemEntity =
        TodoItemEntity.builder()
            .title(todoItemDTO.getTitle())
            .description(todoItemDTO.getDescription())
            .authorName(todoItemDTO.getAuthorName())
            .createdAt(new Date())
            .build();

    todoItemRepository.save(todoItemEntity);
  }

  @Override
  public List<TodoItemDTO> fetchAllTodoItems() {
     List<TodoItemEntity> todoItemEntities = todoItemRepository.findAll();

     List<TodoItemDTO> todoItemDTOS = new ArrayList<>();
     for (TodoItemEntity todoItemEntity : todoItemEntities) {
       TodoItemDTO todoItemDTO = new TodoItemDTO();
       todoItemDTO.setTitle(todoItemEntity.getTitle());
       todoItemDTO.setDescription(todoItemEntity.getDescription());
       todoItemDTO.setAuthorName(todoItemEntity.getAuthorName());
       todoItemDTOS.add(todoItemDTO);
     }
     return todoItemDTOS;
//     return todoItemEntities.stream().map(todoItemEntity ->
//       new TodoItemDTO(todoItemEntity.getTitle(), todoItemEntity.getDescription(), todoItemEntity.getAuthorName())
//     ).collect(Collectors.toList());
  }

  @Override
  public List<TodoItemDTO> fetchAllTodoItems(String name) {
    List<TodoItemEntity> todoItemEntities = todoItemRepository.findAllByTitle(name);

    List<TodoItemDTO> todoItemDTOS = new ArrayList<>();
    for (TodoItemEntity todoItemEntity : todoItemEntities) {
      TodoItemDTO todoItemDTO = new TodoItemDTO();
      todoItemDTO.setTitle(todoItemEntity.getTitle());
      todoItemDTO.setDescription(todoItemEntity.getDescription());
      todoItemDTO.setAuthorName(todoItemEntity.getAuthorName());
      todoItemDTOS.add(todoItemDTO);
    }
    return todoItemDTOS;
  }


  @Override
  public void fetchTodoItem() {

  }
}
