package com.letme.Users.services;


import com.letme.Users.controller.UserController;
import com.letme.Users.entity.User;
import com.letme.Users.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

/**
 * Created by mbajwa11 on 12/23/16.
 */
@Service
@Transactional
public class UserService {

    @Inject
    private UserRepo userRepo;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public void deleteUser(User user){
        userRepo.delete(user);
    }
    public void deleteByName(String name){
        ArrayList<User> arr = userRepo.findByName(name);
        for(User user: arr) {
        log.debug("Deleted: ", user.toString());
            userRepo.delete(user);
        }
    }

}
