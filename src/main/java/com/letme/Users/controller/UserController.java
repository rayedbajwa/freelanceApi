package com.letme.Users.controller;

/**
 * Created by mbajwa11 on 12/22/16.
 */


import com.letme.Users.entity.User;
import com.letme.Users.repo.UserRepo;
import com.letme.Users.services.UserService;
import org.springframework.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;


import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RequestMapping("/api/users")
@RestController
public class UserController {
    private static final String template = "Hello, %s!";
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final AtomicLong counter = new AtomicLong();

    @Inject
    private UserRepo userRepo;

    @Inject
    private UserService userService;

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @RequestMapping(value = "delete/{name}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteByName(@PathVariable String name) {
        log.debug("REST request to delete FaqSection : {}", name);
        userService.deleteByName(name);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Alert: ", "Deleted");
        headers.add("Params:", name.toString());
        return ResponseEntity.ok().headers(headers).build();
    }
}


