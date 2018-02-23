package com.daou.waiter.service.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daou.waiter.user.Service.UserService;
import com.daou.waiter.user.domain.User;

/**
 * Created by hsim on 2017. 8. 13...
 */
@Service
public class TestDataInitService {

    private static final Logger log = LoggerFactory.getLogger(TestDataInitService.class);

    @Autowired
    private UserService userService;


    private int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(9000) + 1000;

    }

    private User getDefaultUser(String id, String name, String password) {
        User user = new User();
        user.setLoginId(id);
        user.setName(name);
        user.setPassword(password);
        user.setEmail(id + "@gmail.com");
        user.setGrade(0);
        user.setPhone("010-" + this.getRandomNumber() + "-" + this.getRandomNumber());
        return user;
    }

    @PostConstruct
    public void setUserInit() {

        List<User> saveUserList = new ArrayList<>();

        saveUserList.add(this.getDefaultUser("admin", "admin", "admin"));
        saveUserList.add(this.getDefaultUser("hsim", "임희섭", "1234"));

        this.userService.saveUser(saveUserList, true);

    }

}


