package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.todoapp.adapters.TodoRecyclerview;
import com.example.todoapp.services.TaskEntry;
import com.example.todoapp.viewModal.MainViewModel;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTitle, editSubTitle;
    Button btnAddTodo;
    MainViewModel viewModel;
    TodoRecyclerview todoRecyclerview; // adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        editTitle = (EditText) findViewById(R.id.editTitle);
        editSubTitle = (EditText) findViewById(R.id.editSubTitle);
        btnAddTodo = (Button) findViewById(R.id.btnAddTodo);
        viewModel.addTask(new TaskEntry("123", "333", "22222"));

        onDataChange(viewModel);

        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTitle.getText().toString();
                String subTitle = editSubTitle.getText().toString();
                TaskEntry taskEntry = new TaskEntry(title, subTitle, "1223123");
                viewModel.addTask(taskEntry);
            }
        });
    }

    public void renderRecyclerView(List<TaskEntry> tasks){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listTodo);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        todoRecyclerview = new TodoRecyclerview(this, tasks);
        recyclerView.setAdapter(todoRecyclerview);
    }

    public void onDataChange(MainViewModel viewModel){
        viewModel.getTasks().observe(this, new Observer<List<TaskEntry>>() {
            @Override
            public void onChanged(List<TaskEntry> taskEntries) {
                Log.d("UPDATE_DATABASE", "Updating list of tasks from LiveData in ViewModel");
                renderRecyclerView(taskEntries);
            }
        });
    }
}
