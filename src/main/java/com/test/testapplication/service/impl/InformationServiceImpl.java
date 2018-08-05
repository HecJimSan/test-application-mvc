package com.test.testapplication.service.impl;


import com.test.testapplication.connector.DescriptionConnector;
import com.test.testapplication.connector.dto.DataCountryDTO;
import com.test.testapplication.connector.dto.DataItems;
import com.test.testapplication.controller.InfoDetailsDTO;
import com.test.testapplication.repository.CodeRepository;
import com.test.testapplication.service.InformationService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InformationServiceImpl implements InformationService {


    private CodeRepository codeRepository;
    private DescriptionConnector descriptionConnector;

    public InformationServiceImpl(CodeRepository codeRepository, DescriptionConnector descriptionConnector) {
        this.codeRepository = codeRepository;
        this.descriptionConnector = descriptionConnector;
    }

    @Override
    public InfoDetailsDTO getInformation(String country, String description) {
        String codeCountry = codeRepository.getCode(country);
        DataCountryDTO dataCountry = descriptionConnector.getDescriptionList(codeCountry);

        return buildDTO(description, codeCountry, dataCountry);
    }

    private InfoDetailsDTO buildDTO(String description, String codeCountry, DataCountryDTO dataCountry) {
        List<DataItems> dataItems = dataCountry.getDataCountry();
        DataItems dataItem =
                 dataItems
                .stream()
                .filter(x -> x.getCode().equals(description))
                .findFirst()
                .get();
        InfoDetailsDTO infoDetailsDTO = new InfoDetailsDTO();
        infoDetailsDTO.setDescription(dataItem.getDescription());
        infoDetailsDTO.setCode(codeCountry);
        return infoDetailsDTO;
    }
}
