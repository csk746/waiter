package com.daou.waiter.wait;

import org.springframework.beans.factory.annotation.Autowired;

public interface WaitService {

    int setCustomerSequence(long storeId, String phoneNumber,int memberCount);
    boolean removeSequence(long storeId);
}
