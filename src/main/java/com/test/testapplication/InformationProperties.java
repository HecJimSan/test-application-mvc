package com.test.testapplication;

import com.test.testapplication.repository.dto.CountryDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("countries")
public class InformationProperties {

    private final List<CountryDTO> list = new ArrayList<>();

    public List<CountryDTO> getList() {
        return this.list;
    }

}
