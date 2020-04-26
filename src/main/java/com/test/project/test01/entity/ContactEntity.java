package com.test.project.test01.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "contact") // table name
@Entity
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String telephone_number;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "fk_contact_company")
    private CompanyEntity company;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "fk_contact_person")
    private PersonEntity person;

}
