package com.personal.todoapp.repo;

import com.personal.todoapp.entity.TodoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItemEntity, Integer> {

  //findById
  //findAll
  //save / insert

  //select * from todo_item_entity where title = :title

  List<TodoItemEntity> findAllByTitle(String title);

  List<TodoItemEntity> findAllByAuthorName(String authorName);

}
