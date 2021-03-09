package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DemoSpringConfigApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		properties = { "levelNumber=2" })
class DemoSpringConfigApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		ResponseEntity<String> responseEntity = restTemplate
				.getForEntity("http://localhost:" + port + "/level", String.class);
		assertEquals("advanced", responseEntity.getBody());
	}
}
