package com.test.project.test01.dto;


import com.test.project.test01.entity.CompanyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data // all get and set
public class ContactDto {

    private Long id;
    private String contactName;

}
