package com.email.support.service.impl;

import com.email.support.service.PropertiesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PropertiesServiceImplTest {
    private static final String WRONG_PROP = "wrong.prop";
    private static PropertiesService propertiesService;

    @BeforeAll
    static void beforeAll() {
        propertiesService = new PropertiesServiceImpl();
    }

    @Test
    public void getWrongPropertyTest_ok() {
        Assertions.assertThrows(RuntimeException.class,
                () -> propertiesService.getProperty(WRONG_PROP));
    }
}
