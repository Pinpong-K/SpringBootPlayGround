package com.test.project.test01.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "Contact") // table name
@Entity
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String contactName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_FK",nullable = false)
    @JsonIgnore
    private CompanyEntity company;



}
