package com.test.project.test01.service;

import com.test.project.test01.dto.CompanyDto;
import com.test.project.test01.dto.ContactDto;
import com.test.project.test01.entity.CompanyEntity;
import com.test.project.test01.entity.ContactEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {
    CompanyEntity toCompanyEntity(CompanyDto dto);
    CompanyDto toCompanyDto(CompanyEntity entity);
}
