package com.daou.waiter.wait;

import com.daou.waiter.sms.SmsModel;
import com.daou.waiter.sms.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaitServiceImpl implements WaitService {

    @Autowired
    WaitRepository waitRepository;

    @Autowired
    SmsService smsService;

    @Autowired
    StoreRepository storeRepository;

    @Override
    public int setCustomerSequence(long storeId, String phoneNumber, int memberCount) {

        Wait wait = new Wait();

        wait.setPhoneNumber(phoneNumber);
        waitRepository.save(wait);

        Store store = storeRepository.findOne(storeId);
        if (store == null){
            Store s = new Store();
            s.setName("다우 보쌈");
            s.setWaitCount(0);
            store = storeRepository.save(s);
        }
        SmsModel smsModel = new SmsModel();
        smsModel.addReceiver("이건희",phoneNumber);
        smsModel.setContent(store.getName() +" "+ store.getWaitCount()+"명 대기중입니다.");
//        Store store = storeRepository.findOne(storeId);
        store.setWaitCount(store.getWaitCount()+1);
        storeRepository.save(store);

        smsService.smsSend(smsModel);
        return 0;
    }

    @Override
    public boolean removeSequence(long storeId){
        Store store = storeRepository.getOne(storeId);
        store.setWaitCount(store.getWaitCount()-1);

        return true;
    }
}
