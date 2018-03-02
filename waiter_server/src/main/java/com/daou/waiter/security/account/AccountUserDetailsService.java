package com.daou.waiter.security.account;

import com.daou.waiter.user.domain.User;
import com.daou.waiter.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AccountUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = repository.findByLoginId(loginId);
        if (user == null) {
            throw new UsernameNotFoundException(loginId);
        }
        return new AccountUserDetails(user);
    }
}
