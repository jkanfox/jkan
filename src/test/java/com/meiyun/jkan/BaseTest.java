package com.meiyun.jkan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = "classpath:mvc.xml")
@WebAppConfiguration
public class BaseTest {
	
	Logger logger = LoggerFactory.getLogger(BaseTest.class);

	@Test
	public void contextLoads() {
		logger.info("test");
	}

}
