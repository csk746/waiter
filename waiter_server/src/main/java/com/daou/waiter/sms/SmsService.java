package com.daou.waiter.sms;

public interface SmsService {
    public void smsSend(SmsModel smsModel);

    public String doUserLogin(String siteUrl, String loginId, String password, String sessionCheckUrl);
}
