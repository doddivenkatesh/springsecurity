package com.springsecurity.springsecurity.kovela;

import java.util.List;

public interface RoleService {

	 public List<CustomerRole> findCustomerRolesByCustomerId(Long customerId);
}
