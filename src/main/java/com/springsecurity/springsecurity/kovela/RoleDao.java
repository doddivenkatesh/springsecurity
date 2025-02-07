package com.springsecurity.springsecurity.kovela;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;







@Repository("roleDao")
public interface RoleDao extends JpaRepository<Role, Long> {
	
public List<CustomerRole> readCustomerRolesByCustomerId(Long customerId);
    
    public Role readRoleByName(String name);
    
//    public void addRoleToCustomer(CustomerRole customerRole);
//    
//    public void removeCustomerRolesByCustomerId(Long customerId);

}
