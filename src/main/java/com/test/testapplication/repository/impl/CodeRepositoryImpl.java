package com.test.testapplication.repository.impl;

import com.test.testapplication.InformationProperties;
import com.test.testapplication.repository.CodeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CodeRepositoryImpl implements CodeRepository {

    private InformationProperties informationProperties;

    public CodeRepositoryImpl(InformationProperties informationProperties) {
        this.informationProperties = informationProperties;
    }

    @Override
    public String getCode(String country) {
        return informationProperties.getList()
                .stream()
                .filter(x -> x.getCountry().equals(country.toLowerCase()))
                .findFirst()
                .get().getCode();
    }
}
