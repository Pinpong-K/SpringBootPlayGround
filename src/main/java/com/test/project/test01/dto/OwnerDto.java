package com.test.project.test01.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data // all get and set
public class OwnerDto
{
    private String firstName;
    private String lastName;

}
