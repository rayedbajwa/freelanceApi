package com.letme.Tasks.services;

import com.letme.Tasks.entity.Tasks;
import com.letme.Tasks.repo.TasksRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by mbajwa11 on 12/30/16.
 */
@Service
@Transactional
public  class TaskService {
    @Inject
    private TasksRepo tasksRepo;

    public List<Tasks> getAll(){
        return tasksRepo.findAll();
    }

    public Tasks save(Tasks temp){
        Tasks result = tasksRepo.save(temp);
        return result;
    }
    public Tasks getByID(Long id){
       return tasksRepo.findOne(id);
    }
    public void delete(Long id){
        tasksRepo.delete(id);
    }
}
