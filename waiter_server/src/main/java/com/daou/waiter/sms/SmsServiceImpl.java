package com.daou.waiter.sms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    private static final int ONE_HUNDRED = 100;

    String portalId = "daouoffice@daou.co.kr";
    String password = "daouware8707!";
    @Autowired
    ObjectMapper objectMapper;
    private String loginUrl = "https://portal.daou.co.kr";
    private HashMap<String, String> sessionMap = new HashMap<>();
    private String smsUrl = "https://portal.daou.co.kr/api/sms";

    @Override
    public void smsSend(SmsModel smsModel) {
        smsModel.setSubject("aaaa");
        smsModel.setContent("bbbb");
        smsModel.getMessageType();
        String body = null;
        System.out.println(this.loginUrl + "/api/user/session");
        String cookie = doUserLogin(this.loginUrl, this.portalId, this.password, this.loginUrl + "/api/user/session");

        try {
            body = this.objectMapper.writeValueAsString(smsModel);
        } catch (JsonProcessingException e) {
            log.info("sms body object to string error");
        }
        System.out.println("cookie " + cookie);
        String res = commonRestApiCall(this.smsUrl, body, HttpMethod.POST, cookie);
        log.info("res :" + res);
    }


    private String getSessionKey(String url, String id, String pw) {
        return url + "-" + id + ":" + pw;
    }

    @Override
    public String doUserLogin(String siteUrl, String loginId, String password, String sessionCheckUrl) {

        String sessionKey = this.getSessionKey(siteUrl, loginId, password);
        String session = this.sessionMap.get(sessionKey);
        if (session != null) {
            boolean valid = this.sessionValidation(session, sessionCheckUrl);
            log.info("session validation check :: " + sessionKey + " --- check Url " + sessionCheckUrl + " status :: " + valid);
            if (valid) {
                log.info("user session is alive return old session");
                return session;
            }
        }

        RestTemplate restTemplate = new RestTemplate();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("username", loginId);
        jsonObj.put("password", password);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept-Language", "ko");

        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonObj.toString(), headers);

        String adminSsoCookie = null;
        System.out.println(siteUrl + "/go/ad/api/login");
        ResponseEntity<String> response = restTemplate.postForEntity(siteUrl + "/api/login", httpEntity, String.class);
        HttpHeaders responseHeader = response.getHeaders();
        for (String cookie : responseHeader.get("Set-Cookie")) {
            if (cookie.contains("GOSSOcookie")) {
                adminSsoCookie = cookie;
            }
        }

        this.sessionMap.put(sessionKey, adminSsoCookie);
        return adminSsoCookie;
    }

    private boolean sessionValidation(String session, String url) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));

        headers.set("Cookie", session);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = null;
        httpEntity = new HttpEntity<String>(headers);

        try {
            ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
            int status = res.getStatusCodeValue();
            return (status / ONE_HUNDRED) == 2;
        } catch (Exception e) {
            log.info("rest client exception : " + e.getMessage());
            return false;
        }
    }

    public String commonRestApiCall(String url, String body, HttpMethod method, String cookie) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));

        if (cookie != null) {
            headers.set("Cookie", cookie);
        }

        log.info("request Url : " + url + ", method : " + method.toString());
        log.info("request body ");
        log.info(body);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = null;
        if (body == null) {
            httpEntity = new HttpEntity<String>(headers);
        } else {
            httpEntity = new HttpEntity<String>(body, headers);
        }

        ResponseEntity<String> res = restTemplate.exchange(url, method, httpEntity, String.class);
        return res.getBody();
    }
}
