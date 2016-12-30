package com.letme.Users.repo;

import com.letme.Users.entity.Tasks;
import com.letme.Users.entity.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mbajwa11 on 12/30/16.
 */
public interface TasksRepo extends JpaRepository<Tasks, Long> {
}
