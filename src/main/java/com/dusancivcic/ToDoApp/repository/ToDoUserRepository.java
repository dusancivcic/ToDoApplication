package com.dusancivcic.ToDoApp.repository;

import com.dusancivcic.ToDoApp.model.ToDoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoUserRepository extends JpaRepository<ToDoUser,Long> {
    ToDoUser findByUserName(String userName);
}
