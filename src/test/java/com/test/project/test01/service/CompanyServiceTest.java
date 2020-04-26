package com.test.project.test01.service;

import com.test.project.test01.dto.CompanyDto;
import com.test.project.test01.entity.CompanyEntity;
import com.test.project.test01.repository.CompanyRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CompanyServiceTest {

    @Mock
    private CompanyRepo companyRepoTest;

    @InjectMocks
    private CompanyService companyServiceTest;

    @Test
    public void CreateCompanyTest()throws Exception
    {
        //when(companyRepoTest.save(any())).thenThrow(new Exception());
        CompanyDto dto = CompanyDto.builder().companyName("testcompany01").build();

        CompanyDto temDto = companyServiceTest.createCompany(dto);
        assertEquals("testcompany01",temDto.getCompanyName());

    }
}