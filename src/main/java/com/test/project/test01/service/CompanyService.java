package com.test.project.test01.service;

import com.test.project.test01.dto.*;
import com.test.project.test01.entity.*;
import com.test.project.test01.repository.CompanyRepo;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompanyService {

    private final CompanyRepo companyRepo;



    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }


    public CompanyDto createCompany(CompanyDto request) throws Exception {

        CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);
        PersonMapper personMapper = PersonMapper.builder().build();

        List<OwnerEntity> ownerEntityList = new ArrayList<>();
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        List<ContactEntity> contactEntityList = new ArrayList<>();

        // create company
        /* CompanyEntity entity = CompanyEntity.builder()
                .address(AddressEntity.builder().address(request.getAddress().getAddress()).build())
                .companyName(request.getCompanyName())
                .listOfContact(null)
                .listOfOwner(null)
                .build();  */
        //PersonalEntity  personal =

        //create company
        CompanyEntity company = CompanyEntity.builder()
                .companyName(request.getCompanyName())
                .address(AddressEntity.builder().address(request.getAddress().getAddress()).build())
                .build();

        //create contact
        for (ContactDto contactDto :request.getListOfContact()) {
            ContactEntity contactEntity = personMapper.contactDtoToContactEntity(contactDto);
            //set fk key
            contactEntity.setCompany(company);
            contactEntityList.add(contactEntity);
        }

        //create owner
        for (PersonDto ownerDto :request.getListOfOwner()) {
            OwnerEntity ownerEntity = OwnerEntity.builder().person(personMapper.PersonDtoToPersonEntity(ownerDto)).build();
            //set fk key
            ownerEntity.setCompany(company);
            ownerEntityList.add(ownerEntity);
        }

        //create employee
        for (PersonDto employeeDto:request.getListOfEmployee() ) {
            EmployeeEntity employee = EmployeeEntity.builder().person(personMapper.PersonDtoToPersonEntity(employeeDto)).build();
            //set fk key
            employee.setCompany(company);
            employeeEntityList.add(employee);
        }

        company.setContact(contactEntityList);
        company.setOwner(ownerEntityList);
        company.setEmployees(employeeEntityList);

        //set FK to all child
        company.getAddress().setCompany(company);


        companyRepo.save(company);
        return request;

    }

    public CompanyDto getCompanyById(Long id)
    {
        CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);
        CompanyDto companyDto = mapper.toCompanyDtoTest(companyRepo.getOne(id));
        return  companyDto;
    }


    public List<CompanyDto> getCompanyByNameContaining(String name)
    {
        CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);
        List<CompanyDto> companyDtoList = new ArrayList<>();
        companyRepo.findByCompanyNameContaining(name).forEach(ce -> companyDtoList.add(mapper.toCompanyDtoTest(ce)));

        return companyDtoList;
    }

    public CompanyDto getCompanyByName(String name)
    {
        //Init mapper
        CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);
        PersonMapper personMapper = PersonMapper.builder().build();

        //get company entity and convent to DTO
        CompanyEntity entity = companyRepo.findByCompanyName(name);
        CompanyDto companyDto = mapper.toCompanyDtoTest(entity);
        companyDto.setListOfEmployee(entity.getEmployees().stream().map(
                a -> personMapper.PersonEntityToPersonDto(a.getPerson())
                ).collect(Collectors.toList()));
        companyDto.setListOfOwner(entity.getOwner().stream().map(
                a -> personMapper.PersonEntityToPersonDto(a.getPerson())
        ).collect(Collectors.toList()));

        return  companyDto;
    }


}
