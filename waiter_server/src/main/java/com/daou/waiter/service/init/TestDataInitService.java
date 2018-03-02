package com.daou.waiter.service.init;

import com.daou.waiter.user.domain.User;
import com.daou.waiter.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hsim on 2017. 8. 13...
 */
@Service
public class TestDataInitService {

    private static final Logger log = LoggerFactory.getLogger(TestDataInitService.class);

    private static final int RANDOM_BOUND = 9000;
    private static final int RANDOM_PLUS_VALUE = 1000;

    @Autowired
    private UserService userService;


    private int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(RANDOM_BOUND) + RANDOM_PLUS_VALUE;

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


