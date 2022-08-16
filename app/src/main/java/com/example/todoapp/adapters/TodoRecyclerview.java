package com.example.todoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapp.R;
import com.example.todoapp.services.TaskEntry;

import java.util.List;

public class TodoRecyclerview extends RecyclerView.Adapter<TodoRecyclerview.ViewHolder> {

    private List<TaskEntry> tasks;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;

    public TodoRecyclerview(Context context, List<TaskEntry> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.tasks = data;
    }

    @NonNull
    @Override
    public TodoRecyclerview.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoRecyclerview.ViewHolder holder, int position) {
        TaskEntry item = tasks.get(position);
        holder.editTitleTodo.setText(item.getTitle());
        holder.editSubtitleTodo.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener   {
        TextView editTitleTodo, editSubtitleTodo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            editSubtitleTodo = (TextView) itemView.findViewById(R.id.sub_title_todo);
            editTitleTodo = (TextView) itemView.findViewById(R.id.title_todo);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    //
    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
    void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

}
