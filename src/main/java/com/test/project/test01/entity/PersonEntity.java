package com.test.project.test01.entity;


import com.test.project.test01.constance.GenderEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "person") // table name
@Entity
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @OneToMany(mappedBy = "person",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ContactEntity> contacts;

    @OneToMany(mappedBy = "person",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<OwnerEntity> owners;

    @OneToOne(mappedBy = "person",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private EmployeeEntity employee;



}
