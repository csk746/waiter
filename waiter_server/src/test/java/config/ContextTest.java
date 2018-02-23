package config;

import com.daou.waiter.WaiterApplication;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gh on 2016-11-15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WaiterApplication.class)
//@TestPropertySource(locations="classpath:application-test.properties")
@Ignore
public class ContextTest {

}