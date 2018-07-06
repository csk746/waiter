package com.daou.waiter.wait;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/register")
@RestController
@Slf4j
public class WaitController {

    @Autowired
    WaitService waitService;

    @RequestMapping(value = "/{storeId}/{phoneNumber}/{memberCount}",method = RequestMethod.POST)
    public String homeRequest(@PathVariable long storeId,
                              @PathVariable String phoneNumber,
                              @PathVariable int memberCount) {

        waitService.setCustomerSequence(storeId,phoneNumber,memberCount);

        return "SUCCESS";
    }
    @RequestMapping(value = "/{storeId}",method = RequestMethod.DELETE)
    public boolean removeWaitCount(@PathVariable long storeId){

        return waitService.removeSequence(storeId);
    }
}
