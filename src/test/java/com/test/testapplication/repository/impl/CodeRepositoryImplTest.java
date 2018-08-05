package com.test.testapplication.repository.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CodeRepositoryImplTest {

    @Autowired
    private CodeRepositoryImpl codeRepository;

    @Test
    public void getCode_shouldReturnCodeGivenACountry() throws Exception {
        Assert.assertEquals("1234", codeRepository.getCode("fiji"));
        Assert.assertEquals("1235", codeRepository.getCode("spain"));
        Assert.assertEquals("1236", codeRepository.getCode("andorra"));
        Assert.assertEquals("1237", codeRepository.getCode("china"));
    }
}