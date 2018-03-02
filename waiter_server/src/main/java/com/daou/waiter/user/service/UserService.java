package com.daou.waiter.user.service;

import com.daou.waiter.user.domain.User;

import java.util.List;

/**
 * Created by hsim on 2017. 8. 13...
 */
public interface UserService {

    public boolean isExistUser(String loginId, String password);

    public User getUser(Long id);

    public User getUser(String loginId);

    public User getUser(String loginId, String password);

    public User save(User user);

    public User saveUser(User user, boolean encode);

    public List<User> saveUser(List<User> user, boolean encode);

    public boolean isExistUser(String loginId);

}


