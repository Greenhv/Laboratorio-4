package com.example.labtel.laboratorio4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.labtel.laboratorio4.Task;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by front-team on 11/2/16.
 */

public class TaskAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<com.example.labtel.laboratorio4.Task> taskList = new ArrayList<com.example.labtel.laboratorio4.Task>();

    public TaskAdapter(Context context, ArrayList<com.example.labtel.laboratorio4.Task> oTaskList) {
        this.mContext = context;
        this.taskList = oTaskList;
    }

    @Override
    public int getCount() {
        return this.taskList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class Task {
        TextView name;
        TextView date;
        TextView items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = new Task();
        View row;
        row = LayoutInflater.from(mContext).inflate(R.layout.task_layout, parent, false);
        task.name = (TextView) row.findViewById(R.id.task_name);
        task.date = (TextView) row.findViewById(R.id.task_date);
        task.items = (TextView) row.findViewById(R.id.task_items);

        task.name.setText(taskList.get(position).getTitulo());
        task.date.setText(taskList.get(position).getFechaInicio());
        task.items.setText(taskList.get(position).getListaTareas());

        return row;
    }
}
