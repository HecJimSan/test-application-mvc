package com.test.testapplication.bdd;

import com.test.testapplication.StubServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberRoot extends StubServices{

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @LocalServerPort
    protected String port;
}
