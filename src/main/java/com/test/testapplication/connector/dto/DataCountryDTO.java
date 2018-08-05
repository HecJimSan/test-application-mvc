package com.test.testapplication.connector.dto;


import java.util.ArrayList;
import java.util.List;

public class DataCountryDTO {

    private List<DataItems> dataCountry = new ArrayList<DataItems>();

    public List<DataItems> getDataCountry() {
        return dataCountry;
    }

    public void setDataCountry(List<DataItems> dataCountry) {
        this.dataCountry = dataCountry;
    }
}
