package com.test.testapplication;


import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.test.testapplication.connector.dto.DataCountryDTO;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StubServices {

    @Autowired
    private RestTemplate restTemplate;


    @Rule
    public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.wireMockConfig()
            .port(3005));


    public void stubCountryDescriptionServiceForCode1235(){
        configureFor("localhost", 3005);
        givenThat(get(urlEqualTo("/country/1235"))
                .willReturn(aResponse()
                        .withBodyFile("response-description.json")
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")));
        assertThat(restTemplate.getForEntity("http://localhost:3005/country/1235",DataCountryDTO.class).getStatusCode().value(), is(200));
    }

    public void resetService(){
        wireMockRule.stop();
    }

    public void startService(){
        wireMockRule.start();
    }


}
