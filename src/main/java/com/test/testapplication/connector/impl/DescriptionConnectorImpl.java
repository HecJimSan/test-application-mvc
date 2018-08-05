package com.test.testapplication.connector.impl;

import com.test.testapplication.connector.DescriptionConnector;
import com.test.testapplication.connector.dto.DataCountryDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DescriptionConnectorImpl implements DescriptionConnector {

    @Value("${url}")
    private String url;

    private RestTemplate restTemplate;

    public DescriptionConnectorImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public DataCountryDTO getDescriptionList(String codeCountry) {
        ResponseEntity<DataCountryDTO> responseEntity = restTemplate.getForEntity(url + "/country/" + codeCountry, DataCountryDTO.class);
        return responseEntity.getBody();
    }
}
