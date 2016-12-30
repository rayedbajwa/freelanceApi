package com.letme.Tasks.repo;

import com.letme.Tasks.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mbajwa11 on 12/30/16.
 */
public interface TasksRepo extends JpaRepository<Tasks, Long> {
}
