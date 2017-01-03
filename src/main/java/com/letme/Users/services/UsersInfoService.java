package com.letme.Users.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by mbajwa11 on 12/23/16.
 */
@Service
@Transactional
public class UsersInfoService {
    @Inject
    private static final Logger log = LoggerFactory.getLogger(UsersInfoService.class);
}
