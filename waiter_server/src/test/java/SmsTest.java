import com.daou.waiter.sms.SmsModel;
import com.daou.waiter.sms.SmsService;
import config.ContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Action;

public class SmsTest extends ContextTest{

    @Autowired
    private SmsService smsService;

    @Test
    public void SMS보내기(){
        SmsModel smsModel = new SmsModel();
        smsModel.addReceiver("이건희","010-4529-3709");

        smsService.smsSend(smsModel);
        }
}
