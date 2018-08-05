package com.test.testapplication.repository.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CodeRepositoryImplTest {

    @Autowired
    private CodeRepositoryImpl codeRepository;

    @Test
    public void getCode_shouldReturnCodeGivenACountry() throws Exception {
        assertEquals("1234", codeRepository.getCode("fiji"));
        assertEquals("1235", codeRepository.getCode("spain"));
        assertEquals("1236", codeRepository.getCode("andorra"));
        assertEquals("1237", codeRepository.getCode("china"));
    }
}