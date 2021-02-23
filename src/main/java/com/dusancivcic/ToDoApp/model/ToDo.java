package com.dusancivcic.ToDoApp.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ToDo {
    @Id
    @SequenceGenerator(name = "ToDoSeq", sequenceName = "ToDoSeq", allocationSize = 1)
    @GeneratedValue(generator = "ToDoSeq")
    private Long id;
    @NotNull
    private String title;
    private Boolean done = false;
    private Long userId;

    public ToDo() {

    }

    public ToDo(String title, Boolean done, Long id) {
        this.title = title;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
