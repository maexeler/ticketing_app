package ch.zli.m223.model.impl;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Todo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="Todo")
public class TodoImpl implements Todo {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private boolean completed;
    private Long userid;

    @Override
    public Long getId() { return id; }

    @Override
    public Long getUserId() { return userid; }

    @Override
    public String getTitle() { return title; }

    @Override
    public boolean getCompleted() { return completed; }
    
    protected TodoImpl() {}
    public TodoImpl(AppUser user, String title, boolean completed) {
        this.userid = user.getId();
        this.title = title;
        this.completed = completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
