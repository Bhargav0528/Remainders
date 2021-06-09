package com.personal.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemDTO {
  private String title;
  private String description;
  private String authorName;
  private String categoryName;
}
