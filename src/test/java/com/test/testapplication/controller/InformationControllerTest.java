package com.test.testapplication.controller;

import com.test.testapplication.service.InformationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class InformationControllerTest {

    public static final String CODE_MESSAGE = "response should contains code";
    public static final String DESCRIPTION_MESSAGE = "response should contains description";

    @Mock
    private InformationService informationService;

    @InjectMocks
    private InformationController informationController;

    @Test
    public void handleInformation_shouldReturnInfoDetails_whenACodeIsProvided() throws Exception {
        String country = "Fiji";
        String description = "population";
        InfoDetailsDTO infoDetails = new InfoDetailsDTO();
        infoDetails.setCode("0001");
        infoDetails.setDescription("100000");
        BDDMockito.given(informationService.getInformation(country,description)).willReturn(infoDetails);

        ResponseEntity<InfoDetailsDTO> response = informationController.handleInformation(country, description);

        Assert.assertEquals(CODE_MESSAGE, response.getBody().getCode(), "0001");
        Assert.assertEquals(DESCRIPTION_MESSAGE, response.getBody().getDescription(), "100000");
        Mockito.verify(informationService).getInformation(country, description);
    }
}