package com.nasc.digitalAccount;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

//@RunWith(SpringJUnitClassRunner.class)
//@SpringBootTest(
//        classes = SpringCucumberApplication.class,
//        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringIntegrationTest {
    protected RestTemplate restTemplate = new RestTemplate();

    protected final String DEFAULT_URL = "http://localhost:8082/";
}
