package com.example.todoapp.services;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity (tableName = "task")
public class TaskEntry {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    @ColumnInfo(name = "updated_at")
    private String updatedAt;

    @Ignore
    public TaskEntry(String title,String description, String updatedAt){
        this.title = title;
        this.description = description;
        this.updatedAt = updatedAt;
    }
    @Ignore
    public TaskEntry(){
        this.id = 0;
        this.title = "";
        this.description = "";
        this.updatedAt = "";
    }

    public TaskEntry(int id,String title, String description, String updatedAt){
        this.id = id;
        this.title = title;
        this.description = description;
        this.updatedAt = updatedAt;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
