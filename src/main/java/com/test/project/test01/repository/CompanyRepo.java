package com.test.project.test01.repository;


import com.test.project.test01.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity,Long>
{




}
