package com.test.project.test01.service;

import com.test.project.test01.dto.AddressDto;
import com.test.project.test01.dto.CompanyDto;
import com.test.project.test01.entity.AddressEntity;
import com.test.project.test01.entity.CompanyEntity;
import com.test.project.test01.entity.ContactEntity;
import com.test.project.test01.entity.OwnerEntity;
import com.test.project.test01.repository.CompanyRepo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepo companyRepo;



    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }


    public CompanyDto createCompany(CompanyDto request) {

        CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);

       // create company
       /* CompanyEntity entity = CompanyEntity.builder()
                .address(AddressEntity.builder().address(request.getAddress().getAddress()).build())
                .companyName(request.getCompanyName())
                .listOfContact(null)
                .listOfOwner(null)
                .build();  */
        CompanyEntity entity = mapper.toCompanyEntity(request);
        //set FK to all child
        entity.getAddress().setCompany(entity);
        entity.getListOfOwner().forEach(a -> a.setCompany(entity));
        entity.getListOfContact().forEach(a -> a.setCompany(entity));


        companyRepo.save(entity);
        return request;
    }

    public CompanyDto getCompanyById(Long id)
    {
        return  null;
    }


}
