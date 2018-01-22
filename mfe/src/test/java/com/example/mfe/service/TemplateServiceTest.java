package com.example.mfe.service;


import com.example.mfe.domain.templates.Template;
import com.example.mfe.repository.TemplateRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
public class TemplateServiceTest {

    @TestConfiguration
    static class TemplateServiceTestContextConfiguration {

        @Bean
        public TemplateService employeeService() {
            return new TemplateService();
        }
    }

    @Autowired
    private TemplateService templateService;

    @MockBean
    TemplateRepository templateRepository;


    @Before
    public void setUp() {
        String shortName = "templtexxx";

        Template t = new Template();
        t.setName("templtexxx");
        t.setShortName(shortName);
        t.setDefaultTemplate(false);
        t.setDescription("0");
        t.setValid(false);

        Mockito.when(templateRepository.findByShortName(t.getName()))
                .thenReturn(t);
    }


    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String shortName = "templtexxx";
        Template found = templateService.findByShortName(shortName);

        assertThat(found.getShortName())
                .isEqualTo(shortName);
    }



}
