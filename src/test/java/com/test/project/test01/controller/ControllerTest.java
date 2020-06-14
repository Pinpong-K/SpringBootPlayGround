package com.test.project.test01.controller;

import com.mysql.cj.util.TestUtils;
import com.test.project.test01.dto.CompanyDto;
import com.test.project.test01.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void findCompany() throws Exception
    {
        CompanyDto dto = CompanyDto.builder().companyName("Thai-GamesComany").build();

        when(companyService.getCompanyByName("Thai-GamesComany")).thenReturn(dto);
        mockMvc.perform(get("/api/company/Thai-GamesComany")).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.company-name", is("Thai-GamesComany")));

    }

    @Test
    public void createCompany() throws Exception
    {
        CompanyDto dto = CompanyDto.builder().companyName("Thai-GamesComany").build();

        when(companyService.createCompany(dto)).thenReturn(dto);
        mockMvc.perform(post("/api/company")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"company-name\": \"Thai-GamesComany\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.company-name",is("Thai-GamesComany")));


    }


}