package com.test.project.test01.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "Owner") // table name
@Entity
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "COMPANY_FK",nullable = false)
    @JsonIgnore
    private CompanyEntity company;

}
