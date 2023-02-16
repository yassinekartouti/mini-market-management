package net.javaguides.sms;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiniMarketManagementApplicationTests {
	public static Logger logger = LoggerFactory.getLogger(MiniMarketManagementApplicationTests.class);
	@Test
	void contextLoads() {
		logger.info("test case executing...");
		assertEquals(true,true);
	}

}
