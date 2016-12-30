package com.letme.Users.repo;


import com.letme.Users.entity.UsersInfo;
import org.springframework.data.jpa.repository.*;

import java.util.ArrayList;
import java.util.Optional;


/**a
 * Created by mbajwa11 on 12/23/16.
 */
public interface UsersInfoRepo extends JpaRepository<UsersInfo, Long> {
    public Optional<UsersInfo> findOneByName(String name);
    public ArrayList<UsersInfo> findByName(String name);
}
