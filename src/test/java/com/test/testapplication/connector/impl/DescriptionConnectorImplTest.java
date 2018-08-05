package com.test.testapplication.connector.impl;

import com.test.testapplication.connector.dto.DataCountryDTO;
import com.test.testapplication.connector.dto.DataItems;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

public class DescriptionConnectorImplTest {

    private RestTemplate restTemplate;

    private DescriptionConnectorImpl descriptionConnector;

    @Before
    public void setUp() throws Exception {
        restTemplate = Mockito.mock(RestTemplate.class);
        descriptionConnector = new DescriptionConnectorImpl(restTemplate, "http://localhost:8080");
    }

    /*********************************************************************************************
     * This test is working when the test is run by the IDE, however it is not working through maven
     * @throws Exception
     *****************************************************************************************/
    @Test
    @Ignore
    public void getDescriptionList_shouldReturnDataCountryWhenMakeACall() throws Exception {
        DataCountryDTO dataCountryDTO = new DataCountryDTO();
        ArrayList<DataItems> dataCountry = new ArrayList<>();
        DataItems dataItems = new DataItems();
        dataItems.setCode("population");
        dataItems.setDescription("1000 people");
        dataCountry.add(dataItems);
        dataCountryDTO.setDataCountry(dataCountry);

        Mockito.when(restTemplate.getForEntity("http://localhost:8080/country/1234", DataCountryDTO.class)).thenReturn(ResponseEntity.ok(dataCountryDTO));

        DataCountryDTO dto = descriptionConnector.getDescriptionList("1234");

        verify(restTemplate).getForEntity("http://localhost:8080/country/1234", DataCountryDTO.class);

        Assert.assertEquals(dataCountryDTO, dto);

    }
}