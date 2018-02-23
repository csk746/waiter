package com.daou.waiter.sms;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class SmsModel {
    private String subject ;
    private String content ;

    private List<ReceiverModel> receivers = new ArrayList<>();
    private List<String> contactGroupReceivers = new ArrayList<>();

    private String senderNumber = "1599-9460";

    public void addReceiver(String name, String number){
        this.receivers.add(new ReceiverModel(name, number));
    }

    public String getMessageType(){
        if (content == null) return "SMS";
        if(content.getBytes().length < 140) return "SMS";
        return "LMS";
    }
}
