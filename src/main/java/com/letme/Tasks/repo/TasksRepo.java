package com.letme.Tasks.repo;

import com.letme.Tasks.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mbajwa11 on 12/30/16.
 */
@Repository
public interface TasksRepo extends JpaRepository<Tasks, Long> {
}
