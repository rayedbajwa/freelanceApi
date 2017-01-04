package com.letme.Tasks.controller;

import com.letme.Tasks.entity.Tasks;
import com.letme.Tasks.services.TaskService;
import com.letme.Utility.Mapper;
import org.omg.CORBA.Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import javax.inject.Inject;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.*;
/**
 * Created by mbajwa11 on 12/30/16.
 */
@RequestMapping("/api/tasks")
@RestController
public class TasksController {
    private static final Logger log = LoggerFactory.getLogger(TasksController.class);

    @Inject
    private TaskService taskService;
    Date currDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<List<Tasks>> getAll() throws Exception{
        List<Tasks> temp = taskService.getAll();
        return new ResponseEntity<List<Tasks>>(temp, HttpStatus.OK);
    }

    @RequestMapping(value = "getbyid/{id}", method = RequestMethod.GET)
    public Tasks getByID(@PathVariable(value = "id") Long id){
        log.debug("Get By ID in Tasks Controller: ", id);
        return taskService.getByID(id);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteByID(@PathVariable(value = "id") Long id){
        log.debug("Delete By Tasks ID : ", id);
        HttpHeaders head = new HttpHeaders();
        head.add("Task Deleted", ""+id);
        taskService.delete(id);
        return ResponseEntity.ok().headers(head).build();
    }
    /*
              {
                name:Very Good,
                desc:tyest,
                type_id:2,
                created_date:23/12/1990,
                expire_date:23/12/1991,
                budget:12,
                street_add:12 canton please,
                city_id:1,
                country_id:3,
                zip:48188,
                status:1,
                active:true

               }
    */
    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addNew(@RequestBody Tasks task){
            System.out.print(task);
            Tasks res = taskService.save(task);
            return new ResponseEntity<Tasks>(task, HttpStatus.OK);
    }
}
