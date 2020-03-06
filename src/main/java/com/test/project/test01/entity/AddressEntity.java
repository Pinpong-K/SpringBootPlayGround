package com.test.project.test01.entity;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "Address") // table name
@Entity
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String address;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "COMPANY_FK")
    CompanyEntity company;

}
