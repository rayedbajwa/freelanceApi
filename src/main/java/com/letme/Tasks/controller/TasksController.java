package com.letme.Tasks.controller;

import com.letme.Tasks.entity.Tasks;
import com.letme.Tasks.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by mbajwa11 on 12/30/16.
 */
@RequestMapping("/api/tasks")
@RestController
public class TasksController {
    private static final Logger log = LoggerFactory.getLogger(TasksController.class);

    @Inject
    private TaskService taskService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Tasks> getAll(){
        return taskService.getAll();
    }
}
