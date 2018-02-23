package com.daou.waiter.sms;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class SMS {
    /**
     * primary key
     */
    private String cmid;


    private Long receiverId;

    /**
     * 다우기술 서버에서 정의한 message Id
     */
    private String umid;

    /**
     * 데이터 타입 (0 SMS / 1 WAP / 2 FAX / 3 PHONE / 4 SMS_INBOUND / 5 MMS)
     */
    private int msgType;

    /**
     * 데이터 발송상태 (0 대기 / 1 발송중 / 2 발송완료 / 3 에러)
     */
    private int status;

    /**
     * 입력 시간
     */
    private Date requestTime;

    /**
     * 발송(예약) 시간
     */
    private Date sendTime;

    /**
     * 발송 완료 시간
     */
    private Date reportTime;

    /**
     * 받는 사람 전화 번호
     */
    private String destPhone;

    /**
     * 받는 사람 이름
     */
    private String destName;

    /**
     * 보내는 사람 전화 번호
     */
    private String sendPhone;

    /**
     * 보내는 사람 이름
     */
    private String sendName;

    /**
     * (FAX/MMS) 제목 (최대 60byte)
     * (SMS_INBOUND) 데이터 내용
     */
    private String subject;

    /**
     * 데이터 내용
     */
    private String msgBody;

    /**
     * (WAP) URL 주소
     */
    private String wapUrl;

    /**
     * (FAX) 커버 발송 옵션
     */
    private int coverFlag;

    /**
     * (PHONE) 실패시 문자 전송 옵션
     */
    private int smsFlag;

    /**
     * (PHONE) 응답 받기 선택
     */
    private int replyFlag;

    /**
     * (FAX/PHONE) 재시도 회수 (5~10분 간격 : 최대 3회)
     */
    private int retryCnt;

    /**
     * (PHONE/FAX/MMS) 파일 전송시 파일 이름
     */
    private String faxFile;

    /**
     * (PHONE) 음성 시나리오 파일 이름
     */
    private String vxmlFile;

    /**
     * 데이터의 결과 리포트
     */
    private int callStatus;

    /**
     * (FAX) 발송 페이지 수
     */
    private int usePage;

    /**
     * (PHONE) 발송 소요 시간 (단위 : 초)
     */
    private int useTime;

    /**
     * (PHONE) 설문조사 응답 값
     */
    private int snResult;

    /**
     * 통신사 정보(SKT, KTF, LGT)
     */
    private String wapInfo;

    /**
     * Client Indexed Info
     * ( 특수기호 \/:*?"<>|. 를 사용할 사용할 수 없음 )
     */
    private String cinfo;

    /**
     * 처리결과 여부 판단
     */
    private boolean sendFlag;
}
