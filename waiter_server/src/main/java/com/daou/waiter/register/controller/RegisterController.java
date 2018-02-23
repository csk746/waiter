package com.daou.waiter.register.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/register")
@RestController
@Slf4j
public class RegisterController {

    @RequestMapping(value = "/{companyId}/{phoneNumber}/{count}",method = RequestMethod.POST)
    public String homeRequest(@PathVariable String companyId,
                            @PathVariable String phoneNumber,
                            @PathVariable int count) {
    return "SUCCESS";
    }
}
