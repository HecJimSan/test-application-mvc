package com.test.testapplication.service.impl;

import com.test.testapplication.connector.DescriptionConnector;
import com.test.testapplication.connector.dto.DataCountryDTO;
import com.test.testapplication.connector.dto.DataItems;
import com.test.testapplication.controller.InfoDetailsDTO;
import com.test.testapplication.repository.CodeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class InformationServiceImplTest {

    public static final String CODE_COUNTRY = "1234";
    @Mock
    private CodeRepository codeRepository;

    @Mock
    private DescriptionConnector descriptionConnector;

    @InjectMocks
    private InformationServiceImpl informationService;

    @Test
    public void getInformation_shouldReturnCorrectDescriptionForTheCountrySelected() throws Exception {
        String country = "00001";
        String description = "population";
        BDDMockito.given(codeRepository.getCode(country)).willReturn(CODE_COUNTRY);
        DataCountryDTO dataCountry = new DataCountryDTO();
        ArrayList<DataItems> dataItemsArrayList = new ArrayList<>();
        dataItemsArrayList.add(getDataItems("population", "10000 people"));
        dataItemsArrayList.add(getDataItems("islands", "3 islands"));
        dataItemsArrayList.add(getDataItems("cities", "10 cities"));
        dataCountry.setDataCountry(dataItemsArrayList);
        BDDMockito.given(descriptionConnector.getDescriptionList(CODE_COUNTRY)).willReturn(dataCountry);

        InfoDetailsDTO information = informationService.getInformation(country, description);

        Assert.assertEquals("10000 people",information.getDescription());
        Assert.assertEquals(CODE_COUNTRY,information.getCode());
        verify(descriptionConnector).getDescriptionList(CODE_COUNTRY);
        verify(codeRepository).getCode(country);

    }

    private DataItems getDataItems(String code, String description) {
        DataItems dataItems = new DataItems();
        dataItems.setCode(code);
        dataItems.setDescription(description);
        return dataItems;
    }
}