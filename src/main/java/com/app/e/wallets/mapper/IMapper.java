package com.app.e.wallets.mapper;

import org.modelmapper.ModelMapper;

@FunctionalInterface
public interface IMapper {
	public ModelMapper getModelMapper();
}
