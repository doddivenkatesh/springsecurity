package com.springsecurity.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.springsecurity.document.entity.AnnualEnterprise;
@Repository("annualEnterpriseDao")
public interface AnnualEnterpriseDao extends JpaRepository<AnnualEnterprise, Long>{

}
