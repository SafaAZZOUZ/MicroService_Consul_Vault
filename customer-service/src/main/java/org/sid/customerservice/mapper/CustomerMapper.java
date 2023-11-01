package org.sid.customerservice.mapper;

import org.sid.customerservice.dto.CustomerDTO;
import org.sid.customerservice.entities.Customer;

public interface CustomerMapper {

    public Customer toEntity(CustomerDTO dto);
    public CustomerDTO toDTO(Customer entity);
}
