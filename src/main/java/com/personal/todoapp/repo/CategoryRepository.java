package com.personal.todoapp.repo;

import com.personal.todoapp.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {

    //select * from cate where name = :name
    CategoryEntity findByName(String name);

}
