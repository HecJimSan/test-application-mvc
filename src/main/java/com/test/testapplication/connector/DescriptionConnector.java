package com.test.testapplication.connector;


import com.test.testapplication.connector.dto.DataCountryDTO;

public interface DescriptionConnector {
    DataCountryDTO getDescriptionList(String codeCountry);
}
