package com.daou.waiter.user.controller;

import com.daou.waiter.security.account.AccountUserDetails;
import com.daou.waiter.user.domain.User;
import com.daou.waiter.user.repository.UserRepository;
import com.daou.waiter.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping(value = "/detail/{id}")
    public User getUser(@PathVariable Long id) {
        return this.userService.getUser(id);
    }

    @PostMapping(value = "/join")
    public User joinUser(@RequestBody User user) {
        return this.userService.saveUser(user, true);
    }


    @PostMapping(value = "/validation")
    public boolean idValidation(@RequestBody User user) {
        return this.userService.getUser(user.getLoginId()) == null;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AccountUserDetails login(@RequestBody User user, HttpSession session) {

        log.info("login request user " + user.getLoginId() + "/" + user.getPassword());

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getLoginId(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

        AccountUserDetails accountUser = new AccountUserDetails(userRepository.findByLoginId(user.getLoginId()));
        accountUser.setToken(session.getId());

        return accountUser;
    }
}
