package com.example.todoapp.viewModal;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todoapp.repositorys.TasksRepository;
import com.example.todoapp.services.AppDatabase;
import com.example.todoapp.services.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();
    private LiveData<List<TaskEntry>> tasks;
    private TasksRepository taskRepository;

    public MainViewModel(Application application){
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        taskRepository = new TasksRepository(database);
        tasks = taskRepository.getLoadAllTasks();
    }
    public LiveData<List<TaskEntry>> getTasks(){
        return taskRepository.getLoadAllTasks();
    }
    public void addTask(TaskEntry taskEntry){
        Log.i("ADD_TASK", "CHECK IN MODEL");
        taskRepository.addTaskToState(taskEntry);
    }
    public void deleteTask(TaskEntry taskEntry){
        taskRepository.deleteTasks(taskEntry);
    }


}
