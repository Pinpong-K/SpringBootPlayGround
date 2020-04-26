package com.test.project.test01.service;

import com.test.project.test01.dto.CompanyDto;
import com.test.project.test01.dto.ContactDto;
import com.test.project.test01.entity.CompanyEntity;
import com.test.project.test01.entity.ContactEntity;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Mapper
public interface CompanyMapper
{
    @Mapping(target = "listOfContact", source = "contact")
    CompanyDto toCompanyDtoTest(CompanyEntity entity);

}
