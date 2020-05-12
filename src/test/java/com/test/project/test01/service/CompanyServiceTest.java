package com.test.project.test01.service;

import com.test.project.test01.dto.AddressDto;
import com.test.project.test01.dto.CompanyDto;
import com.test.project.test01.dto.ContactDto;
import com.test.project.test01.dto.PersonDto;
import com.test.project.test01.entity.AddressEntity;
import com.test.project.test01.entity.CompanyEntity;
import com.test.project.test01.entity.ContactEntity;
import com.test.project.test01.repository.CompanyRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
        //create mock up data
        List<ContactDto> contactEntityList = new ArrayList<>();
        List<PersonDto> personDtoList = new ArrayList<>();
        contactEntityList.add(ContactDto.builder().telephone_number("0885897594").build());

        CompanyDto mockUpCompany = CompanyDto.builder().companyName("Thai-GamesComany")
                .address(AddressDto.builder().address("42/3 m.8 Bkk").build())
                .listOfContact(contactEntityList)
                .listOfEmployee(personDtoList)
                .listOfOwner(personDtoList)
                .build();

        //when(companyRepoTest.save(any())).thenReturn(mockUpCompany);

        CompanyDto founderCompany = companyServiceTest.createCompany(mockUpCompany);
        assertEquals("Thai-GamesComany",founderCompany.getCompanyName());


    }
}