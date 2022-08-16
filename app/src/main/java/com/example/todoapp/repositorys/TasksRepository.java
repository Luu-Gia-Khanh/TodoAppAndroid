package com.example.todoapp.repositorys;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.todoapp.services.AppDatabase;
import com.example.todoapp.services.TaskDao;
import com.example.todoapp.services.TaskEntry;

import java.util.List;

public class TasksRepository {
    private static final String LOG_TAG = TasksRepository.class
            .getSimpleName();
    private LiveData<List<TaskEntry>> tasks;
    private TaskDao taskDao;
    AppDatabase database;
    public TasksRepository(AppDatabase database) {
        this.database = database;
    }

    public void addTaskToState(TaskEntry taskEntry){
        database.taskDao().insertTask(taskEntry);
    }
    public LiveData<List<TaskEntry>> getLoadAllTasks() {
        tasks = database.taskDao().loadAllTasks();
        return tasks;
    }

    public LiveData<TaskEntry> getloadTaskById(int taskId) {
        return database.taskDao().loadTaskById(taskId);
    }

    public void deleteTasks(TaskEntry taskEntry) {
        database.taskDao().deleteTask(taskEntry);
    }

    public void updateTaskById(TaskEntry task) {
        database.taskDao().updateTask(task);
    }
}
