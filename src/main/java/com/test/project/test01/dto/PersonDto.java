package com.test.project.test01.dto;

import com.test.project.test01.constance.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data // all get and set
public class PersonDto {

    private String first_name;

    private String last_name;

    private GenderEnum genderEnum;

    private List<ContactDto> listofcontacts;

}
