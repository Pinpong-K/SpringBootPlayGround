package com.test.project.test01.service;

import com.test.project.test01.dto.ContactDto;
import com.test.project.test01.dto.PersonDto;
import com.test.project.test01.entity.ContactEntity;
import com.test.project.test01.entity.PersonEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Builder
@Data

public class PersonMapper {

    public PersonDto PersonEntityToPersonDto(PersonEntity entity)
    {
        if(entity == null)
            return null;

        PersonDto dto = PersonDto.builder().build();
        dto.setFirst_name(entity.getFirst_name());
        dto.setLast_name(entity.getLast_name());
        dto.setGenderEnum(entity.getGender());

        List<ContactDto> contactDtoList = new ArrayList<>();
        for (ContactEntity contact:entity.getContacts())
            contactDtoList.add(contactEntityToContactDto(contact));

        dto.setListofcontacts(contactDtoList);

        return  dto;
    }

    public PersonEntity PersonDtoToPersonEntity(PersonDto dto)
    {
        if(dto == null)
            return null;

        PersonEntity entity = PersonEntity.builder().build();
        entity.setFirst_name(dto.getFirst_name());
        entity.setLast_name(dto.getLast_name());
        entity.setGender(dto.getGenderEnum());

        List<ContactEntity> contactEntityList = new ArrayList<>();
        for (ContactDto contact:dto.getListofcontacts())
            contactEntityList.add(contactDtoToContactEntity(contact));

        entity.setContacts(contactEntityList);

        return entity;
    }


    public ContactDto contactEntityToContactDto(ContactEntity entity)
    {
        if(entity == null)
            return null;

        ContactDto dto = ContactDto.builder().build();
        dto.setTelephone_number(entity.getTelephone_number());

        return dto;
    }

    public ContactEntity contactDtoToContactEntity(ContactDto dto)
    {
        if(dto == null)
            return  null;

        ContactEntity entity = ContactEntity.builder().build();
        entity.setTelephone_number(dto.getTelephone_number());

        return entity;

    }
}
