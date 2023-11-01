package org.sid.customerservice;

import org.sid.customerservice.dto.CustomerDTO;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.mapper.CustomerMapper;
import org.sid.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		return args -> {
			customerRepository.saveAll(List.of(
					customerMapper.toEntity(CustomerDTO.builder().name("safa").email("safa@gmail.com").build()),
					customerMapper.toEntity(CustomerDTO.builder().name("azzouz").email("azzouz@gmail.com").build()),
					customerMapper.toEntity(CustomerDTO.builder().name("safaa").email("safaa@gmail.com").build()))
			);

			customerRepository.findAll().forEach(customer -> {
				CustomerDTO customerDTO = customerMapper.toDTO(customer);
				System.out.println(customerDTO);
			});
		};
	}
}
