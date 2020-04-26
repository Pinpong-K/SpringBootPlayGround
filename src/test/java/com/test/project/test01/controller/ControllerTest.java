package com.test.project.test01.controller;

import com.test.project.test01.dto.CompanyDto;
import com.test.project.test01.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ControllerTest {

    @MockBean
    private CompanyService companyService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findCompany() throws Exception {
        when(companyService.getCompanyById(123L)).thenReturn(CompanyDto.builder().companyName("123456789").build());
         mockMvc.perform(get("/api/company/123")).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.company-name", is("123456789")));

    }

}