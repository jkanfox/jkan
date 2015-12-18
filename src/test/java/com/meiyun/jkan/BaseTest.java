package com.meiyun.jkan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = "classpath:root-context.xml")
@WebAppConfiguration
public class BaseTest {
	
	@Test
	public void contextLoads() {
		System.out.println("sdfdsd");
	}

}
