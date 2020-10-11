package com.example.demo.Service;

import com.example.demo.Form.TaskForm;
import com.example.demo.Model.Task.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    List<Task> findAllByLogin(String login);

    void save(TaskForm taskForm, String name);

    void delete(Long id);

    void updateList(List<Task> task,String login);
}
