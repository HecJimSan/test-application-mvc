package com.test.testapplication.connector.impl;

import com.test.testapplication.connector.dto.DataCountryDTO;
import com.test.testapplication.connector.dto.DataItems;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class DescriptionConnectorImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private DescriptionConnectorImpl descriptionConnector;

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(descriptionConnector, "url", "http://localhost:8080");
    }

    @Test
    public void getDescriptionList_shouldReturnDataCountryWhenMakeACall() throws Exception {

        DataCountryDTO dataCountryDTO = new DataCountryDTO();
        ArrayList<DataItems> dataCountry = new ArrayList<>();
        DataItems dataItems = new DataItems();
        dataItems.setCode("population");
        dataItems.setDescription("1000 people");
        dataCountry.add(dataItems);
        dataCountryDTO.setDataCountry(dataCountry);

        ResponseEntity<DataCountryDTO> response = ResponseEntity.ok(dataCountryDTO);
        BDDMockito.given(restTemplate.getForEntity("http://localhost:8080/country/1234", DataCountryDTO.class)).willReturn(response);

        DataCountryDTO dto = descriptionConnector.getDescriptionList("1234");

        Mockito.verify(restTemplate).getForEntity("http://localhost:8080/country/1234", DataCountryDTO.class);

        Assert.assertEquals(dataCountryDTO, dto);

    }
}