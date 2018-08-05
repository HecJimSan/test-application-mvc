package com.test.testapplication.service;


import com.test.testapplication.controller.InfoDetailsDTO;

public interface InformationService {
    InfoDetailsDTO getInformation(String country, String description);
}
