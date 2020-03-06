package com.test.project.test01.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "Company") // table name
@Entity
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String companyName;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<OwnerEntity> listOfOwner;

    @OneToOne(mappedBy = "company",cascade = CascadeType.ALL)
    private AddressEntity address;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ContactEntity> listOfContact;




}
