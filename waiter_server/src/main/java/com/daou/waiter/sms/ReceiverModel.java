package com.daou.waiter.sms;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReceiverModel {
    String receiverName;
    String receiverNumber;

    public ReceiverModel(String receiverName, String receiverNumber) {
        super();
        this.receiverName = receiverName;
        this.receiverNumber = receiverNumber;
    }

    public void setReceiverNumber(String receiverNumber) {
        if (receiverNumber == null) {
            return;
        }
        this.receiverNumber = receiverNumber.replaceAll("-", "");
    }
}
