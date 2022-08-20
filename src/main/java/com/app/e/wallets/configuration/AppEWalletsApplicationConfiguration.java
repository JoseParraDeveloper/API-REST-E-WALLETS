package com.app.e.wallets.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.e.wallets.mapper.IMapper;

@Configuration
public class AppEWalletsApplicationConfiguration {

	@Bean
	public ModelMapper modelMapperPerson() {
		IMapper modelMapperPerson = () -> {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
			return modelMapper;
		};
		return modelMapperPerson.getModelMapper();
	}

}
