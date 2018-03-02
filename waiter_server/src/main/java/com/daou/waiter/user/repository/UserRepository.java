package com.daou.waiter.user.repository;

import com.daou.waiter.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hsim on 2017. 8. 13...
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Long countByLoginId(String loginId);

    User findByLoginId(String loginId);

    User findByLoginIdAndPassword(String loginId, String password);
}


