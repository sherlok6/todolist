package com.example.demo.Controller;

import com.example.demo.Form.TaskForm;
import com.example.demo.Model.Task.State;
import com.example.demo.Model.Task.Task;
import com.example.demo.Service.TaskService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/todolist")
public class TaskController {
    @Autowired
    private TaskService service;

    private List<Task> taskList;

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteTask(@RequestParam(name = "task") String taskItem,Authentication authentication) {
        taskList = service.findAllByLogin(authentication.getName());
        taskList.stream().forEach((task1) -> {
            if (task1.getTask().equals(taskItem)) {
                service.delete(task1.getId());
            }
        });
        return "todolist";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewToDoList(Model model,Authentication authentication){
        taskList = service.findAllByLogin(authentication.getName());
        if (taskList.isEmpty()) {
            model.addAttribute("empty", "Empty");
        }
        model.addAttribute("list", taskList);
        return "todolist";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestParam(name = "map",required = false) JSONObject map,Authentication authentication){
        taskList = service.findAllByLogin(authentication.getName());
        taskList.stream().forEach((task1)->{
            System.out.print(task1.getTask()+" ; ("+task1.getState()+")");
        });
        taskList.stream().forEach((task2)->{
            switch (map.getString(task2.getTask())){
                case ("none"):task2.setState(State.ACTIVE);
                  break;
                case ("check"):task2.setState(State.DONE);
                  break;
                default:
                    break;
            }
        });
        System.out.println(" ");
        taskList.stream().forEach((task1)->{
            System.out.print(task1.getTask()+" ; ("+task1.getState()+")");
        });
        System.out.println(" ");
        service.updateList(taskList);
        return "todolist";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String saveTask(@RequestParam(name = "task") String task,TaskForm form,Authentication authentication) {
        if (!task.isEmpty()) {
            service.save(form, authentication.getName());
        }
        return "redirect:/todolist";
    }
}
