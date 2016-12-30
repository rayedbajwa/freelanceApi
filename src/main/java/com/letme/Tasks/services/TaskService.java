package com.letme.Tasks.services;

import com.letme.Tasks.entity.Tasks;
import com.letme.Tasks.repo.TasksRepo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
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
}
