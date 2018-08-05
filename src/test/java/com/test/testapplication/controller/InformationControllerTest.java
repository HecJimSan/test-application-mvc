package com.test.testapplication.controller;

import com.test.testapplication.service.InformationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InformationControllerTest {

    public static final String CODE_MESSAGE = "response should contains code";
    public static final String DESCRIPTION_MESSAGE = "response should contains description";

    private InformationService informationService;
    private InformationController informationController;

    @Before
    public void setUp() throws Exception {
        informationService = mock(InformationService.class);
        informationController = new InformationController(informationService);
    }

    @Test
    public void handleInformation_shouldReturnInfoDetails_whenACodeIsProvided() throws Exception {
        String country = "Fiji";
        String description = "population";
        InfoDetailsDTO infoDetails = new InfoDetailsDTO();
        infoDetails.setCode("0001");
        infoDetails.setDescription("100000");
        BDDMockito.given(informationService.getInformation(country,description)).willReturn(infoDetails);

        ResponseEntity<InfoDetailsDTO> response = informationController.handleInformation(country, description);

        assertEquals(CODE_MESSAGE, response.getBody().getCode(), "0001");
        assertEquals(DESCRIPTION_MESSAGE, response.getBody().getDescription(), "100000");
        verify(informationService).getInformation(country, description);
    }
}