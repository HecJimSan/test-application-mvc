package com.test.testapplication.connector.impl;

import com.test.testapplication.StubServices;
import com.test.testapplication.connector.dto.DataCountryDTO;
import com.test.testapplication.connector.dto.DataItems;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DescriptionConnectorImplServiceCheck extends StubServices {

    @Autowired
    private DescriptionConnectorImpl descriptionConnector;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getDescription_shouldMatchWithTheVersion() throws Exception {
        stubCountryDescriptionServiceForCode1235();

        DataCountryDTO dataCountryDTO = descriptionConnector.getDescriptionList("1235");

        List<DataItems> dataList = dataCountryDTO.getDataCountry();
        DataItems dataItems = dataList.stream().filter(x -> x.getDescription().equals("1000 people")).findFirst().get();
        Assert.assertEquals("1000 people", dataItems.getDescription());
    }
}