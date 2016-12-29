package com.letme.Users.repo;

import com.letme.Users.entity.User;
import org.springframework.data.jpa.repository.*;

import java.util.ArrayList;
import java.util.Optional;


/**a
 * Created by mbajwa11 on 12/23/16.
 */
public interface UserRepo extends JpaRepository<User, Long> {
    public Optional<User> findOneByName(String name);
    public ArrayList<User> findByName(String name);
}
