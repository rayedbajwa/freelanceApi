package com.letme.Users.controller;

/**
 * Created by mbajwa11 on 12/22/16.
 */



import com.letme.Users.services.UsersInfoService;
import org.springframework.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicLong;


@RequestMapping("/api/usersInfo")
@RestController
public class UsersInfoController {
    private static final Logger log = LoggerFactory.getLogger(UsersInfoController.class);
    private final AtomicLong counter = new AtomicLong();

    @Inject
    private UsersInfoService userService;

    @RequestMapping(value = "delete/{name}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteByName(@PathVariable String name) {
        log.debug("REST request to delete Delete By name : {}", name);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Alert: ", "Deleted");
        headers.add("Params:", name.toString());
        return ResponseEntity.ok().headers(headers).build();
    }
}


