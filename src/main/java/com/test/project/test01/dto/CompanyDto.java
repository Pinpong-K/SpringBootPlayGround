package com.test.project.test01.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.project.test01.entity.AddressEntity;
import com.test.project.test01.entity.ContactEntity;
import com.test.project.test01.entity.OwnerEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data // all get and set

public class CompanyDto {

    @JsonProperty(value = "company-name")
    private String companyName;

    private AddressDto address;

    private List<ContactDto> listOfContact;

    private List<PersonDto> listOfOwner;

    private List<PersonDto> listOfEmployee;




}
