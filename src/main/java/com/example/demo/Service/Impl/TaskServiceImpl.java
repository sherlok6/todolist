package com.example.demo.Service.Impl;

import com.example.demo.Form.TaskForm;
import com.example.demo.Model.Task.State;
import com.example.demo.Model.Task.Task;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository repository;

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Task> findAllByLogin(String login) {
        return repository.findAllByLogin(login);
    }

    @Override
    public void save(TaskForm taskForm, String name) {
        repository.save(
                Task.builder()
                        .login(name)
                        .state(State.ACTIVE)
                        .task(taskForm.getTask())
                        .build()
        );
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateList(List<Task> task) {
       ListIterator<Task> taskListIterator = task.listIterator();
           while(taskListIterator.hasNext()) {
               repository.updateStateTask(taskListIterator.next().getTask(), taskListIterator.next().getState().toString());
           }
    }
}
