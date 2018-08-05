package com.test.testapplication.connector.impl;

import com.test.testapplication.connector.dto.DataCountryDTO;
import com.test.testapplication.connector.dto.DataItems;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DescriptionConnectorImplServiceCheck {

    @Autowired
    private DescriptionConnectorImpl descriptionConnector;


    @Test
    public void getDescription_shouldMatchWithTheVersion() throws Exception {

        DataCountryDTO dataCountryDTO = descriptionConnector.getDescriptionList("1234");

        List<DataItems> dataList = dataCountryDTO.getDataCountry();
        DataItems dataItems = dataList.stream().filter(x -> x.getDescription().equals("1000 people")).findFirst().get();
        Assert.assertEquals("1000 people", dataItems.getDescription());

    }
}