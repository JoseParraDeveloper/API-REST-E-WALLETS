package com.app.e.wallets;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.app.e.wallets.dto.PersonDto;
import com.app.e.wallets.entities.Person;
import com.app.e.wallets.exceptions.ResourceNotFoundException;
import com.app.e.wallets.repository.IPersonRepository;

@SpringBootApplication
public class AppEWalletsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication
				.run(AppEWalletsApplication.class, args);

//		IPersonRepository personRepository = configurableApplicationContext.getBean(IPersonRepository.class);
//		ModelMapper mapperPerson = configurableApplicationContext.getBean(ModelMapper.class);
//
//		Person person = personRepository.findById(1L).orElse(new Person());
//
//		PersonDto dto = mapperPerson.map(person, PersonDto.class);
//		System.out.println(dto.toString());

		ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException(Person.class.getName(),
				"Id", "2000");
	

		System.out.println(resourceNotFoundException.getMessage());

	}

}
